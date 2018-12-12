package itm.ang.controlab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import itm.ang.controlab.Utilidades.Utilidades;

public class ConexionSQLiteHelper  extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_MATERIA);
        db.execSQL(Utilidades.CREAR_TABLA_PROFESOR);
        db.execSQL(Utilidades.CREAR_TABLA_PRACTICA);
        db.execSQL(Utilidades.CREAR_TABLA_MANTENIMIENTO);
        //db.execSQL(Utilidades.CREAR_TABLA_INVENTARIO);
        db.execSQL(Utilidades.CREAR_TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MATERIA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PROFESOR);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRACTICA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MANTENIMIENTO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_INVENTARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIOS);
        onCreate(db);
    }
}
