/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetricalencryption;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adib.a
 */
public class yrclassIT {
    
    @Test
    public void createAESKey() throws Exception{
        SecretKey key = yrclass.createAESKey();
        assertNotNull(key);
        System.out.println(DatatypeConverter.printHexBinary(key.getEncoded()));
    }
    
    @Test
    public void testAESCryptoRoutine() throws Exception{
        SecretKey key = yrclass.createAESKey();
        byte[] initializationVector = yrclass.createInitializationVector();
        String plainText = "This is the text we are goind to hide";
        byte[] cipherText = yrclass.performAESEncryption(plainText, key, initializationVector);
        assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptedText = yrclass.performAESDecryption(cipherText, key, initializationVector);
        assertEquals(plainText,decryptedText);
        System.out.println(decryptedText);
    }
    
}
