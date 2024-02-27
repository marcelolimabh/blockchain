package br.com.onnitech.blockchain.models;


import br.com.onnitech.blockchain.utils.Utils;
import lombok.Data;
import lombok.ToString;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Data
@ToString
public class Block {

    private int index;
    private long timestamp;

    private String hash;

    private String previousHash;

    private String data;

    private int nonce;


    public Block(int index, long timestamp, String previousHash, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        nonce = 0;
        hash = Block.calculateHash(this);
    }

    public static String calculateHash(Block block) {
        if (block != null) {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ex) {
                return null;
            }
            String txt = block.str();
            final byte bytes[] = digest.digest(Objects.requireNonNull(txt).getBytes());
            final StringBuilder builder = new StringBuilder();

            for (final byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    builder.append('0');
                }
                builder.append(hex);
            }
            return builder.toString();
        }
        return null;
    }

    private String str() {
        return index + timestamp + previousHash + data + nonce;
    }

    public void proofOfWork(int difficulty) {
        nonce = 0;

        while (!getHash().substring(0, difficulty).equals(Utils.zeros(difficulty))) {
            nonce++;
            hash = Block.calculateHash(this);
        }

    }

}
