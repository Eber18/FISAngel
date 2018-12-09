package itm.ang.controlab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itm.ang.controlab.BasesdeDatos.Conecxion;
import itm.ang.controlab.Utilidades.Utilidades;


public class Agregar_materia extends AppCompatActivity {
    private EditText etamat;
    private Button bAcep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materia);
        etamat = (EditText) findViewById( R.id.etamat);
        bAcep = (Button) findViewById(R.id.bAcep);

        bAcep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                registrarMaterias();
                //registrarmaterias();
               //registrarmateriassql();
            }
        });
    }

    private void registrarMaterias() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1); //Abriendo conexion
        SQLiteDatabase db=conn.getWritableDatabase();//Creando objeto para insertar datos
        ContentValues values =new ContentValues();//Objeto donde van a ir los datos
        values.put(Utilidades.CAMPO_NOMBRE_MATERIA,etamat.getText().toString());//Se ponen los datos en la variable
        Long nombreResultante=db.insert(Utilidades.TABLA_MATERIA,Utilidades.CAMPO_NOMBRE_MATERIA,values);//insercion de datos
        Toast.makeText(getApplicationContext(),"Registro Materia "+nombreResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }

    /*private void registrarmateriassql() {
        Conecxion conmat=new Conecxion(this,"BaseMaterias",null,1);
        SQLiteDatabase db = conmat.getWritableDatabase();
        //INSERT INTO bdmateria (nombre) values ('nombremateria')
        String insert="INSERT INTO "+Utilidades.TABLA_MATERIA+" ( "+Utilidades.NOMBRE_MATERIA+")"+" VALUES " +
                "("+etamat.getText().toString()+" )";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se Agrego: "+Utilidades.NOMBRE_MATERIA,Toast.LENGTH_LONG).show();
        db.close();
    }*/

/*
    private void registrarmaterias() {
        Conecxion conmat=new Conecxion(this,"BaseMaterias",null,1);
        SQLiteDatabase db = conmat.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.NOMBRE_MATERIA,etamat.getText().toString());
        Long materiaresultante=db.insert(Utilidades.TABLA_MATERIA,Utilidades.NOMBRE_MATERIA,values);
        Toast.makeText(getApplicationContext(),"Se Agrego: "+materiaresultante,Toast.LENGTH_LONG).show();
    }*/

}
