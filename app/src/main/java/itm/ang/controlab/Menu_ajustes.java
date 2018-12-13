package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Menu_ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ajustes);
        Button bVerc=(Button) findViewById(R.id.bVerc);
        Button bCcon=(Button) findViewById(R.id.bCcon);

        bVerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_ajustes.this, Ver_Datos.class );
                startActivity(s);
            }
        });
        bCcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_ajustes.this, Cambiar_datos.class );
                startActivity(s);
            }
        });
    }
}
