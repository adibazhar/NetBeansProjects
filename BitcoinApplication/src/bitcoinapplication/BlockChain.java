/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinapplication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adib.a
 */
public class BlockChain {

    private List<Block> blockChain;

    public BlockChain() {
        this.blockChain = new ArrayList<>();
    }
    
    public void addBlock(Block block){
        this.blockChain.add(block);
    }
    
    public List<Block> getBlockchain(){
        return this.blockChain;
    }

    public int size(){
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        String blockChain = "";
        
        for(Block block : this.blockChain)
            blockChain += block.toString()+"\n";
        
        
        return blockChain;
    }
    
    
}
