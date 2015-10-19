package transactions;

public class Deposit extends Transaction {
    
    public static final String TRANSACTION_TYPE = "deposit";
    
    public Deposit(int transactionID, int accountNumber, int previousBalance, int amount) {   
        super(transactionID, accountNumber, previousBalance, amount);
    }

    @Override
    public String getType() {
        return TRANSACTION_TYPE;
    }

	@Override
	public int getNewBalance() {
		return getPreviousBalance() + getAmount();
	}
    
    

}
