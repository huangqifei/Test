package travel.struts.factory;

import travel.struts.db.DateBaseOperator;

public class DBOFactory {
	
	private static DBOFactory instance = null;
	private static DateBaseOperator dbo = null;
	
	private DBOFactory() {
		dbo = new DateBaseOperator();
	}
	
	
	public static synchronized DBOFactory getInstance() {
		if(instance == null) {
			instance = new DBOFactory();
		}
		return instance;
	}
	
	public DateBaseOperator getDBO() {
		return dbo;
	}
}
