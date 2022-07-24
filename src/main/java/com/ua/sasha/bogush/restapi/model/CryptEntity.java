package com.ua.sasha.bogush.restapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 23.01.2021
 */
@Entity
@Table(name = "ENCRYPT", schema = "DB_CRYPT")
public class CryptEntity implements Serializable {
    @SerializedName("id")
    @Expose
    @Id
    @NotNull
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @SerializedName("fio")
    @Expose
    @NotNull
    @Column(name = "FIO")
    private String fio;

    @Serial
    private final static long serialVersionUID = 7282733192813605264L;

    /**
     * @param id
     * @param fio
     */
    public CryptEntity(@NotNull Integer id, @NotNull String fio) {
        this.id = id;
        this.fio = fio;
    }

    public CryptEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}
