--2
CREATE SEQUENCE seq_movie_id INCREMENT BY 5 START WITH 20;

--3
select * from user_sequences;

--4
select seq_movie_id.NEXTVAL from user_sequences;

--5
INSERT INTO mm_movie VALUES(seq_movie_id.NEXTVAL,'ludo',4,19.99,1);

--6
CREATE VIEW VW_MOVIE_RENTAL AS
SELECT movie.movie_title,rental.rental_id,member.last FROM mm_movie movie,mm_rental rental,mm_member member
WHERE movie.movie_id=rental.rental_id AND rental.rental_id=member.member_id;

--7
SELECT * FROM VW_MOVIE_RENTAL;

--8
CREATE PUBLIC SYNONYM m_type FOR MM_MOVIE_TYPE;




Microsoft Windows [Version 10.0.18362.356]
(c) 2019 Microsoft Corporation. All rights reserved.

C:\Users\834171\Downloads\CPRG307 DatabaseDesignTesting\Lab 1>SQLPLUS

SQL*Plus: Release 18.0.0.0.0 - Production on Thu Jan 21 16:10:10 2021
Version 18.4.0.0.0

Copyright (c) 1982, 2018, Oracle.  All rights reserved.

Enter user-name: CPRG307
Enter password:
ERROR:
ORA-01017: invalid username/password; logon denied


Enter user-name: CPRG307
Enter password:
Last Successful login time: Mon Jan 18 2021 15:29:00 -07:00

Connected to:
Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production
Version 18.4.0.0.0

SQL> CREATE SEQUENCE seq_movie_id INCREMENT BY 5 START WITH 20;

Sequence created.

SQL> select seq_movie_id.nextval;
select seq_movie_id.nextval
                          *
ERROR at line 1:
ORA-00923: FROM keyword not found where expected


SQL> select seq_movie_id.nextval from dual;

   NEXTVAL
----------
        20

SQL> select seq_movie_id.nextval from dual;

   NEXTVAL
----------
        25

SQL> select seq_movie_id.currentval from dual;
select seq_movie_id.currentval from dual
       *
ERROR at line 1:
ORA-00904: "SEQ_MOVIE_ID"."CURRENTVAL": invalid identifier


SQL> select seq_movie_id.currval from dual;

   CURRVAL
----------
        25

SQL> drop seq_movie_id;
drop seq_movie_id
     *
ERROR at line 1:
ORA-00950: invalid DROP option


SQL> drop sequence seq_movie_id;

Sequence dropped.

SQL> select seq_movie_id.currval from dual;
select seq_movie_id.currval from dual
       *
ERROR at line 1:
ORA-02289: sequence does not exist


SQL> clr scr
SP2-0042: unknown command "clr scr" - rest of line ignored.
SQL> CREATE SEQUENCE seq_movie_id INCREMENT BY 5 START WITH 20;

Sequence created.

SQL> select *  from user_sequences;

SEQUENCE_NAME
--------------------------------------------------------------------------------
 MIN_VALUE  MAX_VALUE INCREMENT_BY C O CACHE_SIZE LAST_NUMBER S E S K
---------- ---------- ------------ - - ---------- ----------- - - - -
MM_RENTAL_SEQ
         1 1.0000E+28            1 N N         20          13 N N N N

SEQ_MOVIE_ID
         1 1.0000E+28            5 N N         20          20 N N N N


SQL> select *  from user_sequences;

SEQUENCE_NAME
--------------------------------------------------------------------------------
 MIN_VALUE  MAX_VALUE INCREMENT_BY C O CACHE_SIZE LAST_NUMBER S E S K
---------- ---------- ------------ - - ---------- ----------- - - - -
MM_RENTAL_SEQ
         1 1.0000E+28            1 N N         20          13 N N N N

SEQ_MOVIE_ID
         1 1.0000E+28            5 N N         20          20 N N N N


SQL> select seq_movie_id.NEXTVAL from user_sequences;

   NEXTVAL
----------
        20
        25

