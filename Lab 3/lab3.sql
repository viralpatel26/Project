--prelab
--1
DECLARE
v_hiredate DATE := TO_DATE('JANUARY-10-2013','MONTH-DD-YYYY');
v_surname VARCHAR2(30);
v_firstname VARCHAR2(30);
k_salary CONSTANT NUMBER(5,2) := 100.25;
BEGIN
v_firstname := 'VIRAL';
v_surname := 'PATEL';
DBMS_OUTPUT.PUT_LINE(v_hiredate);
DBMS_OUTPUT.PUT_LINE(v_surname);
DBMS_OUTPUT.PUT_LINE(v_firstname);
DBMS_OUTPUT.PUT_LINE(k_salary);
END;
/

--3
DECLARE
ata_agentid ATA_AGENT.AGENT_ID%TYPE;
ata_lastname ATA_AGENT.LAST_NAME%TYPE;
ata_firstname ATA_AGENT.FIRST_NAME%TYPE;
ata_datehire ATA_AGENT.DATE_OF_HIRE%TYPE;
ata_homephone ATA_AGENT.HOME_PHONE%TYPE;
ata_businessphone ATA_AGENT.BUSINESS_PHONE%TYPE;
BEGIN
SELECT AGENT_ID,LAST_NAME,FIRST_NAME,DATE_OF_HIRE,HOME_PHONE,BUSINESS_PHONE
INTO ata_agentid,ata_lastname,ata_firstname,ata_datehire,ata_homephone,ata_businessphone FROM ATA_AGENT
WHERE AGENT_ID =0000002;
DBMS_OUTPUT.PUT_LINE(ata_agentid||' '||ata_lastname||' '||ata_firstname||' '||ata_datehire||' '||ata_homephone||' '||ata_businessphone);
END;
/


--4
DECLARE
TYPE type_agent IS RECORD(
ata_agentid ATA_AGENT.AGENT_ID%TYPE;
ata_lastname ATA_AGENT.LAST_NAME%TYPE;
ata_firstname ATA_AGENT.FIRST_NAME%TYPE;
ata_datehire ATA_AGENT.DATE_OF_HIRE%TYPE;
ata_homephone ATA_AGENT.HOME_PHONE%TYPE;
ata_businessphone ATA_AGENT.BUSINESS_PHONE%TYPE);
rec_agent type_agent;
BEGIN
SELECT AGENT_ID,LAST_NAME,FIRST_NAME,DATE_OF_HIRE,HOME_PHONE,BUSINESS_PHONE
INTO rec_agent FROM ATA_AGENT
WHERE AGENT_ID =0000002;
DBMS_OUTPUT.PUT_LINE(rec_agent.ata_agentid||' '||rec_agent.ata_lastname||' '||rec_agent.ata_firstname||' '||rec_agent.ata_datehire||' '||rec_agent.ata_homephone||' '||rec_agent.ata_businessphone);
END;
/

--5
DECLARE
rec_agent ata_agent%ROWTYPE;
BEGIN
SELECT * INTO rec_agent FROM ata_agent WHERE agent_id = 0000002;
DBMS_OUTPUT.PUT_LINE(rec_agent.agent_id||' '||rec_agent.last_name||' '||rec_agent.first_name||' '||rec_agent.date_of_hire||' '||rec_agent.home_phone||' '||rec_agent.business_phone);
END;
/

DECLARE
presidentSal CONSTANT NUMBER(4):= 5000;
percent_dec CONSTANT NUMBER(2,2):=0.25;
percent_inc CONSTANT NUMBER(2,2):=0.1;
min_sal CONSTANT NUMBER(3):=100;
avg_sal NUMBER (10,2);
BEGIN
UPDATE emp SET sal=presidentSal-(percent_dec*presidentSal) WHERE sal>presidentSal;
SELECT AVG(sal) INTO avg_sal FROM emp;
UPDATE emp SET sal= sal+(sal*percent_inc) WHERE sal<avg_sal AND sal<min_sal;
END;
