package transactions;

public class Deposit extends Transaction {
    
    public static final String TRANSACTION_TYPE = "deposit";
    
    public Deposit(long transactionID, long accountNumber, long previousBalance, long amount) {   
        super(transactionID, accountNumber, previousBalance, amount);
    }

    @Override
    public String getType() {
        return TRANSACTION_TYPE;
    }

	@Override
	public double getNewBalance() {
		return getPreviousBalance() + getAmount();
	}
    
    

}
