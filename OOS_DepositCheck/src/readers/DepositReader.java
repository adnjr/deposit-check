package readers;

public interface DepositReader {
    
    public void getDepositInfo(Integer accountID, Integer routingNum, Integer memberID, String memberFullName, Integer initBalance);

}
