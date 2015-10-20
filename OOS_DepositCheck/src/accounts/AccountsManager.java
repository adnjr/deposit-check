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
		String fullName;
		
		fullName = memMan.getNameOf(memberID);
		return addAccountHelper(accountType, accountID, routingNum, initBalance, fullName, memberID);
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Long initBalance, String fullName) {
    	Long memberID;
    	
    	memberID = memMan.getMemberIDOf(fullName);
    	return addAccountHelper(accountType, accountID, routingNum, initBalance, fullName, memberID);
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, String fullName) {
    	Long memberID;
        
    	memberID = memMan.getMemberIDOf(fullName);
    	return addAccountHelper(accountType, accountID, routingNum, 0L, fullName, memberID);
    }
    
    public boolean addAccount(String accountType, Long accountID, Long routingNum, Long memberID) {
    	String fullName;
        
    	fullName = memMan.getNameOf(memberID);
    	return addAccountHelper(accountType, accountID, routingNum, 0L, fullName, memberID);
    }
    
    private boolean addAccountHelper(String accountType, Long accountID, Long routingNum, Long initBalance, String fullName, Long memberID) {
    	Account account = null;
    	
    	// when account exists, just add the new member
    	if ( (account = getAccountOf(accountID)) != null) {
    		System.out.println("yeah right");
    		account.addMember(memberID);
    	} else {
    		switch (accountType) {
    		case "checking":
    			account = new CheckingAccount(accountID, routingNum, initBalance, memberID);
    			break;
    		}
    		
    		accountsByName.put(fullName, account);
    		accountsByNumber.put(accountID, account);
    	}
		
		return account != null;
    }

}
