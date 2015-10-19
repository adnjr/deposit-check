package controllers;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import models.BankingSystem;
import models.TransactionLog;

public class BankingSystemController {
    
    private BankingSystem bankSys;
    private DepositController depCon;
    private TransactionLog transLog;
    
    public BankingSystemController() {
        transLog = new TransactionLog();
    }
    
    public void readCheckDeposit(String textInput) {
        // TODO implement this
        
        // prompt the user for information
        promptForInfo();
        
        // collect information
        
        // process the information (if necessary)
        
        // pass the information the the primary controller
        
        
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
    
    // uses inputType to distinguish between check image or pdf file (or future types)
    public void readCheckDeposit(String inputType, String fileName) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addMember(String fName, String mName, String lName, int memberID) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int rountingNum, double initBalance, int memberID) {
        // TODO implement this
        int balance = (int)(initBalance * 10);
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int rountingNum, int initBalance, int memberID) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int routingNum, double initBalance, String fullName) {
        // TODO implement this
        int balance = (int)(initBalance * 10);
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int routingNum, int initBalance, String fullName) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int routingNum, String fullName) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    public void addAccount(int accountID, int routingNum, int memberID) {
        // TODO implement this
        throw new RuntimeException("Not yet implemented");
    }
    
    

}
