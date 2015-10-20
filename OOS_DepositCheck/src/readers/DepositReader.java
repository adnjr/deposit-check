package readers;

import java.util.Map;

// Polymorphism, Adapter, Protected Variations
public interface DepositReader {
    
	// Polymorphism, Adapter
	public Map<String, String> getDepositInfo();

}
