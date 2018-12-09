package itm.ang.controlab.BasesdeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import itm.ang.controlab.Utilidades.Utilidades;

public class Conecxion extends SQLiteOpenHelper {



    public Conecxion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(Utilidades.crear_tabla_materia);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS BaseMaterias");

    }
}
