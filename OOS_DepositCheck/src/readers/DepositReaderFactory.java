package readers;

import java.util.HashMap;

public class DepositReaderFactory {
    
    private static DepositReaderFactory depFactory;
    
    private DepositReaderFactory() {
        
    }
    
    public static DepositReaderFactory getFactory() {
        if (depFactory == null)
            depFactory = new DepositReaderFactory();
        
        return depFactory;
    }
    
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
