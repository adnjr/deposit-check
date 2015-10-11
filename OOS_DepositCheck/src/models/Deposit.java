package models;

import java.util.Date;

public class Deposit extends Transaction {
    
    public static final String TRANSACTION_TYPE = "deposit";
    
    public Deposit(int transactionID, int accountNumber, int previousBalance,
                                                       int amount, Date date) {   
        super(transactionID, accountNumber, previousBalance, amount, date);
    }

    @Override
    public String getType() {
        return TRANSACTION_TYPE;
    }
    
    

}
