package com.ua.sasha.bogush.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
/*import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;*/

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@SpringBootApplication
public class RestApp {

    public static void main(String[] args) throws BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        SecretKeys.givenPassword_whenEncrypt_thenSuccess();
       /* final String password = "Here is the password";
        String textToEncrypt = "Hello";
        for (int i = 0; i < 10; i++) {
            String salt = KeyGenerators.string().generateKey();
            TextEncryptor encryptor = Encryptors.text(password, salt);
            String cipherText = encryptor.encrypt(textToEncrypt);
            String decryptedText = encryptor.decrypt(cipherText);
            System.out.println("Src: " + textToEncrypt);
            System.out.println("Cipher: " + cipherText);
            System.out.println("Decrypted: " + decryptedText);
            System.out.println("__________________");
        }*/
        SpringApplication.run(RestApp.class, args);
    }

}
