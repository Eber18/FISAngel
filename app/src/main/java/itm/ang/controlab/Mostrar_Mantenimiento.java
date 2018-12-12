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

        consultarListaMantenimientos();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionMantenimiento);
        listViewMantenimiento.setAdapter(adaptador);
    }

    private void consultarListaMantenimientos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Mantenimiento mantenimiento=null;
        listaMantenimiento=new ArrayList<Mantenimiento>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_MANTENIMIENTO,null);
        while (cursor.moveToNext()){
            mantenimiento=new Mantenimiento();
            mantenimiento.setID(cursor.getInt(0));
            mantenimiento.setEquipo(cursor.getString(1));
            mantenimiento.setDetalles(cursor.getString(2));
            mantenimiento.setFecha(cursor.getString(3));
            listaMantenimiento.add(mantenimiento);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacionMantenimiento=new ArrayList<String>();
        listaInformacionMantenimiento.add("Mantenimientos");

        for(int i=0;i<listaMantenimiento.size();i++){
            listaInformacionMantenimiento.add("ID de Mantenimiento: "+listaMantenimiento.get(i).getID()+"\nAl equipo: "
                    +listaMantenimiento.get(i).getEquipo()+"\nSe le realizó: "+listaMantenimiento.get(i).getDetalles()
                    +"\nEn la fecha: "+listaMantenimiento.get(i).getFecha());
        }
    }
}
