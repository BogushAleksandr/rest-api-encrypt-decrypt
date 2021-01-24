package com.ua.sasha.bogush.restapi.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 24.01.2021
 */
public class CryptBody implements Serializable {
    @SerializedName("fio_encr")
    @Expose
    private String fio_encr;
    private final static long serialVersionUID = -5975497595279092824L;

    public CryptBody(String fio_encr) {
        this.fio_encr = fio_encr;
    }

    public CryptBody() {
    }

    public String getFio_encr() {
        return fio_encr;
    }

    public void setFio_encr(String fio_encr) {
        this.fio_encr = fio_encr;
    }
}