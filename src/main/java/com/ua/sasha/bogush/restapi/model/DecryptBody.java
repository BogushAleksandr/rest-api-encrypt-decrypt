package com.ua.sasha.bogush.restapi.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 24.01.2021
 */
public class DecryptBody implements Serializable {

    @SerializedName("fio")
    @Expose
    private String fio;
    private final static long serialVersionUID = -4155117736899628314L;

    /**
     * No args constructor for use in serialization
     */
    public DecryptBody() {
    }

    /**
     * @param fio
     */
    public DecryptBody(String fio) {
        super();
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}
