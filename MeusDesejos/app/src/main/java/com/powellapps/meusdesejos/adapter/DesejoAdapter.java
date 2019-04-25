package com.powellapps.meusdesejos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.model.Desejo;

import java.util.ArrayList;

//Extenda da classe Adapter, passando a classe ViewHolder que foi criada internamente no adapter
public class DesejoAdapter extends RecyclerView.Adapter<DesejoAdapter.ViewHolder> {

    private ArrayList<Desejo> desejos;

    public DesejoAdapter(ArrayList<Desejo> desejos) {
        this.desejos = desejos;
    }


    //Método que cria o xml e passa por parametro para o viewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View viewDesejo = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_desejo, viewGroup, false);
        return new ViewHolder(viewDesejo);
    }


    //Classe que mostra os dados na tela
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {

        Desejo desejo = desejos.get(posicao);
        viewHolder.textViewNome.setText(desejo.getNome());
        viewHolder.textViewData.setText(desejo.getData());

    }

    @Override
    public int getItemCount() {
        return desejos.size();
    }


    //Parte inicial. Sempre crie uma classe que extenda de ViewHolder para criar seu adapter
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNome;
        private TextView textViewData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Para utilizar o findViewById você precisa utilizar a variável passada por parâmetro
            textViewData = itemView.findViewById(R.id.textView_data_desejo);
            textViewNome = itemView.findViewById(R.id.textView_nome_desejo);

        }
    }
}
