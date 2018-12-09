package itm.ang.controlab;
import android.provider.BaseColumns;

public final class EsquemaDB {
    private EsquemaDB(){}
    public static class Esquema implements BaseColumns{

    public static final String TABLE_USUARIO = "usuario";
    public static final String COLUMN_ID_USUARIO = "id_usuario";
    public static final String COLUMN_NOMBRE_USUARIO = "nombre";
    public static final String COLUMN_PASSWORD_USUARIO = "password";
    }
    public static class Esquema2 implements BaseColumns{//accesar

        public static final String TABLE_ACCEDER = "acceder";
        public static final String COLUMN_NOMBRE_ACCEDER = "nombre";
        public static final String COLUMN_PASSWORD_ACCEDER = "password";
    }
}
