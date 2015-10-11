package models;

import java.util.Set;

public class AuthorizationRules {

    private Set<Rule> depositRules;
    
    public boolean isTransactionAuthorized(String accountType, String accountStatus,
                                                      String transactionType) throws Exception {
        throw new Exception("DepositController.authorizeDeposit: method not yet implemented");
        //return false;
    }
}
