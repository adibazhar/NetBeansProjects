/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/**
 *
 * @author adib.a
 */
public class AsymmetricEncryptionUtils {

    /**
     * @param args the command line arguments
     */
    private static final String RSA = "RSA";
    
    public static KeyPair generateRSAKeyPair() throws Exception{
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(4096,secureRandom);
        return keyPairGenerator.generateKeyPair();
    }
    
    public static byte[] performRSAEncryption(String plainText,PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        return cipher.doFinal(plainText.getBytes());
    } 
    
    public static String performRSADecryption(byte[] cipherText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
