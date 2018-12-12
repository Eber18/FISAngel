package itm.ang.controlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String usuario="", password="";
    private EditText etUsuario, etPasword;
    private Button bEntrar;
    static ArrayList<String> nombres =new ArrayList<String>();
    static ArrayList<String> passwords =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = (EditText) findViewById( R.id.etUsuario );
        etPasword = (EditText) findViewById(R.id.etPassword);
        bEntrar = (Button) findViewById( R.id.bEntrar);

        //Toast.makeText(getApplicationContext(),"HELLO ",Toast.LENGTH_LONG).show();

        nombres.add("yaneth");
        nombres.add("administrador");
        nombres.add("ayudante");
        passwords.add("fis");
        passwords.add("admin");
        passwords.add("social");

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        bEntrar.setOnClickListener(new View.OnClickListener() {

            //db = new DBGeneral(getApplicationContext);
            //ContentValues nombre = new ContentValues();
            //nombre.put(EsquemaDB.Esquema2.COLUMN_NOMBRE_ACCEDER, "yaneth");

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
}
