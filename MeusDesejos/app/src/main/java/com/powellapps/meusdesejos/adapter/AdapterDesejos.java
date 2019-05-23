package com.powellapps.meusdesejos.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.model.Desejo;

import java.util.ArrayList;

public class AdapterDesejos extends RecyclerView.Adapter<AdapterDesejos.ViewHolderDesejos>{

    ArrayList<Desejo> desejos = new ArrayList<>();

    public AdapterDesejos(ArrayList<Desejo> desejos) {
        this.desejos = desejos;
    }

    @NonNull
    @Override
    public ViewHolderDesejos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderDesejos(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_desejos, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDesejos viewHolderDesejos, int i) {

        Desejo desejo = desejos.get(i);

        viewHolderDesejos.textViewNomeDesejo.setText(desejo.getNome());
        int tamanhoDoTexto = desejo.getNome().length();
        float tamanhoDaFonte = 10f;

        if(tamanhoDoTexto < 12){
            tamanhoDaFonte = 32f;
        }else if(tamanhoDoTexto >= 12 && tamanhoDoTexto < 20){
            tamanhoDaFonte = 28f;
        }else{
            tamanhoDaFonte = 24f;
        }

     //   viewHolderDesejos.itemView.setBackgroundColor(ContextCompat.getColor(viewHolderDesejos.get));
        viewHolderDesejos.textViewNomeDesejo.setTextSize(TypedValue.COMPLEX_UNIT_SP, tamanhoDaFonte);
    }

    @Override
    public int getItemCount() {
        return desejos.size();
    }

    public void atualiza(ArrayList<Desejo> desejos) {
        this.desejos = desejos;
        notifyDataSetChanged();
    }


    class ViewHolderDesejos extends RecyclerView.ViewHolder {

        private TextView textViewNomeDesejo;

        public ViewHolderDesejos(@NonNull View itemView) {
            super(itemView);

            textViewNomeDesejo = itemView.findViewById(R.id.textView_nome_desejo);
        }
    }
}
