package com.example.exercice01;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class Exercice01Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercice01Application.class, args);
		/* Génére une clé de signature.
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

		String base64key = Encoders.BASE64.encode(key.getEncoded());

		System.out.println(base64key);
		*/
	}

}
