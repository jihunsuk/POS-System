package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBConnection;

public class Member {
	private String ID, PWD, Name, Age, PhoneNumber;

	public Member() {

	}

	public int doLogin(final String ID, final String PWD) {
		final int SUCCESS = 0;
		final int E1 = 1;
		final int E2 = 2;
		final int E3 = 3;

		Connection c = null;
		Statement stmt = null;
		int result = -1;

		// 예외흐름 E3
		if (ID.equals("") || PWD.equals("")) {
			return E3;
		}

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			// 예외흐름 E1
			String query = String.format("select * from member where ID='%s'", ID);
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next() || !rs.getString("ID").equals(ID)) {
				System.out.println("로그인을 하는데 해당하는 회원이 없습니다.");
				return E1;
			}

			// 예외흐름 E2
			query = String.format("select * from member where ID='%s' and PWD='%s'", ID, PWD);
			rs = stmt.executeQuery(query);
			if (!rs.next() || !rs.getString("ID").equals(ID)) {
				System.out.println("로그인을 하는데 해당하는 아이디의 비밀번호가 틀렸습니다.");
				return E2;
			}

			this.ID = ID;
			this.PWD = PWD;
			this.Name = rs.getString("NAME");
			this.Age = rs.getString("AGE");
			this.PhoneNumber = rs.getString("PHONENUMBER");
			System.out.println("로그인에 성공했습니다.");

			result = SUCCESS;
		} catch (SQLException e) {
			System.out.println("로그인에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public static int doMembership(final String ID, final String PWD, final String NAME, final String AGE,
			final String PHONENUMBER) {
		final int SUCCESS = 0;
		final int E1 = 1;
		final int E2 = 2;
		Connection c = null;
		Statement stmt = null;
		int result = -1;

		// 예외흐름 E2
		if (ID.equals("") || PWD.equals("") || NAME.equals("") || AGE.equals("") || PHONENUMBER.equals("")) {
			return E2;
		}

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("insert into Member values('%s','%s','%s','%s','%s')", ID, PWD, NAME, AGE,
					PHONENUMBER);
			stmt.executeUpdate(query);

			result = SUCCESS;
			stmt.close();
			System.out.println("회원가입에 성공했습니다.");
		} catch (SQLException e) {
			// 예외흐름 E1
			result = E1;
			System.out.println("회원가입에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
}
