package itm.ang.controlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Mantenimiento;
import itm.ang.controlab.entidades.Practica;

public class Mostrar_Mantenimiento extends AppCompatActivity {

    ListView listViewMantenimiento;
    ArrayList<String> listaInformacionMantenimiento;
    ArrayList<Mantenimiento>listaMantenimiento;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar__mantenimiento);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_Laboratorios",null,1);

        listViewMantenimiento=(ListView)findViewById(R.id.listviewMantenimiento);

        consultarListaPracticas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionMantenimiento);
        listViewMantenimiento.setAdapter(adaptador);
    }

    private void consultarListaPracticas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Mantenimiento mantenimiento=null;
        listaMantenimiento=new ArrayList<Mantenimiento>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_MANTENIMIENTO,null);
        while (cursor.moveToNext()){
            mantenimiento=new Mantenimiento();
            mantenimiento.setEquipo(cursor.getString(0));
            mantenimiento.setDetalles(cursor.getString(1));
            mantenimiento.setFecha(cursor.getString(2));
            listaMantenimiento.add(mantenimiento);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacionMantenimiento=new ArrayList<String>();
        //listaInformacion.add("ID-Equipo-Detalles-Fecha");

        for(int i=0;i<listaInformacionMantenimiento.size();i++){
            listaInformacionMantenimiento.add(listaMantenimiento.get(i).getEquipo()+" - "+listaMantenimiento.get(i).getDetalles()+" - "
                    +listaMantenimiento.get(i).getFecha());
        }
    }
}
