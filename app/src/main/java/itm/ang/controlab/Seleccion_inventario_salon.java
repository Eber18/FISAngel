package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Seleccion_inventario_salon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_inventario_salon);

        Button bAg7 = (Button) findViewById(R.id.bAg7);
        Button bLtw=(Button) findViewById(R.id.bLtw);

        bAg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent s = new Intent( Seleccion_inventario_salon.this, Modificar_Inventario_Ag7.class );
                startActivity(s);
            }
        });
        bLtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccion_inventario_salon.this, Modificar_Inventario_Ltw.class );
                startActivity(s);
            }
        });

    }
}
