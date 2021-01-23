package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.dao.CryptRepository;
import com.ua.sasha.bogush.restapi.model.CryptEntity;
import com.ua.sasha.bogush.restapi.util.AESUtil;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Service
public class CryptServiceImpl {
    private final CryptRepository cryptRepository;
    private final AESUtil aesUtil;

    public CryptServiceImpl(CryptRepository cryptRepository, AESUtil aesUtil) {
        this.cryptRepository = cryptRepository;
        this.aesUtil = aesUtil;
    }

   /* public CryptEntity getText(BigInteger id){
        return cryptRepository.findById(id).orElse(null);
    }*/

    public String getEncript(BigInteger id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        CryptEntity cryptEntity = cryptRepository.findById(id).orElse(null);
        String text = cryptEntity.getFio();
        SecretKey key = aesUtil.generateKey(256);
        IvParameterSpec ivParameterSpec = aesUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String fio_encript = aesUtil.encrypt(algorithm, text, key, ivParameterSpec);
        return fio_encript;
    }

    public CryptEntity getDecrypt(String text) {
        return null;
    }
}
