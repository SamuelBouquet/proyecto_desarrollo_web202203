package co.edu.javeriana.libreria;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.security.MessageDigest;

@SpringBootTest
class LibreriaApplicationTests {

	@Test
	void contextLoads() {
	}


	public String codify(String text) throws Exception {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(text.getBytes());
		byte[] codify = m.digest();
		BigInteger bigInt = new BigInteger(1, codify);
		String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

}
