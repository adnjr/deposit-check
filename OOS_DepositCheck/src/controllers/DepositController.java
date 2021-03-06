package controllers;

import java.util.Map;

import accounts.Account;
import accounts.AccountsManager;
import members.MemberManager;
import misc.AuthorizationRules;
import readers.DepositReader;
import readers.DepositReaderFactory;
import transactions.Deposit;
import transactions.TransactionLog;

/*
 * Session Controller, High Cohesion: Using a DepositController to handle
 * deposit operations increases cohesion, by allowing a secondary controller
 * to shoulder the responsibility, instead of the primary controller handling
 * everything.
 */
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

	// Session Controller: this operation handles account access for deposits
	public boolean accessAccount(Map<String, String> formInput) {        
		long memberID = -1;
		long acctID;
		
		try {
			acctID = Long.parseLong(formInput.get("accountID"));
			this.account = accMan.getAccountOf(acctID);
			if (this.account == null) {
			    System.err.println("Account " + acctID + " not found.");
			    System.exit(1);
			}
			
	        if (!formInput.get("memberID").isEmpty())
	        	memberID = Integer.parseInt(formInput.get("memberID"));
	        else
	        	memberID = memMan.getMemberIDOf(formInput.get("memberFullName"));
		} catch (NumberFormatException e) {
			System.err.println("Error: either account ID or member ID is invalid. Enter a number for those fields.");
			System.exit(1);
		}
	    return this.account.isAccessAuthorized(memberID);
	}
	
	// Session Controller: this operation handles authorization for deposits
	public boolean authorizeDeposit() {
	    return this.authorizationRules.isTransactionAuthorized(
	    		this.account.getAccountType(),
	    		this.account.getStatus(),
	            Deposit.TRANSACTION_TYPE);
	}
	
	// Session Controller: this operation creates the deposit
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
