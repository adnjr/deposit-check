package controllers;

import java.io.Console;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounts.Account;
import accounts.AccountsManager;
import members.MemberManager;
import misc.AuthorizationRules;
import transactions.Transaction;
import transactions.TransactionLog;

/* Controller, Indirection, Facade, Protected Variations:
 * This is a facade controller, that provides an interface for the UI layer to
 * interact with the application and domain logic.  This separation of concerns
 * adds a level of Indirection between the UI and application logic, which
 * protects one from the other's variability.
 */
public class BankingSystemController {
    
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
    
    // Controller: this system operation should be implemented by the top-level controller 
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
    
    // Controller: this system operation should be implemented by the top-level controller
    public void readCheckDeposit(String inputType, String fileName) {
        throw new RuntimeException("Not yet implemented");
    }
    
    // Controller: this system operation should be implemented by the top-level controller
    public String getAllAccountInfo() {
        Collection<Account> accounts;
        List<Transaction> acctTransactions;
        String str = "";
        
        accounts = accMan.getAccounts();
        for (Account acct : accounts) {
            
            str = str + acct.toString() + "\n";

            for (Long memberID : acct.getMembers())
                str = str + "\t" + memMan.getMember(memberID).toString() + "\n";
            
            acctTransactions = transLog.getAccountTransactions(acct.getAccountNumber());
            for (Transaction trans : acctTransactions)
                str = str + "\t" + trans.toString();
        }
        
        return str;
    }
    
    // private helper method: prints an error and exits
    private void errExit(String message) {
    	Console console;
    	
    	if ( (console = System.console()) != null)
			console.format("%s%n", message);
    	else
    		System.err.println(message);
    	
    	System.exit(1);
    }
    
    // this is a substitute for obtaining information by filling out a web form
    private Map<String, String> promptForInfo() {
        Console console;
        Map<String, String> formInput;
        String memberFullName = "";
        String accountStr = "";
        String routingStr = "";
        String memberStr = "";
        String amountStr = "";
        
        formInput = new HashMap<String, String>();
        
        if ( (console = System.console()) == null)
            throw new RuntimeException("Console unavailable. Console input required. Please run program from the command line.");
        
        do {
        	System.out.println("\nEnter the following check information:");
            try {
                accountStr = console.readLine("Account ID: ").trim();
                routingStr = console.readLine(("Routing Number: ")).trim();
                memberStr = console.readLine("Member ID: ").trim();
                memberFullName = console.readLine("Full Name: ").trim();
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
    
    // Controller: this system operation should be implemented by the top-level controller
    public void addMember(String fName, String mName, String lName, Long memberID) {
    	memMan.addMember(memberID, fName, mName, lName);
    }
    
    // Controller: this system operation should be implemented by the top-level controller    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Double initBalance, Long memberID) {
    	Long balance = (long)(initBalance * 10);
        return accMan.addAccount(accountType, accountID, routingNum, balance, memberID);
    }
    
    // Controller: this system operation should be implemented by the top-level controller    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Double initBalance, String fullName) {
    	Long balance = (long)(initBalance * 10);
    	return accMan.addAccount(accountType, accountID, routingNum, balance, fullName);
    }

    // Controller: this system operation should be implemented by the top-level controller
    public boolean addAccount(String accountType, Long accountID, Long routingNum, String fullName) {
    	return accMan.addAccount(accountType, accountID, routingNum, fullName);
    }
    
    // Controller: this system operation should be implemented by the top-level controller
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Long memberID) {
    	return accMan.addAccount(accountType, accountID, routingNum, memberID);
    }
    
    

}
