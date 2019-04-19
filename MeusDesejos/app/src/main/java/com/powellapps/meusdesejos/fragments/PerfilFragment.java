package com.powellapps.meusdesejos.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.powellapps.meusdesejos.EditarPerfilActivity;
import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.model.Perfil;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    public PerfilFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //findViewById tem que ser precedido de getView()
        ImageView imageViewFoto = getView().findViewById(R.id.imageView_foto);
        TextView textViewNome = getView().findViewById(R.id.textView_nome);
        TextView textViewDescricao = getView().findViewById(R.id.textView_descricao);
        FloatingActionButton floatingActionButtonEditar = getView().findViewById(R.id.floating_editar_perfil);

        //Criação do modelo perfil
        Perfil perfil = new Perfil();
        perfil.setDescricao("Sou um cara legal");
        perfil.setNome("Raphael Ramos");
        perfil.setFoto("https://pbs.twimg.com/profile_images/726252987/imagem_400x400.JPG");

        //Mostrando o modelo na tela
        Picasso.get().load(perfil.getFoto()).into(imageViewFoto);
        textViewNome.setText(perfil.getNome());
        textViewDescricao.setText(perfil.getDescricao());

        //implementando o click do botão flutuante
        floatingActionButtonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gustavoVacilao = new Intent(getContext(), EditarPerfilActivity.class);
                startActivity(gustavoVacilao);
            }
        });

    }
}
