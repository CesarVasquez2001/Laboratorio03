package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class PostulanteRegistroActivity extends AppCompatActivity {
    public static final String KEY_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteregistro);

        Button btnRegister = findViewById(R.id.buttonRegister);
        Button btnClean = findViewById(R.id.buttonLimpiar);

        EditText etd = findViewById(R.id.textDNI);
        EditText etn = findViewById(R.id.textNames);
        EditText eta = findViewById(R.id.textSurname);
        EditText etf = findViewById(R.id.textBirth);
        EditText etco = findViewById(R.id.textSchool);
        EditText etca = findViewById(R.id.textProfession);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = etd.getText().toString();
                String nombres = etn.getText().toString();
                String apellidos = eta.getText().toString();
                String fecha = etf.getText().toString();
                String colegio = etco.getText().toString();
                String carrera = etca.getText().toString();
                if (dni.length() == 0 || nombres.length() == 0 | apellidos.length() == 0 ||
                        fecha.length() == 0 || colegio.length() == 0 || carrera.length() == 0) {
                    Toast.makeText(PostulanteRegistroActivity.this, "Se debe completar todos los espacios", Toast.LENGTH_LONG).show();
                }else{
                    Postulante p = new Postulante(dni, nombres, apellidos, fecha, colegio, carrera);

                    Intent intent = new Intent();
                    intent.putExtra(KEY_NAME,(Serializable) p);
                    setResult(RESULT_OK,intent);
                    finish();
                }


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