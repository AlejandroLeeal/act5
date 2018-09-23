package com.example.leal.act5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<usuarios> listaUsuarios;
    RecyclerView recyclerUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();

    }

    public void agregarusuarios() {
        listaUsuarios.add(new usuarios("Jesus","Leal", "21",R.drawable.persona));
        listaUsuarios.add(new usuarios("Jorge", "Leal", "24", R.drawable.persona ));
        listaUsuarios.add(new usuarios("Guillermo", "Leal", "27", R.drawable.persona ));
        listaUsuarios.add(new usuarios("maria", "de la garza", "40", R.drawable.persona ));
        listaUsuarios.add(new usuarios("pedro", "perez", "15", R.drawable.persona ));
        listaUsuarios.add(new usuarios("juan", "carranza", "24", R.drawable.persona ));
        listaUsuarios.add(new usuarios("jair", "garcia", "30", R.drawable.persona ));

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.botondatos: utilidades.visualizacion=utilidades.LIST;
                break;
            case R.id.botondatoss: utilidades.visualizacion=utilidades.GRID;
                break;
        }
        construirRecycler();
    }

    public void construirRecycler() {
        listaUsuarios =new ArrayList<>();
        recyclerUsuarios = (RecyclerView) findViewById(R.id.RecyclerXML);

        if (utilidades.visualizacion==utilidades.LIST){
            recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerUsuarios.setLayoutManager(new GridLayoutManager(this,3));
        }

        agregarUsuarios();

        datosusuarios adapter=new datosusuarios(listaUsuarios);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+ listaUsuarios.get
                                (recyclerUsuarios.getChildAdapterPosition(view))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerUsuarios.setAdapter(adapter);
    }

    private void agregarUsuarios() {
    }
}

