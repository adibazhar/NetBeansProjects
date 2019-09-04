/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.UUID;
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
public class HashUtilsIT {
    
    @Test
    public void generateRandomSalt(){
        byte[] salt = HashUtils.generateRandomSalt();
        assertNotNull(salt);
        System.out.println(DatatypeConverter.printHexBinary(salt));
    }
    
    @Test
    public void createSHA2Hash() throws Exception{
        byte[] salt = HashUtils.generateRandomSalt();
        String valueToHash = UUID.randomUUID().toString();
        byte[] hash = HashUtils.createSHA2Hash(valueToHash, salt);
        assertNotNull(hash);
        byte[] hash2 = HashUtils.createSHA2Hash(valueToHash, salt);
        System.out.println("1 =" + hash + "2 = " + hash2);
        assertEquals(DatatypeConverter.printHexBinary(hash),DatatypeConverter.printHexBinary(hash2));
    }
    
    @Test
    public void testPasswordRoutine(){
        String secretPhrase = "my name is adib";
        String passwordHash = HashUtils.hashPassword(secretPhrase);
        System.out.println(passwordHash);
        assertTrue(HashUtils.verifyPassword(secretPhrase, passwordHash));
    }

    


    
  
    
}
