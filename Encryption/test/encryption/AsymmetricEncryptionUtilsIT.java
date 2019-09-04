/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.xml.bind.DatatypeConverter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adib.a
 */
public class AsymmetricEncryptionUtilsIT {


    /**
     * Test of generateRSAKeyPair method, of class AsymmetricEncryptionUtils.
     */
    

    /**
     * Test of performRSADecryption method, of class AsymmetricEncryptionUtils.
     */
 

    @Test
    public void generateRSAKeyPair() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        assertNotNull(keyPair);
        System.out.println("Private Key" + DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
        System.out.println("Public Key" + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
    }
    
    @Test
    public void testRSACryptoRoutine() throws Exception{
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        String plainText = "This is the text we going to hide";
        byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(plainText, keyPair.getPrivate());
        assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptedText = AsymmetricEncryptionUtils.performRSADecryption(cipherText, keyPair.getPublic());
        assertEquals(plainText, decryptedText);
    }

}
