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
import itm.ang.controlab.entidades.Usuario;

public class Ver_Datos extends AppCompatActivity {

    ListView listViewUsuarios;
    ArrayList<String> listaInformacionUsuarios;
    ArrayList<Usuario>listaUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__datos);

        listViewUsuarios=(ListView)findViewById(R.id.listviewUsuarios);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        consultarListaUsuarios();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionUsuarios);
        listViewUsuarios.setAdapter(adaptador);
    }

    private void consultarListaUsuarios() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIOS,null);
        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setUsuario(cursor.getString(0));
            usuario.setContraseña(cursor.getString(1));
            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacionUsuarios=new ArrayList<String>();
        listaInformacionUsuarios.add("Usuarios");

        for(int i=0;i<listaUsuarios.size();i++){
            listaInformacionUsuarios.add("Usuario: "+listaUsuarios.get(i).getUsuario()
                    +"\nContraseña: "+listaUsuarios.get(i).getContraseña());
        }
    }
}
