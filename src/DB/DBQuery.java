package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
	private static DBQuery dbQuery;
	private static Connection c;
	
	public DBQuery(){
		c = DBConnection.getConnection();
	}
	
	public static DBQuery getDBQuery(){
        if(dbQuery == null){
            dbQuery = new DBQuery();
        }
        return dbQuery;
    }
	
	public void insertMember(String ID, String PWD, String NAME, int age, int phoneNumber) throws SQLException{
	    final String SQL = String.format("insert into Member values('%s','%s','%s','%d','%d')", ID, PWD, NAME, age, phoneNumber);
	     
	    final Statement stmt = c.createStatement();
	    final int isUpdate = stmt.executeUpdate(SQL);
	   
	    stmt.close();
	}
}
