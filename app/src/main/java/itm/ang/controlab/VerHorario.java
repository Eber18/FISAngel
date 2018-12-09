package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class VerHorario extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_horario);
        Button bRedes = (Button) findViewById(R.id.bRedes);
        Button bLTW = (Button) findViewById(R.id.bLtw);
        Button bLis = (Button) findViewById(R.id.bLis);

        bRedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText( getApplicationContext(),
                        "FOTO DE HORARIO REDES", Toast.LENGTH_LONG );
                t.show();
                Intent s = new Intent( VerHorario.this, Reddes.class );
                startActivity(s);
            }
        });
        bLTW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText( getApplicationContext(),
                        "FOTO DE HORARIO LTW", Toast.LENGTH_LONG );
                t.show();
                Intent s = new Intent( VerHorario.this, Ltw.class );
                startActivity(s);
            }
        });
        bLis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText( getApplicationContext(),
                        "FOTO DE HORARIO LIS (no escontrado)", Toast.LENGTH_LONG );
                t.show();
            }
        });
    }
}
