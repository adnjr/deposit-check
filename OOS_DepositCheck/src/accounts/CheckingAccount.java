package accounts;

import java.util.Map;

public class CheckingAccount extends Account {
    
    private static final String ACCOUNT_TYPE = "checking";
    
    public CheckingAccount(Long accountNumber, Long routingNum, Long balance, Long... memberIDs) {
        super(accountNumber, routingNum, balance, memberIDs);
    }

    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }
    
    public Map<String, String> getFeatures() throws Exception {
        throw new Exception("CheckingAccounts.getFeatures: method not yet implemented");
    }


}
