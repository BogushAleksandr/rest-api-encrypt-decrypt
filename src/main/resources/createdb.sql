CREATE DATABASE dbcrypt;

DROP TABLE IF EXISTS ENCRYPT_DECRYPT;

CREATE TABLE IF NOT EXISTS ENCRYPT_DECRYPT
(
    ID  DECIMAL(38)  NOT NULL,
    FIO VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

/*CREATE SCHEMA `BAS3_FRONT` DEFAULT CHARACTER SET utf8 ;*/