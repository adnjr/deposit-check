package controllers;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import accounts.AccountsManager;
import customers.MemberManager;
import models.AuthorizationRules;
import models.BankingSystem;
import models.TransactionLog;

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
        depCon = new DepositController(authRules);
    }
    
    public void readCheckDeposit(String inputType) {
    	Map<String, String> formInput;
    	String memberIdentification;
    	
        // TODO implement this
        
        // prompt user and collect information
        formInput = promptForInfo();
        
        // pass the information to the deposit controller
        memberIdentification = formInput.get("memberID");
        if (memberIdentification.isEmpty())
        	memberIdentification = formInput.get("memberFullName");
        
        
        depCon.accessAccount(formInput);
        
        throw new RuntimeException("Not yet implemented");
    }
    
 // uses inputType to distinguish between check image or pdf file (or future types)
    public void readCheckDeposit(String inputType, String fileName) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    private Map<String, String> promptForInfo() {
        Console console;
        Map<String, String> formInput;
        String memberFullName = "";
        String accountStr = "";
        String routingStr = "";
        String memberStr = "";
        String balanceStr = "";
        
        formInput = new HashMap<String, String>();
        System.out.println("Enter the following check information:");
        
        if ( (console = System.console()) == null)
            throw new RuntimeException("Console unavailable. Console input required.");
        do {
            try {
                accountStr = console.readLine("Account ID: ").trim();
                routingStr = console.readLine(("Routing Number: ")).trim();
                memberStr = console.readLine("Member ID: ").trim();
                memberFullName = console.readLine("Member Full Name").trim();
                balanceStr = console.readLine("Initial Balance: ").trim();
                
            } catch (NumberFormatException e) {
                System.out.println("You must enter the account ID, routing number, and either full name or ID of member");
                continue;
            }
        } while(accountStr.isEmpty() || routingStr.isEmpty() || (memberFullName.isEmpty() && memberStr.isEmpty()));
        
        formInput.put("accountID", accountStr);
        formInput.put("routingNum", routingStr);
        formInput.put("memberID", memberStr);
        formInput.put("memberFullName", memberFullName);
        formInput.put("initBalance", balanceStr);

        return formInput;
    }
    
    public void addMember(int ssn, String fName, String mName, String lName, int memberID) {
    	memMan.addMember(memberID, ssn, fName, mName, lName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, double initBalance, int memberID) {
    	int balance = (int)(initBalance * 10);
        accMan.addAccount(accountType, accountID, routingNum, balance, memberID);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int initBalance, int memberID) {
        accMan.addAccount(accountType, accountID, routingNum, initBalance, memberID);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, double initBalance, String fullName) {
    	int balance = (int)(initBalance * 10);
        accMan.addAccount(accountType, accountID, routingNum, balance, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int initBalance, String fullName) {
        accMan.addAccount(accountType, accountID, routingNum, initBalance, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, String fullName) {
        accMan.addAccount(accountType, accountID, routingNum, fullName);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int memberID) {
        accMan.addAccount(accountType, accountID, routingNum, memberID);
    }
    
    

}
