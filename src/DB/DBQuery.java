package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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

	/* 회원가입 */
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
			System.out.println("중복된 ID로 회원가입을 하려고 합니다.");
		}
		stmt.close();
		
		return res;
	}
	
	/* 로그인 */
	public boolean selectMember(String ID, String PWD) throws SQLException {
		final String SQL = String.format("select ID from member where ID='%s' and PWD='%s'", ID, PWD);
		
		final Statement stmt = c.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(SQL);
			if(rs.next()){
				if(rs.getString("ID").equals(ID))
					return true;
				else
					return false;
			}
		} catch (Exception e) {
			/* 예외 */
		}
		
		return false;
	}
	
}
