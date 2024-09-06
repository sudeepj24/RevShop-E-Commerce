package com.revshop.utility;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordUtil {

    // Method to hash a password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Method to verify a password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

//    public static void main(String[] args) {
//        // Example usage
//        String password = "mySecurePassword";
//        
//        // Hash the password
//        String hashedPassword = BCryptPasswordUtil.hashPassword(password);
//        System.out.println("Hashed Password: " + hashedPassword);
//        
//        // Verify the password
//        boolean isPasswordCorrect = BCryptPasswordUtil.checkPassword(password, hashedPassword);
//        System.out.println("Password verification: " + isPasswordCorrect);
//    }
}
