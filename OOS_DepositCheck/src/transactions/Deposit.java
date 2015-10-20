package transactions;

// Polymorphism
public class Deposit extends Transaction {
    
    public static final String TRANSACTION_TYPE = "deposit";
    
    public Deposit(long transactionID, long accountNumber, long previousBalance, long amount) {   
        super(transactionID, accountNumber, previousBalance, amount);
    }

    // Polymorphism, Expert
    @Override
    public String getType() {
        return TRANSACTION_TYPE;
    }
    
    // Polymorphism, Expert
	@Override
	public double getNewBalance() {
		return getPreviousBalance() + getAmount();
	}
    
    

}
