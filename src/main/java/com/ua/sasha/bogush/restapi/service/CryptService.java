package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.model.CryptBody;
import com.ua.sasha.bogush.restapi.model.DecryptBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
public interface CryptService {
    /**
     * @param id
     * @return CryptBody
     * @author Oleksandr Bogush
     * @since 24.01.2021
     */
    CryptBody getEncrypt(Integer id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException;

    /**
     * @param encryptText
     * @return CryptBody
     * @author Oleksandr Bogush
     * @since 24.01.2021
     */
    DecryptBody getDecrypt(String encryptText)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException;
}
