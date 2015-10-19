package readers;

import java.util.Map;

public interface DepositReader {
    
//    public void getDepositInfo(Integer accountID, Integer routingNum, Integer memberID, String memberFullName, Integer initBalance);
	public Map<String, String> getDepositInfo();

}
