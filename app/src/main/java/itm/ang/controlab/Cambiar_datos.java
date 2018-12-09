package itm.ang.controlab;

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


public class Cambiar_datos extends AppCompatActivity {
    Spinner esNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);
        EditText etn, etp, etcp;
        Button bConfirmar;
        etn = (EditText) findViewById( R.id.etn);
        etp = (EditText) findViewById(R.id.etp);
        bConfirmar = (Button) findViewById( R.id.bConfirmar);
        esNom= (Spinner)findViewById(R.id.esNom);

    }
}
