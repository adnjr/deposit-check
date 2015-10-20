package accounts;

import java.util.Map;

import members.Member;

public class CheckingAccount extends Account {
    
    private static final String ACCOUNT_TYPE = "checking";
    
    public CheckingAccount(long accountNumber, long routingNum, long balance, long... memberIDs) {
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
