package InterviewProgramming.com.interview.codes;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private final int accountNumber;
    private int balance;
    private final ReentrantLock lock=new ReentrantLock();

    Account(int accountNumber,int balance)
    {
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    public int getAccountNumber()
    {
        return this.accountNumber;
    }
    public int getBalance()
    {
        return this.balance;
    }
    public void setBalance(int balance)
    {
        this.balance=balance;
    }
    public ReentrantLock getLock()
    {
        return this.lock;
    }
}

class Transaction{
    private final String txnId;
    private final int accountId;
    private final int amount;
    private final String type;
    private final LocalDateTime timestamp;

    public Transaction(String txnId, int accountId, int amount, String type, LocalDateTime timestamp) {
        this.txnId = txnId;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txnId='" + txnId + '\'' +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

class Services{

    private final Map<Integer,Account> accounts=new ConcurrentHashMap<>();
    private final Set<String> processedTxn=ConcurrentHashMap.newKeySet();
    private final List<Transaction> auditLog= Collections.synchronizedList(new ArrayList<>());

    public void createAccount(int accountId,int balance)
    {
        accounts.put(accountId,new Account(accountId,balance));
    }

    public void credit(int accountId,int amount,String txnId)
    {
        if(!processedTxn.add(txnId))
            throw new RuntimeException("Duplicate payment!!");

        Account account=accounts.get(accountId);

        if(Objects.isNull(account))
            throw new RuntimeException("Account not found!!");

        account.getLock().lock();

        try {
            account.setBalance(account.getBalance()+amount);
            auditLog.add(new Transaction(txnId,accountId,amount,"CREDIT",LocalDateTime.now()));
        }finally {
            account.getLock().unlock();
        }
    }

    public void debit(int accountId,int amount,String txnId)
    {
        if(!processedTxn.add(txnId))
            throw new RuntimeException("Duplicate payment!!");

        Account account=accounts.get(accountId);

        if(Objects.isNull(account))
            throw new RuntimeException("Account not found!!");

        account.getLock().lock();

        try {
            account.setBalance(account.getBalance()-amount);
            auditLog.add(new Transaction(txnId,accountId,amount,"DEBIT",LocalDateTime.now()));
        }finally {
            account.getLock().unlock();
        }
    }

    public int getBalance(int accountId)
    {
        return accounts.get(accountId).getBalance();
    }
}

public class CreditAndDebitAPIProductionReadyCode {

    public static void main(String[] args) {

        Services service=new Services();

        service.createAccount(101,1000);

        ExecutorService executor= Executors.newFixedThreadPool(2);

        for(int i=1;i<10;i++)
        {
            int txnId=i;
            executor.submit(()->{
                try {
                    service.debit(101,10,"TXN-"+txnId);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()){}

        System.out.println(service.getBalance(101));
    }
}
