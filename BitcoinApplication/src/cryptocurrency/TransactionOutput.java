/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptocurrency;

import java.security.PublicKey;

/**
 *
 * @author adib.a
 */
public class TransactionOutput {
 
    private String id;
    private String parentTransactionId;
    private PublicKey receiver;
    private double amount;

    public TransactionOutput(PublicKey receiver, double amount,String parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
        this.receiver = receiver;
        this.amount = amount;
        generateId();
    }
    
    private void generateId(){
        this.id = CryptographyHelper.generateHash(receiver.toString()+Double.toString(amount)+parentTransactionId);
    }
    
    public boolean isMine(PublicKey publicKey){
        return publicKey==receiver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(String parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
    }

    public PublicKey getReceiver() {
        return receiver;
    }

    public void setReceiver(PublicKey receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
