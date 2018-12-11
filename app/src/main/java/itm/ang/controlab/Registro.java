package itm.ang.controlab;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

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

    int anioG,mesG,diaG;
    String fecha="";
    Long date;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        spprofe = (Spinner) findViewById(R.id.spprofe);
        spmate = (Spinner) findViewById(R.id.spmate);
        bRegistro = (Button)findViewById(R.id.bRegistro);
        CV=(CalendarView)findViewById(R.id.CV);
        etNom=(EditText)findViewById(R.id.etNom);
        etA=(EditText)findViewById(R.id.etA);

        final String profesor="Profesor",materia="Materia";

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_Laboratorios",null,1);
        date=CV.getDate();

        consultarListaProfesores();
        consultarListaMaterias();

        ArrayAdapter<CharSequence> profAdap=new ArrayAdapter(this,android.R.layout.simple_spinner_item,profesores);
        spprofe.setAdapter(profAdap);

        ArrayAdapter<CharSequence> matAdap=new ArrayAdapter(this,android.R.layout.simple_spinner_item,materias);
        spmate.setAdapter(matAdap);

        CV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int anio, int mes, int dia) {
                if (CV.getDate() != date) {
                    date = CV.getDate();
                    anioG=anio;
                    mesG=mes;
                    diaG=dia;
                    fecha=""+anioG+"-"+mesG+"-"+diaG;
                    //Toast.makeText(calendarView.getContext(), "Año=" + anioG + " Mes=" + mesG + " dia=" + diaG, Toast.LENGTH_LONG).show();
                }
            }
        });
       bRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(profesor.equals(spprofe.getSelectedItem().toString())||materia.equals(spmate.getSelectedItem().toString())
                        ||etNom.getText().toString().isEmpty()||etA.getText().toString().isEmpty()||fecha.equals("")){
                    Toast.makeText(getApplicationContext(),"No se pudo registrar algunos datos pueden no estar completos\nNOTA: Asegurese de darle click al calendario y mover spinners",Toast.LENGTH_SHORT).show();
                }else{
                    registrarPractica();
                    spprofe.setSelection(0);
                    spmate.setSelection(0);
                    etNom.setText("");
                    etA.setText("");
                    Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_SHORT).show();
                }
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
        materias.add("Materia");

        for (int i=0;i<listaMateria.size();i++){
            materias.add(listaMateria.get(i).getNombre());
        }
    }

    private void registrarPractica() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_PROFESOR,spprofe.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NOMBRE_MATERIA,spmate.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_NOMBRE_PRACTICA,etNom.getText().toString());
        values.put(Utilidades.CAMPO_CANTIDAD_ALUMNOS,etA.getText().toString());
        values.put(Utilidades.CAMPO_FECHA,fecha);
        Long idResultante=db.insert(Utilidades.TABLA_PRACTICA,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Registro Practica "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
