package com.m2ibank;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;


@SpringBootApplication
public class M2iBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2iBankBackendApplication.class, args);
		/* Génére une clé de signature.*/
//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//
//		String base64key = Encoders.BASE64.encode(key.getEncoded());
//
//		System.out.println(base64key);

	}

}
