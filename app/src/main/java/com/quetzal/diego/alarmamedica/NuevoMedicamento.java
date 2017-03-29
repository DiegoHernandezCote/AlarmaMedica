package com.quetzal.diego.alarmamedica;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NuevoMedicamento extends Activity{

    private TextView tiempo, presen;
    private Spinner opMed, opInter;
    private Button save;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevomedicamento);

        tiempo = (TextView) findViewById(R.id.tiempo);
        opMed = (Spinner) findViewById(R.id.presentacion);
        save = (Button) findViewById(R.id.save);
        opInter = (Spinner) findViewById(R.id.intervalo);

        tiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment() ;
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),opMed.getSelectedItem().toString() + " / " + opInter.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                Alarma();
            }
        });
    }

    public void Alarma(){
        String t = tiempo.getText().toString();
    }
}
