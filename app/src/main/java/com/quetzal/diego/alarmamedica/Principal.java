package com.quetzal.diego.alarmamedica;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal extends Activity {

    private ImageView imagen;
    private TextView hora, medicina, dosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imagen = (ImageView) findViewById(R.id.image);
        hora = (TextView) findViewById(R.id.tiempo);
        medicina = (TextView) findViewById(R.id.medicina);
        dosis = (TextView) findViewById(R.id.dosis);

        medicina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String med = medicina.getText().toString();
                if(!med.isEmpty()){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://es.wikipedia.org/wiki/"+med));
                    startActivity(i);
                }
            }
        });

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevoMedicamento.class);
                startActivity(i);
            }
        });
    }
}
