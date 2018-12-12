package itm.ang.controlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Practica;

public class Mostrar_Practica extends AppCompatActivity {

    ListView listViewPractica;
    ArrayList<String> listaInformacionPractica;
    ArrayList<Practica>listaPractica;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar__practica);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_Laboratorios",null,1);

        listViewPractica=(ListView)findViewById(R.id.listviewPractica);

        consultarListaPracticas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionPractica);
        listViewPractica.setAdapter(adaptador);
    }

    private void consultarListaPracticas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Practica practica=null;
        listaPractica=new ArrayList<Practica>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PRACTICA,null);
        while (cursor.moveToNext()){
            practica=new Practica();
            practica.setID(cursor.getInt(0));
            practica.setProfesor(cursor.getString(1));
            practica.setMateria(cursor.getString(2));
            practica.setPractica(cursor.getString(3));
            practica.setAlumnos(cursor.getInt(4));
            practica.setFecha(cursor.getString(5));

            listaPractica.add(practica);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacionPractica=new ArrayList<String>();
        listaInformacionPractica.add("Practicas");

        for(int i=0;i<listaPractica.size();i++){
            listaInformacionPractica.add("ID de Practica: "+listaPractica.get(i).getID()+"\nProfesor: "+listaPractica.get(i).getProfesor()
                    +"\nMateria: "+listaPractica.get(i).getMateria()+"\nNombre de la Practica: "+listaPractica.get(i).getPractica()
                    +"\nCantidad de Alumnos: " +listaPractica.get(i).getAlumnos()+"\nFecha: "+listaPractica.get(i).getFecha());
        }
    }
}
