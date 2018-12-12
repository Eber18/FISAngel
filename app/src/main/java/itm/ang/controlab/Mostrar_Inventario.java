package itm.ang.controlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Inventario;
import itm.ang.controlab.entidades.Practica;

public class Mostrar_Inventario extends AppCompatActivity {

    ListView listviewInventario;
    ArrayList<String> listaInformacionInventario;
    ArrayList<Inventario>listaInventario;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar__inventario);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        listviewInventario=(ListView)findViewById(R.id.listviewInventario);

        consultarListaInventario();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionInventario);
        listviewInventario.setAdapter(adaptador);
    }

    private void consultarListaInventario() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Inventario inventario=null;
        listaInventario=new ArrayList<Inventario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_INVENTARIO,null);
        while (cursor.moveToNext()){
            inventario=new Inventario();
            inventario.setID(cursor.getInt(0));
            inventario.setSerieCPU(cursor.getString(1));
            inventario.setSerieTec(cursor.getString(2));
            inventario.setSerieRaton(cursor.getString(3));
            inventario.setSerieMonitor(cursor.getString(4));
            inventario.setCantidadRAM(cursor.getString(5));
            inventario.setCantidadDD(cursor.getString(6));
            inventario.setProcesador(cursor.getString(7));
            inventario.setDevc(cursor.getString(8));
            inventario.setNetbeans(cursor.getString(9));
            inventario.setEclipse(cursor.getString(10));
            inventario.setNotepad(cursor.getString(11));
            inventario.setgEdit(cursor.getString(12));
            inventario.setDia(cursor.getString(13));
            inventario.setPostgreSQL(cursor.getString(14));
            inventario.setPacket(cursor.getString(15));
            inventario.setVirtual(cursor.getString(16));
            inventario.setUnity(cursor.getString(17));
            inventario.setVisualStudio(cursor.getString(18));
            inventario.setInternet(cursor.getString(19));
            inventario.setSalon(cursor.getString(20));
            inventario.setObservaciones(cursor.getString(21));
            listaInventario.add(inventario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacionInventario=new ArrayList<String>();
        listaInformacionInventario.add("Inventario");

        for(int i=0;i<listaInventario.size();i++){
            listaInformacionInventario.add(""+listaInventario.get(i).getID()
                    +"\nNo. Serie CPU: "+listaInventario.get(i).getSerieCPU()
                    +"\nNo. Serie Teclado: "+listaInventario.get(i).getSerieTec()
                    +"\nNo. Serie Raton: "+listaInventario.get(i).getSerieRaton()
                    +"\nNo. Serie Monitor: "+listaInventario.get(i).getSerieMonitor()
                    +"\nRAM (GB): "+listaInventario.get(i).getCantidadRAM()
                    +"\nDD (GB): "+listaInventario.get(i).getCantidadDD()
                    +"\nProcesador: "+listaInventario.get(i).getProcesador()
                    +"\nDEV C++ "+listaInventario.get(i).getDevc()
                    +"\nNETBEANS "+listaInventario.get(i).getNetbeans()
                    +"\nECLIPSE "+listaInventario.get(i).getEclipse()
                    +"\nNOTEPAD ++ "+listaInventario.get(i).getNotepad()
                    +"\ngEDIT "+listaInventario.get(i).getgEdit()
                    +"\nDIA "+listaInventario.get(i).getDia()
                    +"\nPOSTGRESQL "+listaInventario.get(i).getPostgreSQL()
                    +"\nCISCO PACKET "+listaInventario.get(i).getPacket()
                    +"\nVIRTUAL BOX "+listaInventario.get(i).getVirtual()
                    +"\nUNITY "+listaInventario.get(i).getUnity()
                    +"\nVISUAL STUDIO "+listaInventario.get(i).getVisualStudio()
                    +"\nINTERNET "+listaInventario.get(i).getInternet()
                    +"\nSalon "+listaInventario.get(i).getSalon()
                    +"\nObservaciones "+listaInventario.get(i).getObservaciones());
        }
    }
}
