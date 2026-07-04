package SystemDesign.com.java.APIs.CreditDebitApp;

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

    public int getAccountId()
    {
        return this.accountId;
    }
    public String getTxnId()
    {
        return this.txnId;
    }

    public int getAmount()
    {
        return this.amount;
    }
    public String getType()
    {
        return this.type;
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
            auditLog.add(new Transaction(txnId,accountId,amount,"DEBIT ",LocalDateTime.now()));
        }finally {
            account.getLock().unlock();
        }
    }

    public int getBalance(int accountId)
    {
        return accounts.get(accountId).getBalance();
    }

    public void printStatement(int accountId) {

        Account account = accounts.get(accountId);

        System.out.println("\n===== ACCOUNT STATEMENT =====");

        synchronized (auditLog) {

            for (Transaction tx : auditLog) {

                if (tx.getAccountId() == accountId) {

                    System.out.println(
                            tx.getType()
                                    + " | "
                                    + tx.getAmount()
                                    + " | "
                                    + tx.getTxnId());
                }
            }
        }

        System.out.println(
                "Current Balance : "
                        + account.getBalance());

        System.out.println("=============================");
    }
}

public class CreditAndDebitAPIProductionReadyCode {

    public static void main(String[] args) {

        Services service=new Services();

        service.createAccount(101,1000);

        ExecutorService executor= Executors.newFixedThreadPool(2);

        for(int i=1;i<5;i++) {
            int txnId = i;
            executor.submit(() -> {
                try {
                    service.debit(101, 10, "TXN-" + txnId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        for(int i=5;i<10;i++)
        {
            int txnId = i;
            executor.submit(()->{
                try {
                    service.credit(101,11,"TXN-"+txnId);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()){}

        System.out.println("Final balance : "+service.getBalance(101));

        service.printStatement(101);
    }
}
