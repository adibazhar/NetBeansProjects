/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingmerkletree;

import java.security.MessageDigest;

/**
 *
 * @author adib.a
 */
public class SHA256Helper {
    
    public static String hash(String data){
        
        try{
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            
            StringBuffer hexadecimalString = new StringBuffer();
            
            for (int i = 0; i < hash.length; i++) {
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if(hexadecimal.length()==1) hexadecimalString.append('0');
                hexadecimalString.append(hexadecimal);
            }
            
            return hexadecimalString.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
