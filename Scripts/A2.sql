/* INNER JOIN *//* CREAMOS LA SECUENCIA DE SALARIO */
create SEQUENCE salario_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE 
 -- 4  maxvalue 10000
 -- 5  cycle
 ;
CREATE SEQUENCE T_EMPLEADO_SQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20
  NOCYCLE;

/* de esta forma se prueban las secuencias SELECT S_PROVEEDORES.CURRVAL FROM DUAL; SELECT S_PROVEEDORES.NEXTVAL FROM DUAL;*/
SELECT salario_id_seq.nextval FROM dual;

/* EN EL SHEMA DE JORGE */
CREATE TABLE SALARIO_CAT(
         id      NUMBER(5) PRIMARY KEY,
         ESTATUS NUMBER(3) DEFAULT 1,
         salario NUMBER(15)
         );

INSERT INTO jorge.salario_cat (id,SALARIO ) values( salario_id_seq.nextval,1000);
INSERT INTO jorge.salario_cat (id,SALARIO ) values( salario_id_seq.nextval,2000);
INSERT INTO jorge.salario_cat (id,SALARIO ) values( salario_id_seq.nextval,3000);
INSERT INTO jorge.salario_cat (id,SALARIO ) values( salario_id_seq.nextval,4000);
INSERT INTO jorge.salario_cat (id ) values( salario_id_seq.nextval);

/* EN EL SHEMA DE JORGE */
CREATE TABLE EMPLEADO(
         empleado_id      NUMBER(5) PRIMARY KEY,
         nombre      VARCHAR2(15) NOT NULL,
         FECHA_ALTA  DATE DEFAULT (sysdate), 
         ESTATUS NUMBER(3) DEFAULT 1,
         salario_id  NUMBER(3) NOT NULL
                     CONSTRAINT salario_fkey REFERENCES jorge.salario_cat(id)  ON DELETE CASCADE
         );

/* CREAMOS LA SECUENCIA DE EMPLEADO */
CREATE SEQUENCE empleado_id_seq
 START WITH     1
 INCREMENT BY   1
 NOCYCLE 
 -- 4  maxvalue 10000
 -- 5  cycle
 ;

INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'Jorge','1');
INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'Lucia','2');
INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'Karen','3');
INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'David','3');
INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'Juan','5');
/**para el trigger*/
INSERT INTO jorge.EMPLEADO (empleado_id,nombre,salario_id ) values( empleado_id_seq.nextval,'okok','666');

SELECT * FROM jorge.empleado em INNER JOIN jorge.salario_cat s on s.id = em.salario_id;

SELECT * FROM jorge.empleado em LEFT JOIN jorge.salario_cat s on s.id = em.salario_id;

SELECT * FROM jorge.empleado em RIGHT  JOIN jorge.salario_cat s on s.id = em.salario_id;

SELECT * FROM jorge.empleado em FULL OUTER JOIN jorge.salario_cat s on s.id = em.salario_id;

SELECT * FROM jorge.empleado em LEFT JOIN jorge.salario_cat s on s.id = em.salario_id WHERE s.id IS NULL;

SELECT * FROM jorge.empleado em RIGHT  JOIN jorge.salario_cat s on s.id = em.salario_id WHERE em.salario_id IS NULL;

SELECT em.nombre, 
       CASE WHEN em.estatus = 1 THEN 'Activo' ELSE 'Inactivo' END AS "ESTATUS",
       CASE WHEN sal.salario > 3000 THEN 'Bien pagado'
                   WHEN sal.salario <= 3000 THEN 'Mal pagado'
                   --Sin pago aparecera NULL
                   ELSE 'Sin pago' 
                   END AS "Salario"
FROM   jorge.empleado em inner join jorge.salario_cat sal on  sal.id = em.salario_id;

--SI QUISIERAMOS discriminar un valor y sustituirlo en los demas registros
SELECT em.nombre, 
       NULLIF (2000 , SAL.SALARIO) AS "NULO"
FROM   jorge.empleado em |inner join jorge.salario_cat sal on  sal.id = em.salario_id;

--Si quisieramos testear casos en los que los rigistros tengan null
SELECT em.nombre, 
       --NVL(SAL.SALARIO, 8000) AS "NULO"
       NVL2(SAL.SALARIO, 8000 , 1000 ) AS "NULO"
FROM   jorge.empleado em inner join jorge.salario_cat sal on  sal.id = em.salario_id;



/*Diferencias entre stored procedure*/



/* FUNCTION */
CREATE FUNCTION getNombree(id IN NUMBER) 
   RETURN VARCHAR2 
   IS variable_retorno VARCHAR2(40);
   BEGIN 
      SELECT em.nombre 
      INTO variable_retorno 
      FROM jorge.empleado EM
      WHERE EM.empleado_id = id; 
      RETURN(variable_retorno); 
  END;

/*select value jaja*/
SELECT getNombree(3) FROM dual;

/*stored procedute*/
CREATE OR REPLACE PROCEDURE borrarEmpleados(id in NUMBER) AS

   BEGIN
      DELETE FROM jorge.empleado
      WHERE jorge.empleado.empleado_id = id;
   END;

   /*Manda a llamar stored prcedure*/
EXEC JORGE.borrarEmpleados(5);

--Las funciones son hechas para computar una tarea o un valor
--los stored sirven para implementar funciones de datos

--Los procedimientos almacenados son más rapidos debido a que solo se compilan otra ves
--Las funciones son mas lentas debido a que se tienen que recompilar cada que son nombradas

--No puede arrancar triggers
--Puede arrancar triggers

--No puede usar transacciones
--puede usar transacciones

--Las funciones tienen de entrada y de salid 1 sólo tipo de dato 
--Los procedimientos almacenados pueden recibir y devolver multiples objetos como salida

--las funciones necesitan tener un valor de retorno 
--los stored no lo necesitan

--NO UEDEN MANEJAR EXCEPCIONES
--Pueden usar los stored TRY CATCH

/*POR QUE*/
--Por que las funciones pueden ser llamadas en las lineas de querys
-- necesitan ser ejecutados

--Funcion no puede llamar a un stored
--Puede llamar a una funcion
