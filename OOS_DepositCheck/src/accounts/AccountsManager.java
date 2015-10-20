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
		return accountsByName.get(memberFullName);
	}
	
	public Account getAccountOf(Long memberID) {
		return accountsByNumber.get(memberID);
	}
	
	public Collection<Account> getAccounts() {
	    return accountsByNumber.values();
	}
	
	public void addAccount(String accountType, Long accountID, Long routingNum, Long initBalance, Long memberID) {
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
    
    public void addAccount(String accountType, Long accountID, Long routingNum, Long initBalance, String fullName) {
    	Account newAccount;
    	Long memberID;
    	
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, initBalance, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }
    
    public void addAccount(String accountType, Long accountID, Long routingNum, String fullName) {
    	Account newAccount;
    	Long memberID;
        
    	memberID = memMan.getMemberIDOf(fullName);
    	if (accountType.equals("checking"))
    		newAccount = new CheckingAccount(accountID, routingNum, 0, memberID);
    	else
    		newAccount = null;
    	
    	accountsByName.put(fullName, newAccount);
		accountsByNumber.put(memberID, newAccount);
    }
    
    public void addAccount(String accountType, Long accountID, Long routingNum, Long memberID) {
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
