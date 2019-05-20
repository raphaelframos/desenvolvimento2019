package com.powellapps.meusdesejos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.powellapps.meusdesejos.R;
import com.powellapps.meusdesejos.model.Desejo;
import com.powellapps.meusdesejos.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{

    private ArrayList<Desejo> desejos = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_feed, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {

        Desejo desejo = desejos.get(posicao);
        viewHolder.textViewNomeDoDesejo.setText(desejo.getNome());
        viewHolder.textViewNome.setText(desejo.getPerfil().getNome());
        viewHolder.textViewData.setText(desejo.getDataFormatada());
        Picasso.get().load(desejo.getPerfil().getFoto()).transform(new CircleTransform()).into(viewHolder.imageViewFoto);
    }

    @Override
    public int getItemCount() {
        return desejos.size();
    }

    public void atualiza(ArrayList<Desejo> desejos) {
        this.desejos = desejos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewData;
        private TextView textViewNomeDoDesejo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFoto = itemView.findViewById(R.id.imageView_foto_feed);
            textViewData = itemView.findViewById(R.id.textView_data_desejo_feed);
            textViewNome = itemView.findViewById(R.id.textView_nome_perfil);
            textViewNomeDoDesejo = itemView.findViewById(R.id.textView_nome_desejo_feed);
        }
    }
}
