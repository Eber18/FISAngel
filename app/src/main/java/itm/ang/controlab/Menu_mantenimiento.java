package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Menu_mantenimiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mantenimiento);

        Button bVer = (Button) findViewById(R.id.bVer);
        Button bMante=(Button) findViewById(R.id.bMante);

        bVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //
                // Intent s = new Intent( Menu_mantenimiento.this, Ver_mantenimiento.class );
              //  startActivity(s);
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
