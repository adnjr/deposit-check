package readers;

import java.util.HashMap;

// Factory, Singleton, Pure Fabrication
public class DepositReaderFactory {
    
    private static DepositReaderFactory depFactory;
    
    private DepositReaderFactory() {
        
    }
    
    // Singleton
    public static DepositReaderFactory getFactory() {
        if (depFactory == null)
            depFactory = new DepositReaderFactory();
        
        return depFactory;
    }
    
    // Factory
    @SuppressWarnings("unchecked")
	public DepositReader getDepositReader(String inputType, Object input) {
        DepositReader reader = null;
        
        switch (inputType) {
        case "text":
            reader = new WebDepositReader((HashMap<String, String>)input); break;
        case "image":
        	reader =  new CheckDepositReader(); break;
        case "pdf":
        	reader = new PdfDepositReader(); break;
        }
        
        return reader;
    }

}
