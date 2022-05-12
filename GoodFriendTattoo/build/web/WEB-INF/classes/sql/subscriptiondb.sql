/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  834171
 * Created: Jun 15, 2021
 */

DROP DATABASE if exists subscriptiondb;
CREATE DATABASE subscriptiondb;

USE subscriptiondb;

CREATE TABLE subscription (
    email VARCHAR(40) NOT NULL, 
    CONSTRAINT PK_username PRIMARY KEY (email));

INSERT INTO subscription(email)
VALUES
("admin@gmail.com");
COMMIT;