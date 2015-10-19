package readers;

import java.util.Map;

public class WebDepositReader implements DepositReader {
    
    private int accountID;
    private int routingNum;
    private int memberID;
    private String memberFullName;
    private int initBalance;
    
    public WebDepositReader(Map<String, String> formInput) {
        processInput(formInput);
    }

    @Override
    public void getDepositInfo(Integer accountID, Integer routingNum, Integer memberID, String memberFullName, Integer initBalance) {
        accountID = this.accountID;
        routingNum = this.routingNum;
        memberID = this.memberID;
        memberFullName = this.memberFullName;
        initBalance = this.initBalance;
    }
    
    private void processInput(Map<String, String> formInput) {
        accountID = formInput.get("accountID").isEmpty() ? -1 : Integer.parseInt(formInput.get("accountID"));
        routingNum = formInput.get("routingNum").isEmpty() ? -1 : Integer.parseInt(formInput.get("routingNum")); 
        memberID = formInput.get("memberID").isEmpty() ? -1 : Integer.parseInt(formInput.get("memberID"));
        memberFullName = formInput.get("memberFullName"); 
        initBalance = formInput.get("initBalance").isEmpty() ? -1 : (int)(Double.parseDouble(formInput.get("initBalance")) * 10);
    }

}
