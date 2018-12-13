package itm.ang.controlab;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import itm.ang.controlab.Utilidades.Utilidades;
import itm.ang.controlab.entidades.Mantenimiento;
import itm.ang.controlab.entidades.Usuario;

public class MainActivity extends AppCompatActivity {
    String usuario="", password="";
    private EditText etUsuario, etPasword;
    private Button bEntrar;


    ArrayList<String> nombres=new ArrayList<String>();;
    ArrayList<String> passwords=new ArrayList<>();;
    ArrayList<Usuario>listaUsuarios;
    ArrayList<Usuario>listaContraseñas;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = (EditText) findViewById( R.id.etUsuario );
        etPasword = (EditText) findViewById(R.id.etPassword);
        bEntrar = (Button) findViewById( R.id.bEntrar);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        if(consultarUsuarios()==0){
            crearUsuarios();
        }
        if(consultarUsuarios()==3){
            obtenerUsuarios();
            obtenerContraseñas();
        }

        bEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                usuario = etUsuario.getText().toString().trim();
                password = etPasword.getText().toString().trim();

                if( usuario.equals("") && password.equals("") ){
                    Toast t = Toast.makeText( getApplicationContext(),
                            "Favor de ingresar todos los datos", Toast.LENGTH_LONG );
                    t.show();
                }
                else if ( usuario.equals(nombres.get(0)) && password.equals(passwords.get(0)) ){
                    Toast t = Toast.makeText( getApplicationContext(),
                            "Bienvenida "+nombres.get(0), Toast.LENGTH_LONG );
                    t.show();
                    Intent sy = new Intent( MainActivity.this, Seleccionamientoy.class );
                    etUsuario.setText("");
                    etPasword.setText("");
                    sy.putExtra( "usuario", usuario );
                    sy.putExtra("password", password);
                    startActivity(sy);
                }
                else if ( usuario.equals(nombres.get(1)) && password.equals(passwords.get(1)) ){
                    Toast t = Toast.makeText( getApplicationContext(),
                            "Bienvenido "+nombres.get(1), Toast.LENGTH_LONG );
                    t.show();
                    Intent s = new Intent( MainActivity.this, Seleccionamiento.class );
                    etUsuario.setText("");
                    etPasword.setText("");
                    s.putExtra( "usuario", usuario );
                    s.putExtra("password", password);
                    startActivity(s);
                }
                else if ( usuario.equals(nombres.get(2)) && password.equals(passwords.get(2)) ) {
                    Toast t = Toast.makeText( getApplicationContext(),
                            "Bienvenido "+nombres.get(2), Toast.LENGTH_LONG );
                    t.show();
                    Intent s = new Intent( MainActivity.this, Seleccionamiento.class );
                    startActivity(s);
                    etUsuario.setText("");
                    etPasword.setText("");
                }
                else if(usuario.equals(nombres.get(0))&&!password.equals(passwords.get(0))){
                    Toast t=Toast.makeText(getApplicationContext(),"Contraseña incorrecta "+nombres.get(0),Toast.LENGTH_LONG);
                    t.show();
                    etPasword.setText("");
                }
                else if(usuario.equals(nombres.get(1))&&!password.equals(passwords.get(1))){
                    Toast t=Toast.makeText(getApplicationContext(),"Contraseña incorrecta "+nombres.get(1),Toast.LENGTH_LONG);
                    t.show();
                    etPasword.setText("");
                }
                else if(usuario.equals(nombres.get(2))&&!password.equals(passwords.get(2))){
                    Toast t=Toast.makeText(getApplicationContext(),"Contraseña incorrecta "+nombres.get(2),Toast.LENGTH_LONG);
                    t.show();
                    etPasword.setText("");
                }
                else {
                    Toast t = Toast.makeText( getApplicationContext(),"Ingresa bien los datos "+usuario.toString(), Toast.LENGTH_LONG );
                    t.show();
                }
            }
        });
    }

    private void crearUsuarios() {
        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        String usuarioYanet,usuarioAdmin,usuarioAyudante;
        usuarioYanet="INSERT INTO "+Utilidades.TABLA_USUARIOS+" ("+Utilidades.CAMPO_USUARIO+","
                +Utilidades.CAMPO_CONTRASEÑA+") VALUES('yaneth','fis')";
        usuarioAdmin="INSERT INTO "+Utilidades.TABLA_USUARIOS+" ("+Utilidades.CAMPO_USUARIO+","
                +Utilidades.CAMPO_CONTRASEÑA+") VALUES('administrador','admin')";
        usuarioAyudante="INSERT INTO "+Utilidades.TABLA_USUARIOS+" ("+Utilidades.CAMPO_USUARIO+","
                +Utilidades.CAMPO_CONTRASEÑA+") VALUES('ayudante','social')";
        db.execSQL(usuarioYanet);
        db.execSQL(usuarioAdmin);
        db.execSQL(usuarioAyudante);
        db.close();
    }

    private int consultarUsuarios() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIOS,null);
        return cursor.getCount();
    }

    private void obtenerUsuarios() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIOS,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setUsuario(cursor.getString(0));

            listaUsuarios.add(usuario);
        }
        System.out.println("lista usuario: "+listaUsuarios);
        obtenerListaUsuarios();
    }

    private void obtenerContraseñas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario contraseña=null;
        listaContraseñas=new ArrayList<Usuario>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIOS,null);

        while (cursor.moveToNext()){
            contraseña=new Usuario();
            contraseña.setContraseña(cursor.getString(1));

            listaContraseñas.add(contraseña);
        }
        obtenerListaContraseñas();
    }

    private void obtenerListaUsuarios() {
        nombres=new ArrayList<String>();

        for (int i=0;i<listaUsuarios.size();i++){
            nombres.add(listaUsuarios.get(i).getUsuario());
            Toast.makeText(getApplicationContext(),"Registro Practica "+nombres.get(i).toString(),Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerListaContraseñas() {
        passwords=new ArrayList<String>();

        for (int i=0;i<listaContraseñas.size();i++){
            passwords.add(listaContraseñas.get(i).getContraseña());
            Toast.makeText(getApplicationContext(),"Contraseña "+passwords.get(i).toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
