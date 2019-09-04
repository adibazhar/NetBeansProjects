/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinapplication;

import java.util.Date;

/**
 *
 * @author adib.a
 */
public class Block {
    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String previousHash;
    private String transaction;

    public Block(int id, String previousHash, String transaction) {
        this.id = id;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash(){
        String dataToHash = Integer.toString(id)+previousHash+Long.toString(timeStamp)+Integer.toString(nonce)+transaction.toString();
        String hashValue = SHA256Helper.generateHash(dataToHash);
        this.hash = hashValue;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void incrementNonce(){
        this.nonce++;
    }

    @Override
    public String toString() {
        return this.id +"-" + this.transaction+"-"+ this.hash+"-"+this.previousHash+"-"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
