package blockchain;

import com.google.gson.Gson;

class Miner {
    private int difficulty;
    private String target;

    private Gson gson;

    public Miner(int difficulty) {
        this.difficulty = difficulty;
        this.target = new String(new char[difficulty]).replace('\0', '0');
        this.gson = new Gson();
    }

    public Block mine(Block oldBlock, String transaction) {
        long nonce = 0;
        String hash = "";
        while (true) {
            nonce++;
            hash = Hasher.hash(gson.toJson(oldBlock) + transaction + nonce + oldBlock.getPreviousHash());
            if (hash.substring(0, difficulty).equals(target)) {
                break;
            }
        }
        return new Block(hash, oldBlock.getHash(), transaction, nonce);
    }

    public static boolean isValidHash(String input) {
        String hash = Hasher.hash(input);
        return hash.substring(0, 5).equals("00000");
    }
}
