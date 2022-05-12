DECLARE
CURSOR emp_cur IS SELECT * FROM emp FOR UPDATE;
lv_avg_sal NUMBER(7,2);
lv_percent_dec1 CONSTANT NUMBER(2,2):=0.50;
lv_percent_dec2 CONSTANT NUMBER(2,2):=0.75;
lv_percent_inc CONSTANT NUMBER (2,2):=0.10;
lv_comm_percent CONSTANT NUMBER (2,2):= 0.22; 
lv_salary CONSTANT NUMBER(5):=100;
lv_president_sal NUMBER(7,2);
lv_president VARCHAR2(10):='PRESIDENT';
lv_manager VARCHAR2(10):='MANAGER';
lv_min_comm NUMBER(7,2);
BEGIN 
SELECT AVG(sal) INTO lv_avg_sal FROM emp;
SELECT SAL INTO lv_president_sal FROM emp where Job = lv_president;
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