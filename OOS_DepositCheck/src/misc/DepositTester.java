package misc;
import controllers.BankingSystemController;

/*
 * NOTE: THIS MUST BE RUN FROM THE COMMAND LINE (console)
 */
public class DepositTester{
  
	public static void main (String[] args){
		BankingSystemController c = new BankingSystemController();
		fillProfilesAndAccounts(c);
		printMemberInfo(c);

		c.readCheckDeposit("text");
		printMemberInfo(c);
		c.readCheckDeposit("text");
		printMemberInfo(c);
		
		// unfortunately, I was unable to implement the use of the APIs
//		c.readCheckDeposit("image", "SampleImage1.png");
//		printMemberInfo(c);
//		c.readCheckDeposit("pdf", "SamplePDF1.pdf");
//		printMemberInfo(c);
	}
  
  public static void fillProfilesAndAccounts(BankingSystemController c){
    String fName, mName, lName, fullName;
    Long memberID, accountID, routingNum;
    Double initBalance;
    
    //Member Profiles
    fName = "John";
    mName = "Z";
    lName = "Smith";
    memberID = 123456L;
    c.addMember(fName, mName, lName, memberID);
    
    fName = "Roger";
    mName = "M";
    lName = "Doe";
    memberID = 658241L;
    c.addMember(fName, mName, lName, memberID);
    
    fName = "Ashley";
    mName = "Maureen";
    lName = "Williams";
    memberID = 987654L;
    c.addMember(fName, mName, lName, memberID);
    
    //Member Accounts
    accountID = 724301068L;
    routingNum = 122105278L;
    memberID = 123456L;
    initBalance = 8003.00;
    if (!c.addAccount("checking", accountID, routingNum, initBalance, memberID))      // doesn't work
    	System.err.println("Failed to add account " + accountID);
    
    accountID = 512463512L;
    if (!c.addAccount("checking", accountID, routingNum, memberID))
    	System.err.println("Failed to add account " + accountID);
    
    accountID = 555555555L;
    routingNum = 333388888L;
    fullName = "Roger M Doe";
    if (!c.addAccount("checking", accountID, routingNum, fullName))
    	System.err.println("Failed to add account " + accountID);
    
    accountID = 886611554L;
    routingNum = 324752184L;
    initBalance = 600.00;
    memberID = 987654L;
    if (!c.addAccount("checking", accountID, routingNum, initBalance, memberID))      // doesn't work
    	System.err.println("Failed to add account " + accountID);
    
    accountID = 449977123L;
    initBalance = 30.00;
    fullName = "Ashley Maureen Williams";
    if (!c.addAccount("checking", accountID, routingNum, initBalance, fullName))      // doesn't work
    	System.err.println("Failed to add account " + accountID);
    
    accountID = 925849516L;
    if (!c.addAccount("checking", accountID, routingNum, memberID))
    	System.err.println("Failed to add account " + accountID);
    
  }
  
  public static void printMemberInfo(BankingSystemController c) {
	  System.out.println("\nListing all accounts w/info:");
      System.out.println(c.getAllAccountInfo());
      // Have this method print ALL members and their
      // account details. An example print out follows
      // (you can choose a different format if you like
      // as long as it makes sense and is easy to understand):
      /*
       * MemberID     MemberName
       *           AccountNumber1     balance
       *                Transaction1     amount
       *           AccountNumber2     balance
       *                Transaction2     amount
       *                Transaction1     amount
       * 
       * MemberID     MemberName
       *           AccountNumber1     balance
       *                Transaction2     amount
       *                Transaction1     amount
       *           AccountNumber2     balance
       *                Transaction1     amount
       * 
       * etc...
       */
  }
}

  