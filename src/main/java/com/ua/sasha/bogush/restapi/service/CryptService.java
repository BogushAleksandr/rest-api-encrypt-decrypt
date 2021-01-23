package com.ua.sasha.bogush.restapi.service;

import com.ua.sasha.bogush.restapi.model.CryptEntity;

import java.math.BigInteger;

public interface CryptService {
    CryptEntity getEncript(BigInteger id);

    CryptEntity getDecript(String fio);
}
