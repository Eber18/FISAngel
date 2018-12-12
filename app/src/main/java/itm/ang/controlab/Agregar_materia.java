package itm.ang.controlab;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itm.ang.controlab.Utilidades.Utilidades;


public class Agregar_materia extends AppCompatActivity {
    private EditText etamat;
    private Button bAcep;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materia);
        etamat = (EditText) findViewById( R.id.etamat);
        bAcep = (Button) findViewById(R.id.bAcep);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        bAcep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(etamat.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Registro no exitoso ",Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase db=conn.getReadableDatabase();
                    String[] materia={etamat.getText().toString()};

                    try {
                        Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE_MATERIA+" FROM "
                                +Utilidades.TABLA_MATERIA+" WHERE "+Utilidades.CAMPO_NOMBRE_MATERIA+"=?",materia);
                        cursor.moveToFirst();
                        Toast.makeText(getApplicationContext(),"Ya existe "+cursor.getString(0),Toast.LENGTH_SHORT).show();
                        etamat.setText("");
                    }catch (Exception e){
                        registrarMaterias();
                        etamat.setText("");
                    }
                }
            }
        });
    }

    private void registrarMaterias() {
        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1); //Abriendo conexion
        SQLiteDatabase db=conn.getWritableDatabase();//Creando objeto para insertar datos
        ContentValues values =new ContentValues();//Objeto donde van a ir los datos
        values.put(Utilidades.CAMPO_NOMBRE_MATERIA,etamat.getText().toString());//Se ponen los datos en la variable
        Long nombreResultante=db.insert(Utilidades.TABLA_MATERIA,Utilidades.CAMPO_NOMBRE_MATERIA,values);//insercion de datos
        Toast.makeText(getApplicationContext(),"Se agrego "+etamat.getText().toString(),Toast.LENGTH_SHORT).show();
        db.close();
    }

}
