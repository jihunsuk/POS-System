package DB;

import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBQuery q = DBQuery.getDBQuery();
		try {
			q.insertMember("Test", "pass", "name", 12, "01051803247");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
