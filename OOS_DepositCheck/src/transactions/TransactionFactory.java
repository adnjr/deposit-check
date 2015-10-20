package transactions;

import java.util.Map;

public class TransactionFactory {
	
	private static TransactionFactory transFact;
	
	public TransactionFactory() {
		
	}
	
	public static TransactionFactory getFactory() {
		if (transFact == null)
			transFact = new TransactionFactory();
		
		return transFact;
	}
	
	public Transaction makeTransaction(long transID, String transType, Map<String, String> input) {
	    int accountID;
	    int previousBalance;
	    int amount;
		
	    accountID = input.get("accountID").isEmpty() ? -1 : Integer.parseInt(input.get("accountID")); 
		previousBalance = input.get("previousBalance").isEmpty() ? -1 : (int)(Double.parseDouble(input.get("previousBalance")) * 10);
		amount = input.get("amount").isEmpty() ? -1 : (int)(Double.parseDouble(input.get("amount")) * 10);
//		routingNum = input.get("routingNum").isEmpty() ? -1 : Integer.parseInt(input.get("routingNum"));
		
		switch (transType) {
		case "deposit":
			return new Deposit(transID, accountID, previousBalance, amount);
		}
		
		return null;
	}

}
