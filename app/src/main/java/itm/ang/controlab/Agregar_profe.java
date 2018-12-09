package itm.ang.controlab;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itm.ang.controlab.Utilidades.Utilidades;

public class Agregar_profe extends AppCompatActivity {

    private EditText etapr;
    private Button bAcep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_profe);

        etapr = (EditText) findViewById( R.id.etapr);
        bAcep = (Button) findViewById(R.id.bAcep);

        bAcep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                registrarProfesores();
            }
        });
    }

    private void registrarProfesores(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1); //Abriendo conexion
        SQLiteDatabase db=conn.getWritableDatabase();//Creando objeto para insertar datos
        ContentValues values =new ContentValues();//Objeto donde van a ir los datos
        values.put(Utilidades.CAMPO_NOMBRE_PROFESOR,etapr.getText().toString());//Se ponen los datos en la variable
        Long nombreResultante=db.insert(Utilidades.TABLA_PROFESOR,Utilidades.CAMPO_NOMBRE_PROFESOR,values);//insercion de datos
        Toast.makeText(getApplicationContext(),"Registro Profesor "+nombreResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
