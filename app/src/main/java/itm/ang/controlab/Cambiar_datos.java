package itm.ang.controlab;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Usuario;


public class Cambiar_datos extends AppCompatActivity {
    Spinner esNom;
    EditText etn,etp,etcp;
    Button bConfirmar;

    ArrayList<String> usuarios;
    ArrayList<Usuario> listaUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);


        etn = (EditText) findViewById( R.id.etn);
        etp = (EditText) findViewById(R.id.etp);
        etcp=(EditText)findViewById(R.id.etcp);
        bConfirmar = (Button) findViewById( R.id.bConfirmar);
        esNom= (Spinner)findViewById(R.id.esNom);

        final String usuarioTexto="Usuario";

        //consultarListaUsuarios();

        //ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this,android.R.layout.simple_spinner_item,usuarios);
        //esNom.setAdapter(adaptador);

        bConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(usuarioTexto.equals(esNom.getSelectedItem().toString())
                        ||!etp.getText().toString().equals(etcp.getText().toString())
                        ||etn.getText().toString().isEmpty()||etp.getText().toString().isEmpty()
                        ||etcp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"No se pudo registrar ",Toast.LENGTH_SHORT).show();
                    etp.setText("");
                    etcp.setText("");
                }else{
                    actualizarUsuario();
                    esNom.setSelection(0);
                    etn.setText("");
                    etp.setText("");
                    etcp.setText("");
                    //Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void consultarListaUsuarios() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIOS,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setUsuario(cursor.getString(0));

            listaUsuarios.add(usuario);
        }

        obtenerListaUsuarios();
    }

    private void obtenerListaUsuarios() {
        usuarios=new ArrayList<String>();
        usuarios.add("Usuario");

        for (int i=0;i<listaUsuarios.size();i++){
            usuarios.add(listaUsuarios.get(i).getUsuario());
        }
    }

    private void actualizarUsuario(){
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] nombre={etn.getText().toString().trim()};

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_USUARIO,etn.getText().toString().trim());
        values.put(Utilidades.CAMPO_CONTRASEÑA,etcp.getText().toString().trim());

        db.update(Utilidades.TABLA_USUARIOS,values,Utilidades.CAMPO_USUARIO+"=?",nombre);
        Toast.makeText(getApplicationContext(),"Actualizado!",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
