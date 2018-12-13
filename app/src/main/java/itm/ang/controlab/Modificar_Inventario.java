package itm.ang.controlab;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import itm.ang.controlab.Utilidades.Utilidades;

public class Modificar_Inventario extends AppCompatActivity {

    EditText etSerieCPU,etTeclado,etRaton,etMonitor,etRAM,etDD,etProcesador,etOb;
    Button bComple;
    Spinner spSalon;
    CheckBox chbDevC,chbNetB,chbEclip,chbNotep,chbGede,chbDIA,chbPostg,chbCiscoP,chbVirt,chbUnin,chbVS,chbInter;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__inventario);

        etSerieCPU=(EditText)findViewById(R.id.etSerieCPU);
        etTeclado=(EditText)findViewById(R.id.etTeclado);
        etRaton=(EditText)findViewById(R.id.etRaton);
        etMonitor=(EditText)findViewById(R.id.etMonitor);
        etRAM=(EditText)findViewById(R.id.etRAM);
        etDD=(EditText)findViewById(R.id.etDD);
        etProcesador=(EditText)findViewById(R.id.etProcesador);
        etOb=(EditText)findViewById(R.id.etOb);
        bComple=(Button)findViewById(R.id.bComple);
        spSalon=(Spinner)findViewById(R.id.spSalon);
        chbDevC=(CheckBox)findViewById(R.id.chbDevC);
        chbNetB=(CheckBox)findViewById(R.id.chbNetB);
        chbEclip=(CheckBox)findViewById(R.id.chbEclip);
        chbNotep=(CheckBox)findViewById(R.id.chbNotep);
        chbGede=(CheckBox)findViewById(R.id.chbGede);
        chbDIA=(CheckBox)findViewById(R.id.chbDIA);
        chbPostg=(CheckBox)findViewById(R.id.chbPostg);
        chbCiscoP=(CheckBox)findViewById(R.id.chbCiscoP);
        chbVirt=(CheckBox)findViewById(R.id.chbVirt);
        chbUnin=(CheckBox)findViewById(R.id.chbUnin);
        chbVS=(CheckBox)findViewById(R.id.chbVS);
        chbInter=(CheckBox)findViewById(R.id.chbInter);

        String[] salones=new String[]{"Seleccione","LTW","LIS","REDES"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,salones);
        spSalon.setAdapter(adapter);

        conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);

        bComple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(etSerieCPU.getText().toString().isEmpty()||spSalon.getSelectedItem().toString().equals("Seleccione")){
                    Toast.makeText(getApplicationContext(),"No se puede registrar\n" +
                                    "Asegurese de elegir salon o llenar NumSerieEquipo", Toast.LENGTH_SHORT).show();
                }else{
                    registrarInventario();
                    etSerieCPU.setText("");
                    etTeclado.setText("");
                    etRaton.setText("");
                    etMonitor.setText("");
                    etRAM.setText("");
                    etDD.setText("");
                    etProcesador.setText("");
                    etOb.setText("");
                    spSalon.setSelection(0);
                }
            }
        });
    }

    private void registrarInventario(){
        String dev,net,ecli,note,gedit,dia,post,packet,virtual,unity,vs,inter;
        if(chbDevC.isChecked()){
            dev="Si";
        }else{
            dev="No";
        }
        if(chbNetB.isChecked()){
            net="Si";
        }else{
            net="No";
        }
        if(chbEclip.isChecked()){
            ecli="Si";
        }else{
            ecli="No";
        }
        if(chbNotep.isChecked()){
            note="Si";
        }else{
            note="No";
        }
        if(chbGede.isChecked()){
            gedit="Si";
        }else{
            gedit="No";
        }
        if(chbDIA.isChecked()){
            dia="Si";
        }else{
            dia="No";
        }
        if(chbPostg.isChecked()){
            post="Si";
        }else{
            post="No";
        }
        if(chbCiscoP.isChecked()){
            packet="Si";
        }else{
            packet="No";
        }
        if(chbVirt.isChecked()){
            virtual="Si";
        }else{
            virtual="No";
        }
        if(chbUnin.isChecked()){
            unity="Si";
        }else{
            unity="No";
        }
        if(chbVS.isChecked()){
            vs="Si";
        }else{
            vs="No";
        }
        if(chbInter.isChecked()){
            inter="Si";
        }else{
            inter="No";
        }
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_Laboratorios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Utilidades.CAMPO_EQUIPO,etSerieCPU.getText().toString());
        values.put(Utilidades.CAMPO_TECLADO,etTeclado.getText().toString());
        values.put(Utilidades.CAMPO_RATON,etRaton.getText().toString());
        values.put(Utilidades.CAMPO_MONITOR,etMonitor.getText().toString());
        values.put(Utilidades.CAMPO_RAM,etRAM.getText().toString());
        values.put(Utilidades.CAMPO_DD,etDD.getText().toString());
        values.put(Utilidades.CAMPO_PROCESADOR,etProcesador.getText().toString());
        values.put(Utilidades.CAMPO_DEV,dev);
        values.put(Utilidades.CAMPO_NET,net);
        values.put(Utilidades.CAMPO_ECLIP,ecli);
        values.put(Utilidades.CAMPO_NOTE,note);
        values.put(Utilidades.CAMPO_gED,gedit);
        values.put(Utilidades.CAMPO_DIA,dia);
        values.put(Utilidades.CAMPO_POST,post);
        values.put(Utilidades.CAMPO_CISCO,packet);
        values.put(Utilidades.CAMPO_VIRTUAL,virtual);
        values.put(Utilidades.CAMPO_UNITY,unity);
        values.put(Utilidades.CAMPO_VS,vs);
        values.put(Utilidades.CAMPO_INTERNET,inter);
        values.put(Utilidades.CAMPO_SALON,spSalon.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_OBSERVACIONES,etOb.getText().toString());
        Long idResultante=db.insert(Utilidades.TABLA_INVENTARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Registro exitoso: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
        limpiar();
    }

    private void limpiar() {
        chbDevC.setChecked(false);
        chbNetB.setChecked(false);
        chbEclip.setChecked(false);
        chbNotep.setChecked(false);
        chbGede.setChecked(false);
        chbDIA.setChecked(false);
        chbPostg.setChecked(false);
        chbCiscoP.setChecked(false);
        chbVirt.setChecked(false);
        chbUnin.setChecked(false);
        chbVS.setChecked(false);
        chbInter.setChecked(false);
    }
}
