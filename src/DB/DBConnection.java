package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection dbConn;
	   
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(dbConn == null){
            Class.forName(DBConnInterface.DRIVERNAME);     
            System.out.println("Driver load");
            dbConn = DriverManager.getConnection(DBConnInterface.URL, DBConnInterface.DBID, DBConnInterface.DBPW);
            System.out.println("DB connection success");
        }
       
        return dbConn;
    }
    
    public static void close() throws SQLException{
        if(dbConn!=null){   
            System.out.println("DB connection release");
            if(!dbConn.isClosed()){
                dbConn.close();
            }           
        } 
        dbConn = null;        
    }   
}
