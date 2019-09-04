/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author adib.a
 */
public class CaesarEncrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // int i = 3;
        // System.out.println((char) (i + 'a' -1));

        Scanner in = new Scanner(System.in);

        System.out.print("Insert your text = ");
        String text = in.nextLine().trim();
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
            int ascii = (int) (input + key);
            newString.setCharAt(i, (char) ascii);
            //System.out.print(Character.toString((char)ascii));
            i++;
        }

        System.out.println("Ciphertext = " + newString);
        /*int j=0;
         while(j<text.length()){
         System.out.println(Character.toString(newArray[j]));
         j++;
         }*/
       // char a = 'a';
        /*int ascii = (int)a+2;
         System.out.println("ascii="+ascii);
         System.out.println("charc" + Character.toString((char) ascii));*/

    }

}
