package util;

import org.mindrot.jbcrypt.BCrypt;

public class Crypt {
	public static String hash(String password) {
		return BCrypt.hashpw(password+"trabalhoFjn", BCrypt.gensalt(10));
	}

	public static boolean verifyHash(String password, String hash) {
		return BCrypt.checkpw(password+"trabalhoFjn", hash);
	}				
}
