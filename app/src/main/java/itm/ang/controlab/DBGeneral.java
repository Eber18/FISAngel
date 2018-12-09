package itm.ang.controlab;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class DBGeneral extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;

    public static final String DATABASE_NAME= "Accerder.db";

    private static final String SQL_CREATE_ENTIRES= "CREATE TABLE " + EsquemaDB.Esquema2.TABLE_ACCEDER+" ("+
            EsquemaDB.Esquema2.COLUMN_NOMBRE_ACCEDER + " TEXT PRIMARY KEY," + EsquemaDB.Esquema2.COLUMN_PASSWORD_ACCEDER + " TEXT)";

    private static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS " + EsquemaDB.Esquema2.TABLE_ACCEDER;

    public DBGeneral(Context context){super (context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTIRES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
