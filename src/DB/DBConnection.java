package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection dbConn;

	public static Connection getConnection() {
		try {
			if (dbConn == null) {
				Class.forName(DBConnInterface.DRIVERNAME);
				System.out.println("Driver load");
				dbConn = DriverManager.getConnection(DBConnInterface.URL, DBConnInterface.DBID, DBConnInterface.DBPW);
				System.out.println("DB connection success");
			}
		} catch (Exception e) {
			System.out.println("DB connection fail!");
			e.printStackTrace();
		}
		return dbConn;
	}

	public static void close() {
		try {
			if (dbConn != null) {
				System.out.println("DB release success");
				if (!dbConn.isClosed()) {
					dbConn.close();
				}
			}
			dbConn = null;
		} catch (Exception e) {
			System.out.println("DB release fail!");
		}
	}
}
