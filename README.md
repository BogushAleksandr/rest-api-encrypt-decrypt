# REST API для Шифрования и Дешифрования AES-256 алгоритмом
### Используются библиотеки и зависимости:
1. OpenJDK version **1.8.0_282**
2. Apache Maven **3.6.0**
3. Spring boot **2.3.8**:
  + spring-boot-starter-web;
  + spring-boot-starter-validation;
  + spring-boot-starter-data-jpa;
  + spring-boot-starter-tomcat;
  + spring-boot-starter-log4j2;
  + spring-boot-configuration-processor;
  + mysql-connector-java;
  + gson.
4. Запрос и ответ логируются в отдельный файл (app.log), с указанием метки времени.
5. Проект собирается в WAR, для установки на Tomcat.
PS. WAR проверялся на apache-tomcat-9.0.41.
### Для работы нужно скачать проект 
git clone https://github.com/BogushAleksandr/rest-api-encrypt-decrypt.git && cd rest-api-encrypt-decrypt
### Собираем проект
mvn clean package
### Запускаем проект 
mvn spring-boot:run
### Для примера используется БД MySQL
>Если нет тестовой БД, создаём и заполняем её.
```mysql
CREATE DATABASE DB_CRYPT;

DROP TABLE IF EXISTS DB_CRYPT.ENCRYPT;

CREATE TABLE IF NOT EXISTS DB_CRYPT.encrypt
(
    ID  DECIMAL(38)  NOT NULL,
    FIO VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO DB_CRYPT.encrypt (ID, FIO)
VALUES (0, 'Tds Testovy');
INSERT INTO DB_CRYPT.encrypt (ID, FIO)
VALUES (1, 'Test Testov');
INSERT INTO DB_CRYPT.encrypt (ID, FIO)
VALUES (2, 'Tom Cat');
SELECT * FROM DB_CRYPT.encrypt;
```
### Шифрование запроса
>Принимает на вход id пользователя, шифрует его ФИО (ФИО брать из бд) и возвращает в ответе.

>POST http://localhost:8090/api/encrypt

>Пример запроса BODY:
```json
{"id": 1}
```
>Пример ответа BODY:
```json
{"fio_encr": "qO/bv33IDN0A+4XLciVggg=="}
```
>В файле логирования мы увидим:

> 2021-01-24 18:17:47,061 INFO c.u.s.b.r.c.CryptController [http-nio-8090-exec-3] id = 1

> 2021-01-24 18:17:47,214 INFO c.u.s.b.r.c.CryptController [http-nio-8090-exec-3] fio_encr = qO/bv33IDN0A+4XLciVggg==

### Дешифрование запроса.
>   Принимает на вход зашифрованную строку с ФИО, на выходе дешифрованная строка с ФИО.

>   Пример запроса BODY:
```json
{"fio_encr": "qO/bv33IDN0A+4XLciVggg=="}
```
>   Пример ответа BODY:

```json
 {"fio": "Test Testov"}
```  
>В файле логирования мы увидим:

> 2021-01-24 18:17:55,511 INFO c.u.s.b.r.c.CryptController [http-nio-8090-exec-2] fio_encr = qO/bv33IDN0A+4XLciVggg==

> 2021-01-24 18:17:55,514 INFO c.u.s.b.r.c.CryptController [http-nio-8090-exec-2] fio = Test Testov
