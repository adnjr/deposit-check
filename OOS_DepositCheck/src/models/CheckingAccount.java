package models;

import java.util.Map;

public class CheckingAccount extends Account {
    
    private static final String ACCOUNT_TYPE = "checking";
    
    public CheckingAccount(int accountNumber, int balance, Customer... customers) {
        super(accountNumber, balance, customers);
    }

    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }
    
    public Map<String, String> getFeatures() throws Exception {
        throw new Exception("CheckingAccounts.getFeatures: method not yet implemented");
    }

}
