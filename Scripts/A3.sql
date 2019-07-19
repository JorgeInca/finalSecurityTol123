set serveroutput on size 30000;

/*Este es un trigger de prueba que es al insertar*/
CREATE OR REPLACE TRIGGER prueba_trigger
BEFORE INSERT ON jorge.empleado
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.put_line('Prueba de que se iniciar trigger al insertar');
END;

INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'Juan','5');



/*************************************MFUNCTION mostrar en pantalla*********************/
CREATE or replace PROCEDURE IMPRIME(id IN VARCHAR2) 
   RETURN VARCHAR2 
   IS variable_retorno VARCHAR2(40);
   BEGIN 
      DBMS_OUTPUT.put_line(id);
      RETURN (variable_retorno);
   END;

/*DESPUES*/
CREATE or replace FUNCTION IMPRIME(id IN VARCHAR2) 
   RETURN VARCHAR2 
   IS variable_retorno VARCHAR2(40);
   BEGIN       
      DBMS_OUTPUT.put_line(id);
      DBMS_OUTPUT.put_line('');     
      DBMS_OUTPUT.put_line('');   
      DBMS_OUTPUT.put_line('Fin **');
      DBMS_OUTPUT.put_line('');
      RETURN (variable_retorno);
   END;


/*************************************alteracion de columnas*********************/

/*Agregar un campo*/
ALTER TABLE jorge.salario
ADD descripcion varchar2(40)

/*CAMBIAR UN TIPO DE DATO Y NOMBRE*/
alter table 
   JORGE.SALARIO_CAT
modify 
( 
   DESCRIPCION  NUMBER(5)
);

/*Eliminar un campo*/
ALTER TABLE jorge.salario
DROP descripcion varchar2(40)

/*CREATE TABLE RELACION*/
CREATE TABLE RELACION(
         empleado_id      NUMBER(5) PRIMARY KEY,
         detalle      VARCHAR2(40) 
         );



/*Este query deja en tabla relación salarios AL SALARIO QUE SE OCUPE PARA ALGUN EMPLEADO*/
CREATE OR REPLACE TRIGGER ACCION
  AFTER
    INSERT OR
    --solo nombres de columna
    UPDATE OF id, salario OR
    DELETE
  ON jorge.salario_cat
BEGIN
  CASE
    WHEN INSERTING THEN
    -- NO EXEC POR QUE VIENE INTERNO
      IMPRIME_PROCEDURE('Insertando');
    WHEN UPDATING(3) THEN
      IMPRIME_PROCEDURE('ACTUALIZANDO ID');
    WHEN UPDATING(1000) THEN
      IMPRIME_PROCEDURE('ACTUALIZANDO SALARIO');
    WHEN DELETING THEN
      IMPRIME_PROCEDURE('Borrando');
  END CASE;
END;

/*Procedimiento almacenado para la vista en pantalla*/
CREATE OR REPLACE PROCEDURE JORGE.IMPRIME_PROCEDURE(id IN VARCHAR2) AS

   BEGIN
     DBMS_OUTPUT.put_line(id);
   END;
/



INSERT INTO pruebas.salario_cat (id,SALARIO ) values( salario_id_seq.nextval,6000);
delete from pruebas.salario_cat sc where sc.id = 6 
update pruebas.salario_cat set salario = 2200 where sc.id = 2;
update pruebas.salario_cat sc set id = 666 where sc.salario = 2200 ;

/****************************Lo correspondiente a las tablas*/
CREATE OR REPLACE TYPE trabajador as object(
   id NUMBER(4),
   nombre varchar2(20),
   telefono varchar2(20)
);

CREATE OR REPLACE TYPE lista_trabajadores is table of trabajador;
CREATE OR REPLACE TYPE ARREGLO_EMPLEADOS IS VARRAY(10) of trabajador

CREATE OR REPLACE PROCEDURE insert_mydata(lista_parametro lista_trabajadores)
AS
BEGIN
  forall i in 1..lista_parametro.count    
      INSERT INTO jorge.trabajadores(id,nombre,telefono ) VALUES(lista_parametro(i).id,lista_parametro(i).nombre,lista_parametro(i).telefono );k

END;


DECLARE 
  TYPE lista_trabajadores is table of trabajador;

    l_data lista_trabajadores := lista_trabajadores( 
                  trabajador( 1, 'juan', '4567' ),
                  trabajador( 2, 'pepe', '9876' ) );
BEGIN
  insert_mydata(l_data);
END;

/****************************Lo correspondiente a los arreglos*/

select M_TRANSPONDER1_NSERIE,M_TRANSPONDER2_NSERIE,M_TRANSPONDER2_NSERIE 
from M_CAT_GABINETE where M_NUM_GABINETE = '2586';
select * from M_MED_POSTE;
select * from M_METER_INSTALL_RECORD;
select * from M_MEDIDOR;