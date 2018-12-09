package itm.ang.controlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Seleccionamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionamiento);
        Button bVerHorario = (Button) findViewById(R.id.bVerHorario);
        Button bRegistro = (Button) findViewById(R.id.bRegistro);
        Button bMantenimiento = (Button) findViewById(R.id.bMantenimiento);
        Button bInventario=(Button) findViewById(R.id.bInventario);
        Button bAprofe=(Button) findViewById(R.id.bAprofe);
        Button bAmat=(Button) findViewById(R.id.bAmat);

        bVerHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, VerHorario.class );
                startActivity(s);
            }
        });
        bRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, Registro.class );
                startActivity(s);
            }
        });
        bMantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, Menu_mantenimiento.class );
                startActivity(s);
            }
        });
        bInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, Menu_inventario.class );
                startActivity(s);
            }
        });
        bAprofe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, Agregar_profe.class );
                startActivity(s);
            }
        });
        bAmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent( Seleccionamiento.this, Agregar_materia.class );
                startActivity(s);
            }
        });
    }
}
