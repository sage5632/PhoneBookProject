CREATE TABLE phone_book(
        id NUMBER(10),
        name VARCHAR2(20) NOT NULL,
        hp VARCHAR2(30) NOT NULL,
        tel VARCHAR2(30) NOT NULL,
        PRIMARY KEY(id)
        );
        
CREATE SEQUENCE SEQ_PHONE_BOOK_PK
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 10000000;
                
SELECT * FROM PHONE_BOOK;