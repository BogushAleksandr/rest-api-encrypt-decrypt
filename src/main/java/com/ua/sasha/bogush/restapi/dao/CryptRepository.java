package com.ua.sasha.bogush.restapi.dao;

import com.ua.sasha.bogush.restapi.model.CryptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Repository
public interface CryptRepository extends JpaRepository<CryptEntity, BigInteger> {
}
