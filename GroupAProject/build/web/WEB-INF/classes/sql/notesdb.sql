DROP DATABASE if exists notesdb;
CREATE DATABASE notesdb;

USE notesdb;

CREATE TABLE users (
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    firstname VARCHAR(20), 
    lastname VARCHAR(20), 
    email VARCHAR(40), 
    CONSTRAINT PK_username PRIMARY KEY (username));

INSERT INTO users(username, password, firstname, lastname, email)
VALUES
("admin","password", null, null, "sait.cprg.352+admin@gmail.com"),
("annet","pass","Anne","Teak","sait.cprg.352+anne@gmail.com"),
("matildak","pass","Matilda","Keybroke","sait.cprg.352+matilda@gmail.com"),
("jerrya","pass","Jerry","Atrick","sait.cprg.352+jerry@gmail.com"),
("barbk","pass","Barbie","Kendall","sait.cprg.352+barb@gmail.com"),
("willm","pass","Billy","Maizear","sait.cprg.352+billy@gmail.com"),
("pattyf","pass","Patrick","O'Furniture","sait.cprg.352+patty@gmail.com");
COMMIT;

CREATE TABLE notes (
    noteid VARCHAR(4) NOT NULL,
    title VARCHAR(20) NOT NULL,
    contents VARCHAR(10000),
    author VARCHAR(20),
    CONSTRAINT PK_noteid PRIMARY KEY (noteid));

INSERT INTO notes(noteid, title, contents, author)
VALUES
("1111", "Test1", "Testing", "Author1"),
("2222", "Test2", "Testing", "Author2"),
("3333", "Test3", "Testing", "Author3"),
("4444", "Test4", "Testing", "Author4"),
("5555", "Test5", "Testing", "Author5");
COMMIT;