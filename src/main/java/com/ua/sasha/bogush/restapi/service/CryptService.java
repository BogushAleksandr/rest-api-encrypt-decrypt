package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.dao.CryptRepository;
import org.springframework.stereotype.Service;

@Service
public class CryptService {
    private final CryptRepository cryptRepository;

    public CryptService(CryptRepository cryptRepository) {
        this.cryptRepository = cryptRepository;
    }

}
