package itm.ang.controlab;

import android.content.ContentValues;
import android.database.Cursor;
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

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_profe);

        etapr = (EditText) findViewById( R.id.etapr);
        bAcep = (Button) findViewById(R.id.bAcep);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        bAcep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(etapr.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Registro no exitoso ",Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase db = conn.getReadableDatabase();
                    String[] profesor = {etapr.getText().toString().trim().toUpperCase()};
                    try {
                        Cursor cursor = db.rawQuery("SELECT " + Utilidades.CAMPO_NOMBRE_PROFESOR + " FROM "
                                + Utilidades.TABLA_PROFESOR + " WHERE " + Utilidades.CAMPO_NOMBRE_PROFESOR + "=?", profesor);
                        cursor.moveToFirst();
                        Toast.makeText(getApplicationContext(), "Ya existe "+cursor.getString(0), Toast.LENGTH_SHORT).show();
                        etapr.setText("");
                    } catch (Exception e) {
                        registrarProfesores();
                        etapr.setText("");
                    }
                }
            }
        });
    }

    private void registrarProfesores(){
        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1); //Abriendo conexion
        SQLiteDatabase db=conn.getWritableDatabase();//Creando objeto para insertar datos
        ContentValues values =new ContentValues();//Objeto donde van a ir los datos
        values.put(Utilidades.CAMPO_NOMBRE_PROFESOR,etapr.getText().toString().trim().toUpperCase());//Se ponen los datos en la variable
        Long nombreResultante=db.insert(Utilidades.TABLA_PROFESOR,Utilidades.CAMPO_NOMBRE_PROFESOR,values);//insercion de datos
        Toast.makeText(getApplicationContext(),"Se agrego "+etapr.getText().toString(),Toast.LENGTH_SHORT).show();
        db.close();
    }
}
