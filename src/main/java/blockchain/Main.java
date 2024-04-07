package blockchain;

public class Main {
    public static void main(String[] args) {
        Block genesisBlock = new Block("0", "0", "Genesis Block", 0);
        Miner miner = new Miner(5);

        Block block1 = miner.mine(genesisBlock, "Transaction 1");
        System.out.println("Mined block 1: " + block1.getHash());

        Block block2 = miner.mine(block1, "Transaction 2");
        System.out.println("Mined block 2: " + block2.getHash());
    }
}
