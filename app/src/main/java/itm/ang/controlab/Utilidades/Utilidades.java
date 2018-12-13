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
    public static final String CAMPO_MONITOR="Monitor";
    public static final String CAMPO_RAM="RAM";
    public static final String CAMPO_DD="DD";
    public static final String CAMPO_PROCESADOR="Procesador";

    public static final String CAMPO_DEV="DEVC";
    public static final String CAMPO_NET="Netbeans";
    public static final String CAMPO_ECLIP="Eclipse";
    public static final String CAMPO_NOTE="NotepadPlus";
    public static final String CAMPO_gED="gEdit";
    public static final String CAMPO_DIA="Dia";
    public static final String CAMPO_POST="PostgreSQL";
    public static final String CAMPO_CISCO="PacketTracer";
    public static final String CAMPO_VIRTUAL="VirtualBox";
    public static final String CAMPO_UNITY="Unity";
    public static final String CAMPO_VS="VisualStudio";
    public static final String CAMPO_INTERNET="Internet";
    public static final String CAMPO_SALON="Salon";
    public static final String CAMPO_OBSERVACIONES="Observaciones";

    public static final String CREAR_TABLA_MATERIA="CREATE TABLE "+TABLA_MATERIA+"("+CAMPO_NOMBRE_MATERIA+" VARCHAR(50))";

    public static final String CREAR_TABLA_PROFESOR="CREATE TABLE "+TABLA_PROFESOR+"("+CAMPO_NOMBRE_PROFESOR+" VARCHAR(50))";

    public static final String CREAR_TABLA_PRACTICA="CREATE TABLE "+TABLA_PRACTICA+"(" +CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_PROFESOR+" VARCHAR(50), "+CAMPO_NOMBRE_MATERIA+" VARCHAR(50), "+CAMPO_NOMBRE_PRACTICA+" VARCHAR(70), "
            +CAMPO_CANTIDAD_ALUMNOS+" INTEGER, "+CAMPO_FECHA+" TIMESTAMP)";

    public static final String CREAR_TABLA_MANTENIMIENTO="CREATE TABLE "+TABLA_MANTENIMIENTO+"("+CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_EQUIPO+" VARCHAR(20), "+CAMPO_DETALLES+" TEXT, "+CAMPO_FECHA+" TIMESTAMP)";

    public static final String CREAR_TABLA_INVENTARIO="CREATE TABLE "+TABLA_INVENTARIO+"("+CAMPO_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_EQUIPO+" VARCHAR(20), "+CAMPO_TECLADO+" VARCHAR(20), "+CAMPO_RATON+" VARCHAR(20), "+CAMPO_MONITOR+" VARCHAR(20), "
            +CAMPO_RAM+" VARCHAR(20), "+CAMPO_DD+" VARCHAR(20), "+CAMPO_PROCESADOR+" VARCHAR(20), "+CAMPO_DEV+" VARCHAR(3), "
            +CAMPO_NET+" VARCHAR(3), "+CAMPO_ECLIP+" VARCHAR(3), "+CAMPO_NOTE+" VARCHAR(3), "+CAMPO_gED+" VARCHAR(3), "
            +CAMPO_DIA+" VARCHAR(3), " +CAMPO_POST+" VARCHAR(3), "+CAMPO_CISCO+" VARCHAR(3), "+CAMPO_VIRTUAL+" VARCHAR(3), "
            +CAMPO_UNITY+" VARCHAR(3), " +CAMPO_VS+" VARCHAR(3), "+CAMPO_INTERNET+" VARCHAR(3), "+CAMPO_SALON+" VARCHAR(5), "
            +CAMPO_OBSERVACIONES+" TEXT)";

    public static final String CREAR_TABLA_USUARIOS="CREATE TABLE "+TABLA_USUARIOS
            +"("+CAMPO_USUARIO+" VARCHAR(20), "+CAMPO_CONTRASEÑA+" TEXT)";
}
