package misc;

import transactions.Transaction;

// In a real system, this class would serve as the facade for the external database system
public class Database {
	
	private static Database db;
	
	public Database() {
		
	}
	
	public static Database getDB() {
		if (db == null)
			db = new Database();
		
		return db;
	}
	
	public boolean addTransaction(Transaction transaction) {
		return true;
	}

}
