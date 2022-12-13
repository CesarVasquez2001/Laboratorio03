package com.example.lab03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private static String TAG = "MenuActivity";
    private ArrayList<Postulante> lista = new ArrayList<Postulante>();

    Helper helper;
    private ArrayList<Postulante> internalStorage ;


    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode() == RESULT_OK){
                if(result.getData()!=null && result.getData().getSerializableExtra(PostulanteRegistroActivity.KEY_NAME) != null){
                    Postulante p = (Postulante) result.getData().getSerializableExtra(PostulanteRegistroActivity.KEY_NAME);
                    lista.add(p);
                    // Actualiza el archivo en el internal storage
                    helper.GuardaEnArchivo(lista);
                    // Probar que se guardo en el internal storage
                    internalStorage = helper.LeeDelArchivo();
                    Log.d(TAG,internalStorage+"INTERNAL STORAGE");


                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnInfo = findViewById(R.id.buttonInfo);
        Button btnNew = findViewById(R.id.buttonNew);

        // Inicializar la lista con los datos guardados en el internal storage
        helper = new Helper(getApplicationContext());
        lista = helper.LeeDelArchivo();
        Log.d(TAG,lista+"\nLISTA INICIAL");

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                intent.putExtra("POSTULANTE_EXTRA", lista);
                startActivity(intent);
            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startForResult.launch(intent);
            }
        });
    }
}