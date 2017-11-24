package DAO;

public class Member {
	private String ID, PWD, Name, Age, PhoneNumber;
	
	public Member() {

	}
	
	public static boolean doLogin(final String ID, final String PWD){
		//JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
		//JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
		//JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
		return false;
	}
	
	public static boolean doMembership(final String ID, final String PWD, final String NAME, final String PHONENUMBER){
		//JOptionPane.showMessageDialog(null, "중복된 ID입니다. 다시 입력해 주세요.’");
		//JOptionPane.showMessageDialog(null, "입력되지 않은 정보가 있습니다. 다시 입력해 주세요.’");
		return false;
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
