/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.app;


import crypto.BlockChain.Block;
import crypto.BlockChain.BlockChain;
import crypto.constants.Constants;
import cryptocurrency.Miner;
import cryptocurrency.Transaction;
import cryptocurrency.TransactionOutput;
import cryptocurrency.Wallet;
import java.security.Security;

/**
 *
 * @author adib.a
 */
public class main {
    public static void main(String[] args) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        
        Wallet userA = new Wallet();
        Wallet userB = new Wallet();
        Wallet lender = new Wallet();
        BlockChain chain = new BlockChain();
        Miner miner = new Miner();
        
        Transaction genesisTransaction = new Transaction(lender.getPublicKey(),userA.getPublicKey(),500,null);
        genesisTransaction.generateSignature(lender.getPrivateKey());
        genesisTransaction.setTransactionId("0");
        genesisTransaction.outputs.add(new TransactionOutput(genesisTransaction.getReceiver(),genesisTransaction.getAmount(),genesisTransaction.getTransactionId()));
        BlockChain.UTXOs.put(genesisTransaction.outputs.get(0).getId(), genesisTransaction.outputs.get(0));
        
        System.out.println("Constructing the genesis block....");
        Block genesis = new Block(Constants.GENESIS_PREV_HASH);
        genesis.addTransaction(genesisTransaction);
        miner.mine(genesis, chain);
        
        Block block1 = new Block(genesis.getHash());
        System.out.println("\nuserA's balance is: "+ userA.calculateBalance());
        System.out.println("\nuserA tries to send money (120 coins) to userB...");
        block1.addTransaction(userA.transferMoney(userB.getPublicKey(), 120));
        miner.mine(block1, chain);
        System.out.println("\nuserA's balance is: "+ userA.calculateBalance());
        System.out.println("\nuserB's balance is: "+ userB.calculateBalance());
        
        Block block2 = new Block(block1.getHash());
        System.out.println("\nuserA sends more funds (600) than it has....");
        block2.addTransaction(userA.transferMoney(userB.getPublicKey(), 600));
        miner.mine(block2, chain);
        System.out.println("\nuserA's balance is: "+ userA.calculateBalance());
        System.out.println("\nuserB's balance is: "+ userB.calculateBalance());
        
        Block block3 = new Block(block2.getHash());
        System.out.println("\nuserB is attempting to send funds (110) to userA....");
        block3.addTransaction(userB.transferMoney(userA.getPublicKey(), 110));
        System.out.println("\nuserA's balance is: "+ userA.calculateBalance());
        System.out.println("\nuserB's balance is: "+ userB.calculateBalance());
        miner.mine(block3, chain);
        
        System.out.println("Miner's reward: "+ miner.getReward());
        
    }
}
