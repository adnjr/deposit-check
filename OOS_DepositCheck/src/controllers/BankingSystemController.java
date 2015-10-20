package controllers;

import java.io.Console;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounts.Account;
import accounts.AccountsManager;
import members.MemberManager;
import models.AuthorizationRules;
import models.BankingSystem;
import transactions.Transaction;
import transactions.TransactionLog;

public class BankingSystemController {
    
    private BankingSystem bankSys;
    private DepositController depCon;
    private TransactionLog transLog;
    private AuthorizationRules authRules;
    private AccountsManager accMan;
    private MemberManager memMan;
    
    public BankingSystemController() {
        transLog = new TransactionLog();
        authRules = new AuthorizationRules();
        transLog = new TransactionLog();
        memMan = new MemberManager();
        accMan = new AccountsManager(memMan);
        depCon = new DepositController(authRules, accMan, memMan, transLog);
    }
    
    public void readCheckDeposit(String inputType) {
    	Map<String, String> formInput;
    	
        formInput = promptForInfo();
        
        if (depCon.accessAccount(formInput) == false)
        	errExit("Account access denied: the specified member is not permitted to access this account.");
        
        if (depCon.authorizeDeposit() == false)
        	errExit("Deposit denied: deposits are not permitted on accounts of this type and status");
        
        if (depCon.makeDeposit(formInput) == false)
        	errExit("Deposit failed: an unknown error occured");
        
        
    }
    
    // uses inputType to distinguish between check image or pdf file (or future types)
    public void readCheckDeposit(String inputType, String fileName) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public String getAllAccountInfo() {
        Collection<Account> accounts;
        List<Transaction> acctTransactions;
        String str = "";
        
        accounts = accMan.getAccounts();
        for (Account acct : accounts) {
            
            str = str + acct.toString() + "\n";

            for (Integer memberID : acct.getMembers())
                str = str + "\t" + memMan.getMember(memberID).toString() + "\n";
            
            acctTransactions = transLog.getAccountTransactions(acct.getAccountNumber());
            for (Transaction trans : acctTransactions)
                str = str + "\t" + trans.toString() + "\n";
        }
        
        return str;
    }
    
    private void errExit(String message) {
    	Console console;
    	
    	if ( (console = System.console()) != null)
			console.format("%s%n", message);
    	else
    		System.err.println(message);
    	
    	System.exit(1);
    }
    
    private Map<String, String> promptForInfo() {
        Console console;
        Map<String, String> formInput;
        String memberFullName = "";
        String accountStr = "";
        String routingStr = "";
        String memberStr = "";
        String amountStr = "";
        
        formInput = new HashMap<String, String>();
        System.out.println("Enter the following check information:");
        
        if ( (console = System.console()) == null)
            throw new RuntimeException("Console unavailable. Console input required.");
        
        do {
            try {
                accountStr = console.readLine("Account ID: ").trim();
                routingStr = console.readLine(("Routing Number: ")).trim();
                memberStr = console.readLine("Member ID: ").trim();
                memberFullName = console.readLine("Full Name").trim();
                amountStr = console.readLine("Deposit Amount: ").trim();
                
            } catch (NumberFormatException e) {
                System.out.println("You must enter a valid account ID, routing number, and either full name or ID of member");
                continue;
            }
        } while(accountStr.isEmpty() || routingStr.isEmpty() || (memberFullName.isEmpty() && memberStr.isEmpty()));
        
        formInput.put("accountID", accountStr);
        formInput.put("routingNum", routingStr);
        formInput.put("memberID", memberStr);
        formInput.put("memberFullName", memberFullName);
        formInput.put("amount", amountStr);

        return formInput;
    }
    
    public void addMember(String fName, String mName, String lName, int memberID) {
    	memMan.addMember(memberID, fName, mName, lName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, double initBalance, int memberID) {
    	int balance = (int)(initBalance * 10);
        accMan.addAccount(accountType, accountID, routingNum, balance, memberID);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int initBalance, int memberID) {
    	int balance = initBalance * 10;
        accMan.addAccount(accountType, accountID, routingNum, balance, memberID);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, double initBalance, String fullName) {
    	int balance = (int)(initBalance * 10);
        accMan.addAccount(accountType, accountID, routingNum, balance, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int initBalance, String fullName) {
    	int balance = initBalance * 10;
        accMan.addAccount(accountType, accountID, routingNum, balance, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, String fullName) {
        accMan.addAccount(accountType, accountID, routingNum, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int memberID) {
        accMan.addAccount(accountType, accountID, routingNum, memberID);
    }
    
    

}
