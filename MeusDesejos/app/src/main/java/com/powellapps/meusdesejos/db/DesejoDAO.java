package com.powellapps.meusdesejos.db;

import android.content.Context;
import android.database.Cursor;

import com.powellapps.meusdesejos.model.Desejo;
import com.powellapps.meusdesejos.model.Perfil;

import java.util.ArrayList;

public class DesejoDAO extends DbHelper{

    public DesejoDAO(Context applicationContext) {
        super(applicationContext);
    }

    public void salvar(Desejo desejo) {
        getWritableDatabase().insert(NOME_TABELA_DESEJO, null, desejo.getValues());
    }

    public ArrayList<Desejo> retornaLista() {

        ArrayList<Desejo> desejos = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(NOME_TABELA_DESEJO, null, null, null, null,null,null);

        while (cursor.moveToNext()){
            Desejo desejo = new Desejo();
            desejo.setNome(cursor.getString(cursor.getColumnIndex(DESEJO_NOME)));
            desejo.setData(cursor.getLong(cursor.getColumnIndex(DESEJO_DATA)));
            desejo.setIdUsuario(cursor.getInt(cursor.getColumnIndex(DESEJO_ID_USUARIO)));
            desejo.setId(cursor.getInt(cursor.getColumnIndex(DESEJO_ID)));

            //Gambiarra!
            Perfil perfil = new Perfil();
            perfil.setFoto("https://pbs.twimg.com/profile_images/726252987/imagem_400x400.JPG");
            perfil.setNome("Raphael Ramos");

            desejo.setPerfil(perfil);
            desejos.add(desejo);
        }
        return desejos;

    }
}
