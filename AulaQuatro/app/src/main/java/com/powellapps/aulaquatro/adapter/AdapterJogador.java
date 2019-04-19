package com.powellapps.aulaquatro.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.powellapps.aulaquatro.R;
import com.powellapps.aulaquatro.model.Jogador;

import java.util.ArrayList;

public class AdapterJogador extends RecyclerView.Adapter<AdapterJogador.ViewHolderJogador>{

    private ArrayList<Jogador> jogadores;

    public AdapterJogador(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @NonNull
    @Override
    public ViewHolderJogador onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_jogador, viewGroup, false);
        return new ViewHolderJogador(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderJogador viewHolderJogador, int posicao) {

        Jogador jogador = jogadores.get(posicao);

        viewHolderJogador.textViewTime.setText(jogador.getTime());
        viewHolderJogador.textViewNome.setText(jogador.getNome() + " e " + posicao);
      //  viewHolderJogador.imageViewFoto
        viewHolderJogador.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("", "Cliquei");
            }
        });

    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }

    public class ViewHolderJogador extends RecyclerView.ViewHolder {

        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewTime;

        public ViewHolderJogador(@NonNull View itemView) {
            super(itemView);
            imageViewFoto = itemView.findViewById(R.id.imageView_foto);
            textViewNome = itemView.findViewById(R.id.textView_nome);
            textViewTime = itemView.findViewById(R.id.textView_time);
        }
    }
}
