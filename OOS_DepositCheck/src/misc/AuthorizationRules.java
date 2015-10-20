package misc;

public class AuthorizationRules {
    
    public AuthorizationRules() {

    }
    
    public boolean isTransactionAuthorized(String accountType, String accountStatus,
                                                      String transactionType) {
    	
    	switch (accountStatus) {
    	case "open":
    		return openRules(accountType, accountStatus, transactionType);
    	case "pendingApproval":
    		return pendingRules(accountType, accountStatus, transactionType);
    	case "closed":
    		return closedRules(accountType, accountStatus, transactionType);
    	}
    	
       return false;
    }
    
    private boolean openRules(String accountType, String accountStatus, String transactionType) {
    	switch (accountType) {
    	case "checking":
    		if (transactionType.equals("deposit"))
    			return true;
    		if (transactionType.equals("withdrawal"))
    			return true;
    		else
    			return false;
    	case "savings":
    		if (transactionType.equals("deposit"))
    			return true;
    		if (transactionType.equals("withdrawal"))
    			return false;
    		else
    			return false;
    	}
    	
    	return false;
    }
    
    private boolean pendingRules(String accountType, String accountStatus, String transactionType) {
    	return false;
    }
    
    private boolean closedRules(String accountType, String accountStatus, String transactionType) {
    	return false;
    }
}
