/*Arreglos y no tablas*/
CREATE OR REPLACE TYPE ARREGLO_EMPLEADOS IS VARRAY(10) of trabajador

DECLARE
  /*Se declaran localmente las variables que se utlizaran*/
   type arreglo_nombres IS VARRAY(5) OF VARCHAR2(10);
   type id_nombres IS VARRAY(5) OF INTEGER;
   /*Se crea una variable del tipo de datos de array*/
   nombres arreglo_nombres;
   idis id_nombres;
   /*Cuándo no se le especifica el valor no está limitado*/
   total integer;
BEGIN
   nombres := arreglo_nombres('Juan', 'José', 'Lucía', 'Laura', 'Nancy');
   idis:= id_nombres(22, 23, 24, 25, 26);
   /*De la misma forma en la que los arreglos se contaron*/
   total := nombres.count;
   dbms_output.put_line('Total '|| total || ' Students');
   /*Puedo recorrer para ambas funciones el cíclo for*/
   FOR i in 1 .. total LOOP
      dbms_output.put_line('Estudiante: ' || nombres(i) || '
      Idis: ' || idis(i));
   END LOOP;
END;
/

/*Uso del cursor*/
DECLARE
   /*Curso es un conjunto de valores que devuelve una lista en Oracle*/
   CURSOR e_empleados is
   SELECT nombre FROM empleado;
   /*Cambiar al numero que tengamos por default*/
   type var_list is varray (6) of empleado.nombre%type;
   lista_nombres var_list := var_list();
   /*Una variable contadora comun y corriente*/
   contador integer :=0;
BEGIN
  /* Este loop si permite correr más de dos sentencias*/
  /* N toma el valor del cursos e_empleados */
   FOR n IN e_empleados LOOP
      contador := contador + 1;
      /*inicializa un nuevo nodo en el arreglo*/
      lista_nombres.extend;
      /*Le asigna el valor en tempo de ejecucion*/
      lista_nombres(contador)  := n.nombre;/*n recibiendo como tabla el valor de nombre*/
      dbms_output.put_line('Empleado('||contador ||'):'||lista_nombres(contador));
   END LOOP;
END;
/


-- Or, iterate through it to print each instance


List<Student> miLista = new ArrayList();


for(Student objetoAnalisis: miLista) {
    System.out.println(objetoAnalisis.toString());  // Will invoke overrided `toString()` method
}


/**************************Creación de vista*********************************/
/* Crear una vista de únicamente los usuarios 
con salario alto */

SELECT em.empleado_id, em.nombre,sa.salario
FROM empleado em INNER JOIN salario_cat sa ON
em.salario_id = sa.id
WHERE sa.salario >= 2000

CREATE VIEW salarios_altos AS (
  SELECT em.empleado_id, em.nombre,sa.salario
  FROM empleado em INNER JOIN salario_cat sa ON
  em.salario_id = sa.id
  WHERE sa.salario >= 2000
)

drop view salarios_altos;

/*************** PL/SQL (Procedural Language/Structured Query Language) 
es un lenguaje de programación incrustado en Oracle.*********/
/*
PL/SQL soportará todas las consultas, ya que la manipulación de datos que se usa es la misma que en SQL, incluyendo nuevas características:

-El manejo de variables.
-Estructuras modulares.
-Estructuras de control de flujo y toma de decisiones.
-Control de excepciones.
*/
/*SINTAXIS DE UN PL/SQL*/
[ DECLARE | IS / AS ]
	<declaraciones>
BEGIN
	<instrucciones>
[ EXCEPTION ]
	<tratamiento de excepciones>
END;

/*que es un plsql*/
https://es.wikipedia.org/wiki/PL/SQL
/*Manejo de exepciones :o */
https://docs.oracle.com/cd/B13789_01/appdev.101/b10807/07_errs.htm

/*EJEMPLO DEL PL/SQL de las excepciones*/
DECLARE 
  CURSOR e_empleados IS SELECT nombre FROM empleado;
  a integer := 10;
   b integer := 30;
BEGIN
   /*Ejecuta una línea de instruccion vacia*/
   NULL;
   /*error de dividido entre 0*/
   a := a / b;
   /*Excepcion de campo dpuplicada*/
   INSERT INTO empleado(empleado_id,nombre,salario_id) VALUES(1,'nuevo','1');
EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN  -- catches all 'no data found' errors
   dbms_output.put_line('Valor duplicado');
   WHEN ZERO_DIVIDE THEN  -- catches all 'no data found' errors
   dbms_output.put_line('Error de division entre 0 ');
   WHEN PROGRAM_ERROR THEN  -- catches all 'no data found' errors
   dbms_output.put_line('Error acceso a nul ');
END;
/


/*Listado de las funciones de ORACLE*/

https://docs.oracle.com/cd/B28359_01/server.111/b28286/functions001.htm
/*Funciones*/
/* Sumatoria de salarios */
SELECT sum(salario) FROM salario_cat ca WHERE ca.salario IS NOT NULL
/* Conteo de salarios */
SELECT count(salario) FROM salario_cat ca WHERE ca.salario IS NOT NULL
/* miNIMMO VALOR DE SALARIOS */
SELECT MIN(salario) FROM salario_cat ca WHERE ca.salario IS NOT NULL
/*el siguiente MARTES DE LA FECHA ACORDADA*/
SELECT next_day(em.fecha_alta,'TUESDAY') FROM empleado em