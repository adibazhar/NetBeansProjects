/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoinapplication;

/**
 *
 * @author adib.a
 */
public class BitcoinApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();
        
        Block block0 = new Block(0,"transactions1",Constants.GENESIS_PREV_HASH);
        miner.mine(block0,blockChain);
        
        Block block1 = new Block(1,"transactions2",blockChain.getBlockchain().get(blockChain.size()-1).getHash());
        miner.mine(block1, blockChain);
        
        Block block2 = new Block(2,"transactions3",blockChain.getBlockchain().get(blockChain.size()-1).getHash());
        miner.mine(block2,blockChain);
        
        System.out.println("\n" + "BlockChain:\n" + blockChain);
        System.out.println("Miner's Reward: " + miner.getReward());
    }
    
}
