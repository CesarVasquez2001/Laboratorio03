package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab03.Adapters.PostulanteAdapter;

import java.util.ArrayList;
import java.util.List;

public class PostulanteRecyclerListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Postulante> postulanteList;
    Helper helper;
    private ArrayList<Postulante> lista = new ArrayList<Postulante>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_recycler_list);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        PostulanteAdapter postulanteAdapter= new PostulanteAdapter(postulanteList);
        recyclerView.setAdapter(postulanteAdapter);
        recyclerView.setHasFixedSize(true);
    }


    private void initData() {

        helper = new Helper(getApplicationContext());
        lista = helper.LeeDelArchivo();

        postulanteList = lista;


    }

}