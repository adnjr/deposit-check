package readers;

import java.util.Map;

public class WebDepositReader implements DepositReader {

    private Map<String, String> input;
    
    public WebDepositReader(Map<String, String> formInput) {
    	this.input = formInput;
    }

    @Override
    public Map<String, String> getDepositInfo() {
    	return this.input;
    }

}
