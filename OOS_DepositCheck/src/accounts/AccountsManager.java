package accounts;

import java.util.HashMap;
import java.util.Map;

import customers.MemberManager;

public class AccountsManager {
	
	private MemberManager memMan;
	private Map<String, Account> accountsByName;
	private Map<Integer, Account> accountsByNumber;
	
	public AccountsManager(MemberManager memberManager) {
		accountsByName = new HashMap<String, Account>();
		accountsByNumber = new HashMap<Integer, Account>();
		memMan = memberManager;
	}
	
	public Account getAccountOf(String memberFullName) {
		return accountsByName.get(memberFullName);
	}
	
	public Account getAccountOf(Integer memberID) {
		return accountsByNumber.get(memberID);
	}
	
	public void addAccount(String accountType, int accountID, int routingNum, int initBalance, int memberID) {
		Account newAccount;
		String fullName;
		
		fullName = memMan.getNameOf(memberID);
		if (accountType.equals("checking"))
			newAccount = new CheckingAccount(accountID, routingNum, initBalance, memberID);
		else
			newAccount = null;
		
		accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int initBalance, String fullName) {
    	Account newAccount;
    	int memberID;
    	
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, initBalance, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, String fullName) {
    	Account newAccount;
    	int memberID;
        
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, 0, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }
    
    public void addAccount(String accountType, int accountID, int routingNum, int memberID) {
    	Account newAccount;
    	String fullName;
        
    	fullName = memMan.getNameOf(memberID);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, 0, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }

}
