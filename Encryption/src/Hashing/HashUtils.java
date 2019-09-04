/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author adib.a
 */
public class HashUtils {
    private static final String SHA2_ALGORITHM = "SHA-256";
    
    public static byte[] generateRandomSalt(){
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }
    
    public static byte[] createSHA2Hash (String input, byte[] salt) throws Exception{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byteStream.write(salt);
        byteStream.write(input.getBytes());
        byte[] valueToHash = byteStream.toByteArray();
        
        MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALGORITHM);
        return messageDigest.digest(valueToHash);
        
    }
    
    public static String hashPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
    
    public static boolean verifyPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }
    
    public static void main(String[] args) throws Exception {
        byte[] salt = generateRandomSalt();
        System.out.println("Salt = " + salt);
        String password = "adib123";
        
        byte[] SHA2Password = createSHA2Hash(password,salt);
        System.out.println("SHA2Hash = " + SHA2Password);
     
        
        String hashedPassword = hashPassword(password);
        System.out.println(hashedPassword);
        System.out.println(verifyPassword(password,hashedPassword));
    }
}
