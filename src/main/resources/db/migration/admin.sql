CREATE TABLE IF NOT EXISTS ADMIN (
    ADMIN_ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100),
    EMAIL VARCHAR(100),
    PASSWORD VARCHAR(100),
    PRIMARY KEY (ADMIN_ID)
);