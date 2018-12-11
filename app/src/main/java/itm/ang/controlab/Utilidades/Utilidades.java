package itm.ang.controlab.Utilidades;

public class Utilidades {

    public static final String TABLA_MATERIA="Materia";
    public static final String TABLA_PROFESOR="Profesor";
    public static final String TABLA_PRACTICA="Practica";
    public static final String TABLA_MANTENIMIENTO="Mantenimiento";
    public static final String TABLA_INVENTARIO="Inventario";
    public static final String TABLA_USUARIOS="Usuarios";
    public static final String CAMPO_ID="ID";
    public static final String CAMPO_NOMBRE_MATERIA="NombreM";
    public static final String CAMPO_NOMBRE_PROFESOR="NombreP";
    public static final String CAMPO_NOMBRE_PRACTICA="NombrePractica";
    public static final String CAMPO_CANTIDAD_ALUMNOS="Alumnos";
    public static final String CAMPO_FECHA="Fecha";
    public static final String CAMPO_EQUIPO="NumSerieCPU";
    public static final String CAMPO_DETALLES="Arreglos";
    public static final String CAMPO_USUARIO="Usuario";
    public static final String CAMPO_CONTRASEÑA="Contraseña";
    public static final String CAMPO_TECLADO="Teclado";
    public static final String CAMPO_RATON="Raton";
    public static final String CAMPO_REGULADOR="Regulador";
    public static final String CAMPO_OBSERVACIONES="Observaciones";

    public static final String CREAR_TABLA_MATERIA="CREATE TABLE "+TABLA_MATERIA+"("+CAMPO_NOMBRE_MATERIA+" VARCHAR(30))";
    public static final String CREAR_TABLA_PROFESOR="CREATE TABLE "+TABLA_PROFESOR+"("+CAMPO_NOMBRE_PROFESOR+" VARCHAR(30))";
    public static final String CREAR_TABLA_PRACTICA="CREATE TABLE "+TABLA_PRACTICA+"("+CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_PROFESOR+" VARCHAR(30), "+CAMPO_NOMBRE_MATERIA+" VARCHAR(30), "+CAMPO_NOMBRE_PRACTICA+" VARCHAR(50), "
            +CAMPO_CANTIDAD_ALUMNOS+" INTEGER, "+CAMPO_FECHA+" TIMESTAMP)";
    public static final String CREAR_TABLA_MANTENIMIENTO="CREATE TABLE "+TABLA_MANTENIMIENTO+"("+CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_EQUIPO+" VARCHAR(20), "+CAMPO_DETALLES+" TEXT, "+CAMPO_FECHA+" TIMESTAMP)";
    public static final String CREAR_TABLA_INVENTARIO="CREATE TABLE "+TABLA_INVENTARIO+"("+CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_EQUIPO+" VARCHAR(20),"+CAMPO_TECLADO+" VARCHAR(20))";
    public static final String CREAR_TABLA_USUARIOS="CREATE TABLE "+TABLA_USUARIOS
            +"("+CAMPO_USUARIO+" VARCHAR(20), "+CAMPO_CONTRASEÑA+" TEXT)";
}
