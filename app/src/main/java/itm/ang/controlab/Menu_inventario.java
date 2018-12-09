package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Menu_inventario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inventario);

        Button bVerin = (Button) findViewById(R.id.bVerin);
        Button bModi=(Button) findViewById(R.id.bModi);

        bVerin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                //Intent s = new Intent( Menu_mantenimiento.this, Ver_inventario.class );
                // startActivity(s);
            }
        });
        bModi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_inventario.this, Seleccion_inventario_salon.class );
                startActivity(s);
            }
        });
    }
}
