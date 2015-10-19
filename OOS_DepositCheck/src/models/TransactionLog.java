package models;

import java.util.HashMap;
import java.util.Map;

import transactions.Transaction;

public class TransactionLog {
    
    private Map<Integer, String> transactions;
    private int nextTransactionID;
    
    public TransactionLog() {
        transactions = new HashMap<Integer, String>();
        nextTransactionID = 0;
    }
    
    public void addTransaction(String type, Integer accountID, Integer routingNum,
            Integer memberID, String memberFullName, Integer initBalance) {
        Transaction trans;
        switch (type) {
        case "deposit":
            trans = new Transaction(nextTransactionID++, accountID, );
        }
    }

}
