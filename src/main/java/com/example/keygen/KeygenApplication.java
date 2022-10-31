package com.example.keygen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application to generate secure 256-bit encryption keys.
 * The encryption keys are used in QR Generator and QR Reader
 * for random masking and unmasking, respectively.
 */
@SpringBootApplication
public class KeygenApplication {

	/**
	 * Main method of keygen application. Starts the keygen web app.
	 *
	 * @param args arguments for calling the main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(KeygenApplication.class, args);
	}

}
