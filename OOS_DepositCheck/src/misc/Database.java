package misc;

import transactions.Transaction;

// Facade, Indirection, Singleton
// In a real system, this class would serve as the facade for the external database system
public class Database {
	
	private static Database db;
	
	public Database() {
		
	}
	
	// Singleton
	public static Database getDB() {
		if (db == null)
			db = new Database();
		
		return db;
	}
	
	// Facade
	public boolean addTransaction(Transaction transaction) {
		return true;
	}

}
