package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Modificar_Inventario extends AppCompatActivity {

    EditText etSerieCPU,etTeclado,etRaton,etMonitor,etRAM,etDD,etProcesador,etOb;
    Button bCom;
    Spinner spSalon;
    CheckBox chbDev,chbNet,chbEcl,chbNote,chbGed,chbDia,chbPost,chbCisco,chbVir,chbUni,chbVis,chbInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__inventario);
    }
}
