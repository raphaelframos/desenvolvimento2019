package com.powellapps.meusdesejos.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.powellapps.meusdesejos.NovoDesejoActivity;
import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.adapter.DesejoAdapter;
import com.powellapps.meusdesejos.db.Singleton;
import com.powellapps.meusdesejos.model.Desejo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesejoFragment extends Fragment {


    private DesejoAdapter adapter;

    public DesejoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_desejo, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Não esquecer do getView quando estiver utilizando fragmento
        RecyclerView recyclerViewDesejos = getView().findViewById(R.id.recyclerView_desejos);
        //LayoutManager você decide se será um grid ou uma lista
        recyclerViewDesejos.setLayoutManager(new LinearLayoutManager(getContext()));
        //Linha horizontal que separa cada elemento da lista
        recyclerViewDesejos.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        //Cria um adapter com os desejos criados no Singleton
        adapter = new DesejoAdapter(Singleton.getInstance().getDesejos());
        recyclerViewDesejos.setAdapter(adapter);

        //Botao flutuante
        FloatingActionButton fab = getView().findViewById(R.id.floating_novo_desejo);
        //Click do botao flutuante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Troca de tela
                startActivity(new Intent(getContext(), NovoDesejoActivity.class));
            }
        });

    }

}
