package controllers;

import java.util.Date;
import java.util.Map;

import accounts.Account;
import accounts.AccountsManager;
import customers.MemberManager;
import models.AuthorizationRules;
import readers.DepositReader;
import readers.DepositReaderFactory;
import transactions.Deposit;
import transactions.TransactionLog;

public class DepositController {

	private AuthorizationRules authorizationRules;
	private TransactionLog transLog;
	private MemberManager memMan;
	private AccountsManager accMan;
	private Account account;
	
	public DepositController(AuthorizationRules authRules, AccountsManager accMan, MemberManager memMan, TransactionLog transLog) {
	    this.authorizationRules = authRules;
	    this.accMan = accMan;
	    this.memMan = memMan;
	    this.transLog = transLog;
	}	

	public boolean accessAccount(Map<String, String> formInput) {        
		int memberID;
		
		this.account = accMan.getAccountOf(Integer.parseInt(formInput.get("accountID")));
		
        if (!formInput.get("memberID").isEmpty())
        	memberID = Integer.parseInt(formInput.get("memberID"));
        else
        	memberID = memMan.getMemberIDOf(formInput.get("memberFullName"));
		
	    return this.account.isAccessAuthorized(memberID);
	}
	
	public boolean authorizeDeposit() {
	    return this.authorizationRules.isTransactionAuthorized(
	    		this.account.getAccountType(),
	    		this.account.getStatus(),
	            Deposit.TRANSACTION_TYPE);
	}
	
	public boolean makeDeposit(Map<String, String> input) {
		DepositReader reader;
		Map<String, String> depInfo;
		
		input.put("previousBalance", String.valueOf(account.getBalance()));
		
		reader = DepositReaderFactory.getFactory().getDepositReader("text", input);
		depInfo = reader.getDepositInfo();
		
		transLog.addTransaction("deposit", depInfo);
		
		return true;
	}
	
}
