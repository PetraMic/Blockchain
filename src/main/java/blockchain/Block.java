package blockchain;

import lombok.Getter;

@Getter
class Block {
    private final String hash;
    private final String previousHash;
    private final String transaction;
    private final long nonce;

    public Block(String hash, String previousHash, String transaction, long nonce) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.nonce = nonce;
    }
}
