/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.BlockChain;

import crypto.BlockChain.Block;
import cryptocurrency.TransactionOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adib.a
 */
public class BlockChain {
    public static ArrayList<Block> blockChain;
    public static Map<String,TransactionOutput> UTXOs;
    
    public BlockChain(){
    BlockChain.UTXOs = new HashMap<String,TransactionOutput>();
    BlockChain.blockChain = new ArrayList<>();
}
    
    public void addBlock(Block block){
        BlockChain.blockChain.add(block);
    }
    
    public int size(){
        return BlockChain.blockChain.size();
    }

    @Override
    public String toString() {
        String blockChain = "";
        
        for(Block block : this.blockChain)
            blockChain += block.toString()+"\n";
        
        
        return blockChain; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
