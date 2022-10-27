package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        HashMap<String, String> cuentas = new HashMap<String, String>();
        cuentas.put("usuario1", "usuario1");
        cuentas.put("usuario2", "usuario2");


        Button btnLogin = findViewById(R.id.buttonLogin);
        EditText etu = findViewById(R.id.textUser);
        EditText etp = findViewById(R.id.textPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etu.getText().toString();
                String password = etp.getText().toString();
                if (cuentas.containsKey(usuario) && cuentas.get(usuario).equals(password)){
                    Toast.makeText(LoginActivity.this, "Inicio de sesion correcto", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "usuario o contaseña incorrecta", Toast.LENGTH_LONG).show();
                }
                etu.setText("");
                etp.setText("");
            }
        });

    }
}