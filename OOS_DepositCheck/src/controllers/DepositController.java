package controllers;

import java.util.Date;
import java.util.Map;

import accounts.Account;
import accounts.AccountsManager;
import customers.Member;
import customers.MemberManager;
import models.AuthorizationRules;
import transactions.Deposit;

public class DepositController {

//	private BankingSystem bankingSystem;
	private AuthorizationRules authorizationRules;
	private MemberManager memMan;
	private AccountsManager accMan;
	private Account account;
	
	public DepositController(AuthorizationRules authRules, AccountsManager accMan, MemberManager memMan) {
//	    this.bankingSystem = bankingSystem;
	    this.authorizationRules = authRules;
	    this.accMan = accMan;
	    this.memMan = memMan;
	    
//	    processInput();
//	    accessAccount();
	    
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
	
	public boolean makeDeposit(int amount, Date date) throws Exception {
	    throw new Exception("DepositController.makeDeposit: method not yet implemented");
	}
	
}
