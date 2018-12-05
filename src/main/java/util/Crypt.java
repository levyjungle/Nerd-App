package util;

import org.mindrot.jbcrypt.BCrypt;

public class Crypt {
	
	//Generates a hash based in user password
	public static String hash(String password) {
		return BCrypt.hashpw(password+"trabalhoFjn", BCrypt.gensalt(10));
	}
	//Verify hash if this is the same in password
	public static boolean verifyHash(String password, String hash) {
		return BCrypt.checkpw(password+"trabalhoFjn", hash);
	}				
}
