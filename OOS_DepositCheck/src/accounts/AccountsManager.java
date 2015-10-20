package accounts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import members.MemberManager;

public class AccountsManager {
	
	private MemberManager memMan;
	private Map<String, Account> accountsByName;
	private Map<Long, Account> accountsByNumber;
	
	public AccountsManager(MemberManager memberManager) {
		accountsByName = new HashMap<String, Account>();
		accountsByNumber = new HashMap<Long, Account>();
		memMan = memberManager;
	}
	
	public Account getAccountOf(String memberFullName) {
		for (String name : accountsByName.keySet())
			if (name.equalsIgnoreCase(memberFullName))
				return accountsByName.get(name);

		return null;
	}
	
	public Account getAccountOf(Long memberID) {
		for (Account acct : accountsByNumber.values())
			if (acct.getAccountNumber().equals(memberID))
				return acct;

		return null;
	}
	
	public Collection<Account> getAccounts() {
	    return accountsByNumber.values();
	}
	
	public boolean addAccount(String accountType, Long accountID, Long routingNum, Long initBalance, Long memberID) {
		Account newAccount;
		String fullName;
		
		fullName = memMan.getNameOf(memberID);
		if (accountType.equals("checking"))
			newAccount = new CheckingAccount(accountID, routingNum, initBalance, memberID);
		else
			newAccount = null;
		
		accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
		
		return newAccount != null;
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Long initBalance, String fullName) {
    	Account newAccount;
    	Long memberID;
    	
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, initBalance, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
		
		return newAccount != null;
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, String fullName) {
    	Account newAccount;
    	Long memberID;
        
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, 0L, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
		
		return newAccount != null;
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Long memberID) {
    	Account newAccount;
    	String fullName;
        
    	fullName = memMan.getNameOf(memberID);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, 0L, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
		
		return newAccount != null;
    }

}
