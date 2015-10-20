package transactions;

import java.util.Map;

// Factory, Singleton, Pure Fabrication
public class TransactionFactory {
	
	private static TransactionFactory transFact;
	
	public TransactionFactory() {
		
	}
	
	// Factory, Singleton
	public static TransactionFactory getFactory() {
		if (transFact == null)
			transFact = new TransactionFactory();
		
		return transFact;
	}
	
	// Factory
	public Transaction makeTransaction(long transID, String transType, Map<String, String> input) {
	    int accountID;
	    int previousBalance;
	    int amount;
		
	    accountID = input.get("accountID").isEmpty() ? -1 : Integer.parseInt(input.get("accountID")); 
		previousBalance = input.get("previousBalance").isEmpty() ? -1 : (int)(Double.parseDouble(input.get("previousBalance")) * 10);
		amount = input.get("amount").isEmpty() ? -1 : (int)(Double.parseDouble(input.get("amount")) * 10);
		
		switch (transType) {
		case "deposit":
			return new Deposit(transID, accountID, previousBalance, amount);
		}
		
		return null;
	}

}
