package models;

import java.util.Date;

import javax.swing.ImageIcon;

public class Check {
    
    private int checkNumber;
    private int routingNumber;
    private Date checkDate;
    private int amount;
    private String payTo;
    private String payerName;
    private String payerAddress;
    private String memo;
    private ImageIcon signature;

    public Check() {
        
    }
}