SQL> desc mm_movie
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 MOVIE_ID                                  NOT NULL NUMBER(4)
 MOVIE_TITLE                                        VARCHAR2(40)
 MOVIE_CAT_ID                              NOT NULL NUMBER(2)
 MOVIE_VALUE                                        NUMBER(5,2)
 MOVIE_QTY                                          NUMBER(2)

SQL> INSERT INTO mm_movie VALUES(seq_movie_id.NEXTVAL,'ludo',6,19.99,1);
INSERT INTO mm_movie VALUES(seq_movie_id.NEXTVAL,'ludo',6,19.99,1)
*
ERROR at line 1:
ORA-02291: integrity constraint (CPRG307.MOVIE_TYPE_FK) violated - parent key
not found


SQL> select *from mm_movie;

  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         1 Alien                                               1          10
         5

         2 Bladerunner                                         1           8
         3

         3 Star Wars                                           1          15
        11


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         4 Texas Chainsaw Masacre                              2           7
         2

         5 Jaws                                                2           7
         1

         6 The good, the bad and the ugly                      3           7
         2


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         7 Silverado                                           3           7
         1

         8 Duck Soup                                           4           5
         1

         9 Planes, trains and automobiles                      4           5
         3


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
        10 Waking Ned Devine                                   4          12
         4

        11 Deep Blue Sea                                       5          14
         3

        12 The Fifth Element                                   5          15
         5


12 rows selected.

SQL> INSERT INTO mm_movie VALUES(seq_movie_id.NEXTVAL,'ludo',4,19.99,1);

1 row created.

SQL> select *from mm_movie;

  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         1 Alien                                               1          10
         5

         2 Bladerunner                                         1           8
         3

         3 Star Wars                                           1          15
        11


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         4 Texas Chainsaw Masacre                              2           7
         2

         5 Jaws                                                2           7
         1

         6 The good, the bad and the ugly                      3           7
         2


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
         7 Silverado                                           3           7
         1

         8 Duck Soup                                           4           5
         1

         9 Planes, trains and automobiles                      4           5
         3


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
        10 Waking Ned Devine                                   4          12
         4

        11 Deep Blue Sea                                       5          14
         3

        12 The Fifth Element                                   5          15
         5


  MOVIE_ID MOVIE_TITLE                              MOVIE_CAT_ID MOVIE_VALUE
---------- ---------------------------------------- ------------ -----------
 MOVIE_QTY
----------
        35 ludo                                                4       19.99
         1


13 rows selected.

SQL> select seq_movie_id.currVAL from user_sequences;

   CURRVAL
----------
        35
        35

SQL> CREATE VIEW VW_MOVIE_RENTAL AS
  2  SELECT movie.movie_title,rental.rental_id,member.last FROM mm_movie movie,mm_rental rental,mm_member member
  3  WHERE movie.movie_id=rental.rental_id AND rental.rental_id=member.member_id;

View created.

SQL> SELECT * FROM VW_MOVIE_RENTAL;

MOVIE_TITLE                               RENTAL_ID LAST
---------------------------------------- ---------- ------------
Waking Ned Devine                                10 Tangier
Deep Blue Sea                                    11 Ruth
The Fifth Element                                12 Maulder

SQL> CREATE PUBLIC SYNONYM m_type FOR MM_MOVIE_TYPE;

Synonym created.

SQL> EXIT
Disconnected from Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production
Version 18.4.0.0.0

C:\Users\834171\Downloads\CPRG307 DatabaseDesignTesting\Lab 1>CPRG307A
'CPRG307A' is not recognized as an internal or external command,
operable program or batch file.

C:\Users\834171\Downloads\CPRG307 DatabaseDesignTesting\Lab 1>SQLPLUS

SQL*Plus: Release 18.0.0.0.0 - Production on Thu Jan 21 16:58:33 2021
Version 18.4.0.0.0

Copyright (c) 1982, 2018, Oracle.  All rights reserved.

Enter user-name: CPRG307A
Enter password:

Connected to:
Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production
Version 18.4.0.0.0

SQL> desc m_type;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 MOVIE_CAT_ID                              NOT NULL NUMBER(2)
 MOVIE_CATEGORY                                     VARCHAR2(12)

SQL>