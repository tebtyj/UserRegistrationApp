import java.util.ArrayList;

public class UserRegistration {

	private ArrayList<User> users = new ArrayList<User>();
	
	public static void main(String[] args) {
		UserRegistration userRegistration = new UserRegistration();
		
		boolean addUser = true;
		
		while (addUser) {
			String name = Helper.readString("Enter name: ");
			String email = Helper.readString("Enter email: ");
			String pw = Helper.readString("Enter password: ");
			
			boolean result = userRegistration.registerUser(name, 
													email, pw);
			if (result) {
				System.out.println("User registration is successful.");
			}else {
				System.out.println("User registration failed.");
			}
			
			addUser = Helper.readBoolean("Do you want to register anotehr user (Y/N)?");
		}
		
		System.out.println("Bye bye.");
	}

	private boolean checkPassword(String password) {
		boolean correctLength = false;
		if (password.length() >= 12) {
			correctLength = true;
		}
		String alphaberts = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean checkAlphaberts = false;
		for (int i=0; i < alphaberts.length(); i++) {
			if (password.contains(String.valueOf(alphaberts.charAt(i)))) {
				checkAlphaberts = true;		
			}
		}
		String numbers = "1234567890";
		boolean checkNumber = false;
		for (int i=0; i < numbers.length(); i++) {
			if (password.contains(String.valueOf(numbers.charAt(i)))) {
				checkNumber = true;		
			}
		}
		return checkNumber && checkAlphaberts && correctLength;
	}
	
	public boolean registerUser(String name, String email, String password) {
		// Empty information
		if (name.isEmpty() || email.isEmpty() || password.isEmpty())
			return false;
		
		if (!checkPassword(password))
			return false;
				
		if (!email.contains("@"))
			return false;
		
		users.add(new User(name, email, password));
		return true;
	}
}
