import static org.junit.Assert.*;
import org.junit.Test;

public class UserRegistrationTest {

	@Test
    public void testValidRegistration() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("John Doe", 
        						"johndoe@example.com", "password1234");
        assertTrue(result);
    }

    @Test
    public void testInvalidEmail() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("John Doe", 
        								"invalidemail", "password1234");
        assertFalse(result);
    }

    @Test
    public void testWeakPassword() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("John Doe", 
        								"johndoe@example.com", "weak");
        assertFalse(result);
    }

    @Test
    public void testMissingName() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("", 
        						"johndoe@example.com", "password1234");
        assertFalse(result);
    }

    @Test
    public void testMissingEmailAndPassword() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.registerUser("John Doe", 
        													"", "");
        assertFalse(result);
    }

}
