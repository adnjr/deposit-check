package readers;

import java.util.HashMap;

public class DepositReaderFactory {
    
    private static DepositReaderFactory depFactory;
    private PdfDepositReader pdfDepositReader;
    private CheckDepositReader checkDepositReader;
    private WebDepositReader webDepositReader;
    
    private DepositReaderFactory() {
        
    }
    
    public DepositReaderFactory getFactory() {
        if (depFactory == null)
            depFactory = new DepositReaderFactory();
        
        return depFactory;
    }
    
    public DepositReader getDepositReader(String inputType, Object input) {
        DepositReader reader = null;
        
        switch (inputType) {
        case "text":
            reader = new WebDepositReader((HashMap<String, String>)input);
            break;
        }
        
        return reader;
    }

}
