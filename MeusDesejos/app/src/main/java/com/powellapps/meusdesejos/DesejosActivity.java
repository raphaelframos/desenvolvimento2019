package com.powellapps.meusdesejos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.powellapps.meusdesejos.adapter.AdapterDesejos;
import com.powellapps.meusdesejos.db.DesejoDAO;
import com.powellapps.meusdesejos.model.Desejo;

import java.util.ArrayList;

public class DesejosActivity extends AppCompatActivity {

    private static final int ATIVO = 0;
    private static final int REALIZADO = 1;

    private ArrayList<Desejo> desejos;
    private AdapterDesejos adapter;
    private TabLayout tabLayoutDesejos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desejos);

        RecyclerView recyclerViewDesejos = findViewById(R.id.recyclerView_desejos);
        recyclerViewDesejos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new AdapterDesejos(new ArrayList<Desejo>(), this);
        recyclerViewDesejos.setAdapter(adapter);

        tabLayoutDesejos = findViewById(R.id.tab_desejos);
        tabLayoutDesejos.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == ATIVO){
                    desejos = new DesejoDAO(getApplicationContext()).retornaAtivos();
                }else if(tab.getPosition() == REALIZADO){
                    desejos = new DesejoDAO(getApplicationContext()).retornaRealizados();
                }else{
                    desejos = new DesejoDAO(getApplicationContext()).retornaCancelados();
                }

                adapter.atualiza(desejos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        FloatingActionButton floatingActionButtonNovo = findViewById(R.id.floatingActionButton_novo_desejo);
        floatingActionButtonNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NovoDesejoActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        desejos = new DesejoDAO(this).retornaLista(tabLayoutDesejos.getSelectedTabPosition());
        adapter.atualiza(desejos);
    }
}
