package com.powellapps.meusdesejos.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.powellapps.meusdesejos.NovoDesejoActivity;
import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.adapter.FeedAdapter;
import com.powellapps.meusdesejos.db.DesejoDAO;
import com.powellapps.meusdesejos.model.Desejo;
import com.powellapps.meusdesejos.model.Perfil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private FeedAdapter feedAdapter;
    private static final String PARAMETRO_BUNDLE = "tipoDeBusca";

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment novaInstancia(boolean meusDesejos) {
        FeedFragment feedFragment = new FeedFragment();
        Bundle argumentos = new Bundle();
        argumentos.putBoolean(PARAMETRO_BUNDLE, meusDesejos);
        feedFragment.setArguments(argumentos);
        return feedFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        RecyclerView recyclerViewFeed = getView().findViewById(R.id.recyclerView_feed);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewFeed.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        feedAdapter = new FeedAdapter();
        recyclerViewFeed.setAdapter(feedAdapter);

        FloatingActionButton fab = getView().findViewById(R.id.floating_novo_desejo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NovoDesejoActivity.class));
            }
        });

        try{
            boolean ehMeusDesejos = getArguments().getBoolean(PARAMETRO_BUNDLE);
            if(ehMeusDesejos){
                criaListaComMeusDesejos();
            }else{
               // criaLista();
            }
        }catch (Exception e){
            //criaLista();
        }

    }

    private void criaListaComMeusDesejos() {

        ArrayList<Desejo> desejos = new DesejoDAO(getContext()).retornaLista();


        feedAdapter.atualiza(desejos);
    }

    private void criaLista() {
        ArrayList<Desejo> desejos = new ArrayList<>();

        Perfil perfil = new Perfil();
        perfil.setFoto("https://img.r7.com/images/neymar-28042019121602527?dimensions=460x305");
        perfil.setNome("Neymar Jr");

        Perfil perfil1 = new Perfil();
        perfil1.setNome("Bruna Marquezine");
        perfil1.setFoto("https://static.otvfoco.com.br/2019/02/c79d5a09-5278-41b0-8be3-a8209d4fd84b.jpg");

        Desejo desejo1 = new Desejo("Ir para Bariloche");
        desejo1.setPerfil(perfil);
        Desejo desejo2 = new Desejo("Comprar uma kawasaki");
        desejo2.setPerfil(perfil);
        Desejo desejo3 = new Desejo("Comprar boi");
        desejo3.setPerfil(perfil);

        Desejo desejo4 = new Desejo("Casar com Neymar, ter 3 filhos, separar, ganhar uma pensão de 200 mil reais por filho, casar novamente com o Rodrigo Hilbert");
        desejo4.setPerfil(perfil1);

        desejos.add(desejo1);
        desejos.add(desejo2);
        desejos.add(desejo3);
        desejos.add(desejo4);

        feedAdapter.atualiza(desejos);

    }
}
