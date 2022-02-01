CREATE TABLE IF NOT EXISTS CONTACT (
    NAME VARCHAR(100),
    EMAIL VARCHAR(100),
    PHONE_NO INT,
    MESSAGE VARCHAR(100),
    CONTACT_ID INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (CONTACT_ID)
);