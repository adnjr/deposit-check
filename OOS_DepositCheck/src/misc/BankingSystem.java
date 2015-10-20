package misc;

import java.util.HashMap;
import java.util.Map;

import com.asprise.ocr.Ocr;

import accounts.Account;
import members.Member;
import transactions.Deposit;
import transactions.Transaction;

public class BankingSystem {
	private Map<Long, Account> accounts;
	private Map<Long, Member> members;
	private Map<Long, Transaction> transactions;
	
	public static void main(String[] args) {
	    Ocr.setUp();
	}

	public BankingSystem() {
		this.accounts = new HashMap<Long, Account>();
		this.members = new HashMap<Long, Member>();
		this.transactions = new HashMap<Long, Transaction>();
	}

	public Account getAccount(Integer accountNumber) {
		return this.accounts.get(accountNumber);
	}
	
	public Member getMember(Integer memberID) {
		return this.members.get(memberID);
	}
	
	// TODO change this to create the Deposit object from its initializing information
	public boolean addDeposit(Deposit deposit) {
	    this.transactions.put(deposit.getTransactionID(), deposit);
	    return true;
	}
}
