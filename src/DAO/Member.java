package DAO;

public class Member {
	private String ID, PWD, Name, Age, PhoneNumber;
	
	public Member() {

	}
	
	public boolean doLogin(final String ID, final String PWD){
		
		return false;
	}
	
	public boolean doMembership(final String ID, final String PWD, final String NAME, final String PHONENUMBER){
		
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
