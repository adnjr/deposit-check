package models;

import java.util.HashMap;
import java.util.Map;

import com.asprise.ocr.Ocr;

import accounts.Account;
import customers.Member;
import models.transactions.Deposit;
import models.transactions.Transaction;

public class BankingSystem {
	private Map<Integer, Account> accounts;
	private Map<Integer, Member> customers;
	private Map<Integer, Transaction> transactions;
	
	public static void main(String[] args) {
	    Ocr.setUp();
	}

	public BankingSystem() {
		this.accounts = new HashMap<Integer, Account>();
		this.customers = new HashMap<Integer, Member>();
		this.transactions = new HashMap<Integer, Transaction>();
	}

	public Account getAccount(Integer accountNumber) {
		return this.accounts.get(accountNumber);
	}
	
	public Member getCustomer(Integer customerID) {
		return this.customers.get(customerID);
	}
	
	// TODO change this to create the Deposit object from its initializing information
	public boolean addDeposit(Deposit deposit) {
	    this.transactions.put(deposit.getTransactionID(), deposit);
	    return true;
	}
}
