package br.com.onnitech.blockchain;

import br.com.onnitech.blockchain.business.Blockchain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(BlockchainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Blockchain started!!");
		Blockchain blockchain = new Blockchain(4);
		blockchain.addBlock(blockchain.newBlock("Onnitech Bitcoin"));
		blockchain.addBlock(blockchain.newBlock("Marcelo Bicalho"));
		blockchain.addBlock(blockchain.newBlock("https://www.onnitech.com.br"));

		logger.info("Blockchain valid ? " + blockchain.isBlockChainValid());
		logger.info(blockchain.toString());



	}
}
