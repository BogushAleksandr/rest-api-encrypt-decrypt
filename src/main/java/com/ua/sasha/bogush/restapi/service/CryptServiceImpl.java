package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.dao.CryptRepository;
import com.ua.sasha.bogush.restapi.model.CryptBody;
import com.ua.sasha.bogush.restapi.model.CryptEntity;
import com.ua.sasha.bogush.restapi.model.DecryptBody;
import com.ua.sasha.bogush.restapi.util.AESUtil;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Service
public class CryptServiceImpl implements CryptService {
    private final CryptRepository cryptRepository;
    private final AESUtil aesUtil;

    /**
     * @param cryptRepository
     * @param aesUtil
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 24.01.2021
     */
    public CryptServiceImpl(CryptRepository cryptRepository, AESUtil aesUtil) {
        this.cryptRepository = cryptRepository;
        this.aesUtil = aesUtil;
    }

    private static SecretKey key;

    static {
        try {
            key = new AESUtil().generateKey(256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static final IvParameterSpec ivParameterSpec = new AESUtil().generateIv();
    private static final String algorithm = "AES/CBC/PKCS5Padding";

    /**
     * @param id
     * @return CryptBody
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 24.01.2021
     */
    public CryptBody getEncript(Integer id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        Optional<CryptEntity> cryptEntity = cryptRepository.findById(id);

        String fio_encrypt = aesUtil.encrypt(algorithm, cryptEntity.get().getFio(), key, ivParameterSpec);

        CryptBody cryptBody = new CryptBody();
        cryptBody.setFio_encr(fio_encrypt);
        return cryptBody;
    }

    /**
     * @param encryptText
     * @return CryptBody
     * @author Oleksandr Bogush
     * @version 1.0
     * @since 24.01.2021
     */
    public DecryptBody getDecrypt(String encryptText)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        String fio_decrypt = aesUtil.decrypt(algorithm, encryptText, key, ivParameterSpec);

        DecryptBody decryptBody = new DecryptBody();
        decryptBody.setFio(fio_decrypt);
        return decryptBody;
    }
}
