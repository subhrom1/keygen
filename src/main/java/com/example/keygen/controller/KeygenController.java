package com.example.keygen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * The controller class which accepts requests for creation of
 * 256-bit AES encryption keys.
 */
@RestController
public class KeygenController {


    /**
     * Secure QR code generation endpoint. Generates secure QR codes by using a 256 bit
     * encryption key. The secure QR code can only be detected and scanned by a reader which
     * has the encrypted key.
     */
    @GetMapping("/keygen")
    public ResponseEntity index() {
        try {
            //Generates key
            String key = generateKey();
            return ResponseEntity.ok(key);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return ResponseEntity.badRequest()
                    .body("Error in Encryption Key Generation.");
        }
    }

    /*
     * Fetches secure key in String format.
     */
    private String generateKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        SecureRandom rand = new SecureRandom();
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, rand);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}