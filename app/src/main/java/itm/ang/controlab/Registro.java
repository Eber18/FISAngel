package itm.ang.controlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import itm.ang.controlab.BasesdeDatos.BaseMaterias;
import itm.ang.controlab.BasesdeDatos.Conecxion;
import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Materia;
import itm.ang.controlab.entidades.Profesor;

public class Registro extends AppCompatActivity {
    Spinner spprofe,spmate;
    CalendarView CV;
    EditText etNom,etA ;
    Button bRegistro;
    ArrayList<String> materias,profesores;
    ArrayList<Materia> listaMateria;
    ArrayList<Profesor> listaProfesor;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        spprofe = (Spinner) findViewById(R.id.spprofe);
        spmate = (Spinner) findViewById(R.id.spmate);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_Laboratorios",null,1);

        consultarListaProfesores();
        consultarListaMaterias();

        ArrayAdapter<CharSequence> profAdap=new ArrayAdapter(this,android.R.layout.simple_spinner_item,profesores);
        spprofe.setAdapter(profAdap);

        ArrayAdapter<CharSequence> matAdap=new ArrayAdapter(this,android.R.layout.simple_spinner_item,materias);
        spmate.setAdapter(matAdap);

        bRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Profesor: "+spprofe.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarListaProfesores() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Profesor p=null;
        listaProfesor=new ArrayList<Profesor>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PROFESOR,null);

        while (cursor.moveToNext()){
            p=new Profesor();
            p.setNombre(cursor.getString(0));

            listaProfesor.add(p);
        }

        obtenerListaProfesores();
    }

    private void consultarListaMaterias() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Materia m=null;
        listaMateria=new ArrayList<Materia>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_MATERIA,null);

        while (cursor.moveToNext()){
            m=new Materia();
            m.setNombre(cursor.getString(0));

            listaMateria.add(m);
        }

        obtenerListaMaterias();
    }

    private void obtenerListaProfesores() {
        profesores=new ArrayList<String>();
        profesores.add("Profesor");

        for (int i=0;i<listaProfesor.size();i++){
            profesores.add(listaProfesor.get(i).getNombre());
        }
    }

    private void obtenerListaMaterias() {
        materias=new ArrayList<String>();
        materias.add("Materias");

        for (int i=0;i<listaMateria.size();i++){
            materias.add(listaMateria.get(i).getNombre());
        }
    }
}


/*public class Registro extends AppCompatActivity {
    Spinner spprofe,spmate;
    ArrayList<String> nmate;
    ArrayList<BaseMaterias> materiaslist;
    Conecxion conmm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        spprofe = (Spinner) findViewById(R.id.spprofe);
        spmate = (Spinner) findViewById(R.id.spmate);
        //conmm= new Conecxion(getApplicationContext(),"BaseMaterias",null, 1);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.profesores,android.R.layout.simple_spinner_item);
        spprofe.setAdapter(adapter1);
        //spinner materias;
        //consultarlistamaterias();
        ArrayAdapter<CharSequence> adapter2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,nmate);
        spmate.setAdapter(adapter2);
    }

    private void consultarlistamaterias() {
        SQLiteDatabase db= conmm.getReadableDatabase();
        BaseMaterias materia=null;
        materiaslist=new ArrayList<BaseMaterias>();
        //select from basematerias
        Cursor cursor= db.rawQuery("SELECT * FROM "+Utilidades.TABLA_MATERIA,null);
        while(cursor.moveToNext()){
            materia=new BaseMaterias();
            materia.setNombre(cursor.getString(0));
            materiaslist.add(materia);
        }
    }

    private void obtenerlista(){
        nmate=new ArrayList<String>();
        nmate.add("");
        for(int i=0;i<materiaslist.size(); i++){
            nmate.add(materiaslist.get(i).getNombre());
        }
    }


}*/
