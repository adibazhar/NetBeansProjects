/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.util.Scanner;

/**
 *
 * @author adib.a
 */
public class CaesarDecrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Insert your ciphertext = ");
        String text = in.nextLine();
        System.out.print("Insert key = ");
        int key = in.nextInt();
       
        StringBuilder newString = new StringBuilder(text);
        
        int i = 0;
        while (i < text.length()) {
            char input = text.charAt(i);
            if(input==' '){
                newString.setCharAt(i, (char) ' ');
                i++;
                continue;
            }
            int ascii = (int)(input-key);
           newString.setCharAt(i,(char) ascii);
             //System.out.print(Character.toString((char)ascii));
             i++;
        }
        
        System.out.println("Plaintext = " +newString);
    }
}
