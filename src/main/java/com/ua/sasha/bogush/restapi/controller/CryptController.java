package com.ua.sasha.bogush.restapi.controller;

import com.ua.sasha.bogush.restapi.model.CryptBody;
import com.ua.sasha.bogush.restapi.model.CryptEntity;
import com.ua.sasha.bogush.restapi.model.DecryptBody;
import com.ua.sasha.bogush.restapi.service.CryptServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/api")
public class CryptController {
    private static final Logger LOG_CONTROLLER = LoggerFactory.getLogger(CryptController.class);
    private final CryptServiceImpl cryptService;

    public CryptController(CryptServiceImpl cryptService) {
        this.cryptService = cryptService;
    }

    @PostMapping(path = "/encrypt", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ResponseBody()
    public CryptBody encryptFIObyID(@RequestBody CryptEntity id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        Integer in = id.getId();
        LOG_CONTROLLER.info("id = " + in);
        CryptBody cryptBody = cryptService.getEncript(in);
        LOG_CONTROLLER.info("fio_encr = " + cryptBody.getFio_encr());
        return cryptService.getEncript(in);
    }

    @PostMapping(path = "/decrypt", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ResponseBody()
    public DecryptBody decryptFIO(@RequestBody CryptBody fio_encr)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        String fio = fio_encr.getFio_encr();
        LOG_CONTROLLER.info("FIO_ENCR = " + fio);
        DecryptBody decryptBody = cryptService.getDecrypt(fio_encr.getFio_encr());
        LOG_CONTROLLER.info("FIO_DECR = " + decryptBody.getFio());
        return decryptBody;
    }
}
