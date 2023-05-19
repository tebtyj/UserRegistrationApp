
public class User {
	String name;
	String email;
	String password;

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
