package transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import misc.Database;

public class TransactionLog {
    
    private Map<Integer, Transaction> transactions;
    private int nextTransactionID;
    
    public TransactionLog() {
        transactions = new HashMap<Integer, Transaction>();
        nextTransactionID = 0;
    }
    
    public void addTransaction(String type, Map<String, String> input) {
        Transaction trans = null;
        
        switch (type) {
        case "deposit":
        	trans = TransactionFactory.getFactory().makeTransaction(nextTransactionID, type, input);
        	Database.getDB().addTransaction(trans);
        }
        
        transactions.put(trans.getTransactionID(), trans);
    }
    
    public List<Transaction> getAccountTransactions(int accountID) {
        List<Transaction> result = new ArrayList<Transaction>();
        
        for (Transaction trans : transactions.values())
            if (trans.getAccountNumber() == accountID)
                result.add(trans);
        
        return result;
    }

}
