package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Menu_Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__registrar);
        Button bVerr=(Button) findViewById(R.id.bVerr);
        Button bRegistrar=(Button) findViewById(R.id.bRegistrar);

        bVerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Intent s = new Intent( Menu_Registrar.this, Ver_registro.class );
              //  startActivity(s);
            }
        });
        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_Registrar.this, Registro.class );
                startActivity(s);
            }
        });
    }
}