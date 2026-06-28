-- Create databases
CREATE DATABASE IF NOT EXISTS userDB;
CREATE DATABASE IF NOT EXISTS tradeDB;
CREATE DATABASE IF NOT EXISTS settlementDB;


USE userDB;

CREATE TABLE account (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    amount INT,
    shares INT,
    balance INT
);

CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

INSERT INTO account (amount, shares, balance)
VALUES (50000, 10, 100000);

INSERT INTO account (amount, shares, balance)
VALUES (10000, 50, 2000000);
INSERT INTO account (amount, shares, balance)
VALUES (100000, 40, 2000000);

INSERT INTO user (user_name, account_id)
VALUES ('Ravi', 1);

INSERT INTO user (user_name, account_id)
VALUES ('Priya', 2);

INSERT INTO user (user_name, account_id)
VALUES ('ABC', 3);


USE tradeDB;

CREATE TABLE trade (
    trade_id INT AUTO_INCREMENT PRIMARY KEY,
    buyer_id INT,
    seller_id INT,
    amount INT,
    shares INT,
    status VARCHAR(20)
);

INSERT INTO trade (buyer_id, seller_id, amount, shares, status)
VALUES (2, 3, 24000, 10, 'PENDING');

INSERT INTO trade (buyer_id, seller_id, amount, shares, status)
VALUES (2, 3, 999999, 10, 'PENDING');


USE settlementDB;

CREATE TABLE settlement (
    settlement_id INT AUTO_INCREMENT PRIMARY KEY,
    trade_id INT,
    status VARCHAR(20)
);