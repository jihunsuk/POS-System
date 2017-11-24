package DB;

import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBQuery q = DBQuery.getDBQuery();
		try {
			String id = "Test1";
			String password = "password";
			String name = "가나다";
			int age = 12;
			String phoneNumber = "01051803247";
			
			// 회원가입 테스트
			q.insertMember(id, password, name, age, phoneNumber);
			System.out.println("회원가입 테스트 성공");
			
			// 로그인 테스트
			q.selectMember(id, password);
			System.out.println("로그인 테스트 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
