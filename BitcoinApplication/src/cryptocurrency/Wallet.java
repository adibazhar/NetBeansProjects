/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptocurrency;

import crypto.BlockChain.BlockChain;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adib.a
 */
public class Wallet {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    
    public Wallet(){
        KeyPair keyPair = CryptographyHelper.ellipticCurveCrypto();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }
    
    public double calculateBalance(){
        double balance = 0;
        
        for(Map.Entry<String, TransactionOutput> item: BlockChain.UTXOs.entrySet()){
            TransactionOutput transactionOutput = item.getValue();
            if(transactionOutput.isMine(publicKey)){
                balance+=transactionOutput.getAmount();
            }
        }
        
        return balance;
    }
    
    public Transaction transferMoney(PublicKey receiver,double amount){
        if(calculateBalance()<amount){
            System.out.println("Invalid transaction because of insufficient money");
            return null;
        }
        
        List<TransactionInput> inputs = new ArrayList<TransactionInput>();
        
        for(Map.Entry<String,TransactionOutput> item: BlockChain.UTXOs.entrySet()){
            
            TransactionOutput UTXO = item.getValue();
            
            if(UTXO.isMine(this.publicKey)){
                inputs.add(new TransactionInput(UTXO.getId()));
            }
        }
        
        Transaction newTransaction = new Transaction(publicKey,receiver,amount,inputs);
        
        newTransaction.generateSignature(privateKey);
        return newTransaction;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
    
    
}
