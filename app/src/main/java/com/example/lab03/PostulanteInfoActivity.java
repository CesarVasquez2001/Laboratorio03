package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PostulanteInfoActivity extends AppCompatActivity {
    private static String TAG = "PostulanteInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinfo);


        ArrayList<Postulante> lista= (ArrayList<Postulante>) getIntent().getSerializableExtra("POSTULANTE_EXTRA");

        Button btnSearch = findViewById(R.id.buttonSearch);
        Button btnClean = findViewById(R.id.buttonLimpiar);


        EditText etsd = findViewById(R.id.texDNIsearch);

        EditText etd = findViewById(R.id.infDNI);
        EditText etn = findViewById(R.id.infNombres);
        EditText eta = findViewById(R.id.infApellidos);
        EditText etf = findViewById(R.id.infFecha);
        EditText etco = findViewById(R.id.infColegio);
        EditText etca = findViewById(R.id.infCarrera);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean encontrado=false;
                String dnisearch = etsd.getText().toString();
                Log.d(TAG, lista + "");
                for(int i=0;i<lista.size();i++){

                    if (lista.get(i).getDNI().equals(dnisearch)){
                        etd.setText(lista.get(i).getDNI());
                        eta.setText(lista.get(i).getApellidos());
                        etn.setText(lista.get(i).getNombres());
                        etca.setText(lista.get(i).getCarrera());
                        etco.setText(lista.get(i).getColegio());
                        etf.setText(lista.get(i).getFechaNac());
                        encontrado=true;
                        Toast.makeText(PostulanteInfoActivity.this, "Postulante encontrado", Toast.LENGTH_LONG).show();

                        break;
                    }
                }
                if (encontrado==false){
                    Toast.makeText(PostulanteInfoActivity.this, "Postulante no existe", Toast.LENGTH_LONG).show();
                }
                etsd.setText("");
            }
        });
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etd.setText("");
                eta.setText("");
                etn.setText("");
                etca.setText("");
                etco.setText("");
                etf.setText("");
            }
        });

    }
}