package com.example.designpattern;

import java.util.ArrayList;
import java.util.List;

//It is structural design pattern. Used to combine two or more object
abstract class Account{
	public abstract int getBalance();
}
class SavingAccount extends Account{
	int accountBal;
	String AccountType;
	SavingAccount(String type,int bal)
	{
		this.AccountType=type;
		this.accountBal=bal;
	}
	@Override
	public int getBalance()
	{
		return this.accountBal;
	}
}
class DepositAccount extends Account{
	int accountBal;
	String AccountType;
	DepositAccount(String type,int bal)
	{
		this.AccountType=type;
		this.accountBal=bal;
	}
	@Override
	public int getBalance()
	{
		return this.accountBal;
	}
}
class CompositeAccount extends Account
{
	List<Account> account=new ArrayList<>();
	@Override
	public int getBalance()
	{
		int total=0;
		for(Account acc:account)
			total+=acc.getBalance();
		return total;
	}
	public void AddAccount(Account acc)
	{
		account.add(acc);
	}
	public void remove(Account acc)
	{
		account.remove(acc);
	}
}
public class CompositeDesignPattern {

	public static void main(String[] args) {
		SavingAccount sa1=new SavingAccount("save",12);
		DepositAccount dep1=new DepositAccount("dep",20);
		CompositeAccount ca=new CompositeAccount();
		ca.AddAccount(sa1);
		ca.AddAccount(dep1);
		System.out.println(ca.getBalance());
	}

}
