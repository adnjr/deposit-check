package controllers;

import java.util.Date;
import java.util.Map;

import models.Account;
import models.AuthorizationRules;
import models.transactions.Deposit;

public class DepositController {

//	private BankingSystem bankingSystem;
	private AuthorizationRules authorizationRules;
	private Account account;
	
	public DepositController(Map<String, String> formInput, AuthorizationRules authRules) {
//	    this.bankingSystem = bankingSystem;
	    this.authorizationRules = authRules;
	    
	    
	    processInput();
	    accessAccount();
	    
	}
	
	
	
	public boolean accessAccount(int accountNumber, int customerID) {
	    this.account = bankingSystem.getAccount(accountNumber);
	    return this.account.isAccessAuthorized(customerID);
	}
	
	public boolean authorizeDeposit() throws Exception {
	    String acctType = this.account.getAccountType();
	    String acctStatus = this.account.getStatus();
	    return this.authorizationRules.isTransactionAuthorized(
	            acctType, acctStatus, Deposit.TRANSACTION_TYPE);
	}
	
	public boolean makeDeposit(int amount, Date date) throws Exception {
	    throw new Exception("DepositController.makeDeposit: method not yet implemented");
	}
	
}
