package accounts;

// Polymorphism: This sub-class of Account implements responsibilities that vary by account type
public class CheckingAccount extends Account {
    
    private static final String ACCOUNT_TYPE = "checking";
    
    public CheckingAccount(Long accountNumber, Long routingNum, Long balance, Long... memberIDs) {
        super(accountNumber, routingNum, balance, memberIDs);
    }

    // Polymorphism: Account type varies by type, and should be implemented in this sub-class of Account
    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }


}
