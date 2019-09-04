/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetricalencryption;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author adib.a   
 */
public class yrclass {
    private static final String AES ="AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    

    public static SecretKey createAESKey() throws Exception{
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);
        return keyGenerator.generateKey();
    }
    
    public static byte[] createInitializationVector(){
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }
    
    public static byte[] performAESEncryption(String plaintext, SecretKey secretKey, byte[] initializationVector) throws Exception{
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
       // cipher.init(Cipher.ENCRYPT_MODE, secretKey,ivParameterSpec);
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,ivParameterSpec);
        return cipher.doFinal(plaintext.getBytes());
    }
    
    public static String performAESDecryption(byte[] cipherText,SecretKey secretKey, byte[] initializationVector)throws Exception{
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKey,ivParameterSpec);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
    
    public static void main(String[] args) {
        
    }
}
