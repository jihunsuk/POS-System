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

	public boolean doLogin(final String ID, final String PWD) {
		// JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
		// JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
		// JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
		Connection c = null;
		Statement stmt = null;
		boolean result = false;
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from member where ID='%s' and PWD='%s'", ID, PWD);

			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next() || !rs.getString("ID").equals(ID)) {
				System.out.println("로그인을 하는데 해당하는 회원이 없습니다.");
				result = false;
			}
			else {
				this.ID = ID;
				this.PWD = PWD;
				this.Name = rs.getString("NAME");
				this.Age = rs.getString("AGE");
				this.PhoneNumber = rs.getString("PHONENUMBER");
				result = true;
			}
			
		} catch (SQLException e) {
			System.out.println("로그인 예외발생");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean doMembership(final String ID, final String PWD, final String NAME, final String AGE,
			final String PHONENUMBER) {
		// JOptionPane.showMessageDialog(null, "중복된 ID입니다. 다시 입력해 주세요.’");
		// JOptionPane.showMessageDialog(null, "입력되지 않은 정보가 있습니다. 다시 입력해
		// 주세요.’");
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();
			result = false;
			
			String query = String.format("insert into Member values('%s','%s','%s','%d','%s')", ID, PWD, NAME, AGE,
					PHONENUMBER);
			stmt.executeUpdate(query);
			result = true;
			
			stmt.close();
		} catch (SQLException e) {
			/* 중복된 ID의 경우 */
			System.out.println("중복된 ID로 회원가입을 하려고 합니다.");
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
