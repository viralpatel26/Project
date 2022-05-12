-- ALTER TABLE ata_entertainer ADD more_than_one NUMBER;
/*
DECLARE
  CURSOR entertainer_curs IS
    SELECT
      *
    FROM
      ata_entertainer;

  lv_number_of_styles NUMBER;
  
BEGIN
  FOR rec_entertainer IN entertainer_curs LOOP
    SELECT
      COUNT(*)
    INTO lv_number_of_styles
    FROM
      ata_entertainers_style
    WHERE
      entertainer_id = rec_entertainer.entertainer_id;

    CASE
      WHEN lv_number_of_styles <= 1 THEN
        lv_number_of_styles := NULL;
      ELSE
        NULL;
    END CASE;
    
    UPDATE ata_entertainer
    SET
      more_than_one = lv_number_of_styles
    WHERE
      entertainer_id = rec_entertainer.entertainer_id;

  END LOOP;

  COMMIT;
END;
/*/

DECLARE
CURSOR emp_cur IS SELECT * FROM emp FOR UPDATE;
lv_avg_sal NUMBER(7,2);
lv_percent_dec1 CONSTANT NUMBER(2,2):=0.50;
lv_percent_dec2 CONSTANT NUMBER(2,2):=0.75;
lv_percent_inc CONSTANT NUMBER (2,2):=0.10;
lv_comm_percent CONSTANT NUMBER (2,2):= 0.22; 
lv_salary CONSTANT NUMBER(5):=100;
lv_president_sal NUMBER(7,2);
lv_min_comm NUMBER(7,2);
BEGIN 
SELECT AVG(sal) INTO lv_avg_sal FROM emp;
SELECT SAL INTO lv_president_sal FROM emp where Job = 'PRESIDENT';
SELECT MIN(comm) INTO lv_min_comm FROM emp where comm>0;
FOR rec_emp IN emp_cur LOOP 

IF rec_emp.sal>lv_president_sal THEN 
	IF (rec_emp.sal*lv_percent_dec1)>((lv_president_sal)-(lv_president_sal*lv_percent_dec2)) THEN
		rec_emp.sal := ((lv_president_sal)-(lv_president_sal*lv_percent_dec2));
	ELSE rec_emp.sal := (rec_emp.sal*lv_percent_dec1);
	END IF;
END IF;
	IF rec_emp.sal<lv_salary THEN
		IF lv_avg_sal>(rec_emp.sal+(rec_emp.sal*lv_percent_inc)) THEN
			rec_emp.sal := rec_emp.sal+(rec_emp.sal*lv_percent_inc);
		END IF;
	END IF;
	IF rec_emp.comm>(lv_comm_percent*rec_emp.sal) THEN
			rec_emp.comm :=lv_min_comm;
	END IF;		
			
	UPDATE emp
    SET
      sal = rec_emp.sal,
	  comm= rec_emp.comm
    WHERE CURRENT OF emp_cur;
	END LOOP;
	END;


