package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Menu_mantenimiento extends AppCompatActivity {

    Button bVer,bMante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mantenimiento);

        bVer = (Button) findViewById(R.id.bVer);
        bMante=(Button) findViewById(R.id.bMante);

        bVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_mantenimiento.this, Mostrar_Mantenimiento.class );
                startActivity(s);
            }
        });
        bMante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Menu_mantenimiento.this, Mantenimiento.class );
                startActivity(s);
            }
        });
    }
}
