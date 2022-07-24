package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.dao.CryptRepository;
import com.ua.sasha.bogush.restapi.model.CryptBody;
import com.ua.sasha.bogush.restapi.model.DecryptBody;
import com.ua.sasha.bogush.restapi.util.AESUtil;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Service
public class CryptServiceImpl implements CryptService {
    private final CryptRepository cryptRepository;
    private final AESUtil aesUtil;
    private static final IvParameterSpec IV_PARAMETER_SPEC = AESUtil.generateIv();
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * @param cryptRepository
     * @param aesUtil
     * @author Oleksandr Bogush
     * @since 24.01.2021
     */
    public CryptServiceImpl(CryptRepository cryptRepository, AESUtil aesUtil) {
        this.cryptRepository = cryptRepository;
        this.aesUtil = aesUtil;
    }

    private static SecretKey key;

    static {
        try {
            key = AESUtil.generateKey(256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return CryptBody
     * @author Oleksandr Bogush
     * @since 24.01.2021
     */
    public CryptBody getEncrypt(Integer id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalArgumentException {
        var cryptEntity = cryptRepository.findById(id);

        var fioEncrypt = aesUtil.encrypt(ALGORITHM, cryptEntity.orElseThrow().getFio(), key, IV_PARAMETER_SPEC);

        var cryptBody = new CryptBody();
        cryptBody.setFio_encr(fioEncrypt);
        return cryptBody;
    }

    /**
     * @param encryptText
     * @return CryptBody
     * @author Oleksandr Bogush
     * @since 24.01.2021
     */
    public DecryptBody getDecrypt(String encryptText)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        var fioDecrypt = aesUtil.decrypt(ALGORITHM, encryptText, key, IV_PARAMETER_SPEC);

        var decryptBody = new DecryptBody();
        decryptBody.setFio(fioDecrypt);
        return decryptBody;
    }
}
