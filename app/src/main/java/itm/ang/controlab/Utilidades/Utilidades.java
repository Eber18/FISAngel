package itm.ang.controlab.Utilidades;

public class Utilidades {

    //constantes de tabla de materias
    /*public static final String TABLA_MATERIA="BaseMaterias";
    public static final String NOMBRE_MATERIA="nombre";
    public static final String crear_tabla_materia="CREATE TABLE "+TABLA_MATERIA+" ("+NOMBRE_MATERIA+" TEXT)";
    */
    //Constantes tabla Materia
    public static final String TABLA_MATERIA="Materia";
    public static final String TABLA_PROFESOR="Profesor";
    public static final String CAMPO_NOMBRE_MATERIA="NombreM";
    public static final String CAMPO_NOMBRE_PROFESOR="NombreP";

    public static final String CREAR_TABLA_MATERIA="CREATE TABLE "+TABLA_MATERIA+"("+CAMPO_NOMBRE_MATERIA+" VARCHAR(30))";
    public static final String CREAR_TABLA_PROFESOR="CREATE TABLE "+TABLA_PROFESOR+"("+CAMPO_NOMBRE_PROFESOR+" VARCHAR(30))";
}
