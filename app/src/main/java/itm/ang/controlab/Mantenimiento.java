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
import itm.ang.controlab.entidades.Inventario;

public class Mantenimiento extends AppCompatActivity {

    Spinner esEquipo;
    EditText etman;
    CalendarView CV2;
    Button bAlta;

    ArrayList<String> equipos;
    ArrayList<Inventario> listaEquipos;

    int anioG,mesG,diaG;
    String fecha="";
    Long date;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);

        esEquipo=(Spinner)findViewById(R.id.esEquipo);
        etman=(EditText)findViewById(R.id.etman);
        CV2=(CalendarView)findViewById(R.id.CV2);
        bAlta=(Button)findViewById(R.id.bAlta);

        final String equipo="Equipo";

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);
        date=CV2.getDate();

        consultarListaEquipos();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,equipos);
        esEquipo.setAdapter(adaptador);

        CV2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int anio, int mes, int dia) {
                if (CV2.getDate() != date) {
                    date = CV2.getDate();
                    anioG=anio;
                    mesG=mes;
                    diaG=dia;
                    fecha=""+anioG+"/"+mesG+"/"+diaG;
                    //Toast.makeText(calendarView.getContext(), "Año=" + anioG + " Mes=" + mesG + " dia=" + diaG, Toast.LENGTH_LONG).show();
                }
            }
        });

        bAlta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(equipo.equals(esEquipo.getSelectedItem().toString())||etman.getText().toString().isEmpty()||fecha.equals("")){
                    Toast.makeText(getApplicationContext(),"No se pudo registrar algunos datos pueden no estar completos\nNOTA: Asegurese de darle click al calendario y mover spinners",Toast.LENGTH_SHORT).show();
                }else{
                    registrarMantenimiento();
                    esEquipo.setSelection(0);
                    etman.setText("");
                    Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void consultarListaEquipos() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Inventario inventario=null;
        listaEquipos=new ArrayList<Inventario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_INVENTARIO,null);

        while (cursor.moveToNext()){
            inventario=new Inventario();
            inventario.setSerieCPU(cursor.getString(1));

            listaEquipos.add(inventario);
        }

        obtenerListaComputadoras();
    }

    private void obtenerListaComputadoras() {
        equipos=new ArrayList<String>();
        equipos.add("Equipo");

        for (int i=0;i<listaEquipos.size();i++){
            equipos.add(listaEquipos.get(i).getSerieCPU());
        }
    }

    private void registrarMantenimiento(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Utilidades.CAMPO_EQUIPO,esEquipo.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_DETALLES,etman.getText().toString());
        values.put(Utilidades.CAMPO_FECHA,fecha);
        Long idResultante=db.insert(Utilidades.TABLA_MANTENIMIENTO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Mantenimiento exitoso: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
