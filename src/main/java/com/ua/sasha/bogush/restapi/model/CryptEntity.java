package com.ua.sasha.bogush.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Entity
@Table(name = "ENCRYPT_DECRYPT")
public class CryptEntity implements Serializable {
    @Id
    @NotNull
    @Column(name = "ID", nullable = false, unique = true)
    private BigDecimal id;

    @NotNull
    @Column(name = "FIO")
    private String fio;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
