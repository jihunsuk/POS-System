package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
	private static DBQuery dbQuery;
	private static Connection c;

	public DBQuery() {
		c = DBConnection.getConnection();
	}

	public static DBQuery getDBQuery() {
		if (dbQuery == null) {
			dbQuery = new DBQuery();
		}
		return dbQuery;
	}

	public boolean insertMember(String ID, String PWD, String NAME, int age, String phoneNumber) throws SQLException {
		final String SQL = String.format("insert into Member values('%s','%s','%s','%d','%s')", ID, PWD, NAME, age,
				phoneNumber);
		boolean res = false;
		
		final Statement stmt = c.createStatement();
		try {
			final int isUpdate = stmt.executeUpdate(SQL);
			res = true;
		} catch (Exception e) {
			/* 중복된 ID의 경우 */
		}
		stmt.close();
		
		return res;
	}
	
	
}
