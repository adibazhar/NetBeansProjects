/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingmerkletree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adib.a
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> transactions = new ArrayList<>();
        transactions.add("aa");
        transactions.add("bb");
        transactions.add("dd");
        transactions.add("ee");
        transactions.add("11");
        transactions.add("22");
        transactions.add("33");
        transactions.add("44");
        transactions.add("55");
        
        MerkleTree merkleTree = new MerkleTree(transactions);
        System.out.println(merkleTree.getMerkleRoot().get(0));
    }
    
}
