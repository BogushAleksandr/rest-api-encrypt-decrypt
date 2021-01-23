package com.ua.sasha.bogush.restapi.controller;

import com.ua.sasha.bogush.restapi.model.CryptEntity;
import com.ua.sasha.bogush.restapi.service.CryptServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
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

    @PostMapping(path = "/encrypt", produces = "application/json;charset=UTF-8")
    @ResponseBody()
    public String encryptFIObyID(@RequestBody BigInteger id)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        LOG_CONTROLLER.info("id = " + id);
        return cryptService.getEncript(id);
    }

    @PostMapping(path = "/decrypt", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public CryptEntity decryptFIO(String text) {
        LOG_CONTROLLER.info("FIO = " + text);
        return cryptService.getDecrypt(text);
    }
}
