package itm.ang.controlab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import itm.ang.controlab.Utilidades.Utilidades;

public class ConexionSQLiteHelper  extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_MATERIA);
        db.execSQL(Utilidades.CREAR_TABLA_PROFESOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Materia");
        db.execSQL("DROP TABLE IF EXISTS Profesor");
        onCreate(db);
    }
}
