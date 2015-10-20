package transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import misc.Database;

// High Cohesion, Low Coupling
public class TransactionLog {
    
    private Map<Long, Transaction> transactions;
    private long nextTransactionID;
    
    public TransactionLog() {
        transactions = new HashMap<Long, Transaction>();
        nextTransactionID = 0;
    }
    
    // Expert
    public void addTransaction(String type, Map<String, String> input) {
        Transaction trans = null;
        
        switch (type) {
        case "deposit":
        	trans = TransactionFactory.getFactory().makeTransaction(nextTransactionID, type, input);
        	Database.getDB().addTransaction(trans);
        }
        
        transactions.put(trans.getTransactionID(), trans);
    }
    
    // Expert
    public List<Transaction> getAccountTransactions(long accountID) {
        List<Transaction> result = new ArrayList<Transaction>();
        
        for (Transaction trans : transactions.values())
            if (trans.getAccountNumber() == accountID)
                result.add(trans);
        
        return result;
    }

}
