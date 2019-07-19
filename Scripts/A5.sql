1--Creación de las tablas a utilizar.
CREATE SEQUENCE STAR_WARS
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE PERSONAJES(
         PERSONAJES_STARWARS NUMBER(30) PRIMARY KEY,
         NOMBRE VARCHAR(30)
         );

2--Creación del módulo.
-- realizar la prueba de
-- T0 no guarda nada.
-- T1 = SI HAY REGISTROS
-- T2 = SI HAY REGISTROS
-- T3 = NO
-- T3 = SI HAY REGISTROS
-- T4 = NO 

-- alter system checkpoint
create or replace procedure insertar is
   i int  := 0 ;
begin
   for i in 1..1000
      loop
         insert into PERSONAJES values(JORGE.STAR_WARS.nextval, 'R2D2');
         if(i = 4) THEN
            dbms_output.put_line('ES 4');
         end if;
      end loop;
      commit;
END;
/

create or replace procedure borrar is
begin
         delete from PERSONAJES;
         --commit
END;
/

--StartDB.bat
--Taskmgr

--Use rollback
--Save point
--Roll back to an save point
--commit
--deadlock

--Explicación de ROLLBACK; 
rollback;
Una vez que se inicie
A0 por convención ---> guarda primeros mil

-- alter system checkpoint
create or replace procedure PRUEBA_TRES is
   i int  := 0 ;
begin
   INSERTAR;
      SAVEPOINT PRIMEROS_MIL;
   INSERTAR;
      SAVEPOINT PRIMEROS_DOSMIL;
   INSERTAR;
      SAVEPOINT PRIMEROS_TRESMIL;
END;
/


CREATE TABLE DRAGONBALL(
         DRAGONBALL_ID NUMBER(30) PRIMARY KEY,
         NOMBRE VARCHAR(30)
         );

--Abrir dos consolas
rollback to SAVEPOINT PRIMEROS_TRESMIL;