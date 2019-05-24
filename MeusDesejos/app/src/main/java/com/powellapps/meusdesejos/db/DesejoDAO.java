package com.powellapps.meusdesejos.db;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.powellapps.meusdesejos.model.Desejo;
import com.powellapps.meusdesejos.model.Perfil;

import java.util.ArrayList;

public class DesejoDAO extends DbHelper{

    public DesejoDAO(Context applicationContext) {
        super(applicationContext);
    }

    public void salvar(Desejo desejo) {
        if(desejo.getId() == null){
            getWritableDatabase().insert(NOME_TABELA_DESEJO, null, desejo.getValues());
        }else{
            getWritableDatabase().update(NOME_TABELA_DESEJO, desejo.getValues(), "ID = ?", new String[] {desejo.getId().toString()});
        }
    }

    public ArrayList<Desejo> retornaLista() {

        ArrayList<Desejo> desejos = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(NOME_TABELA_DESEJO, null, null, null, null,null,null);

        while (cursor.moveToNext()){
            desejos.add(montaDesejo(cursor));
        }
        return desejos;

    }

    private Desejo montaDesejo(Cursor cursor) {
        Desejo desejo = new Desejo();
        desejo.setNome(cursor.getString(cursor.getColumnIndex(DESEJO_NOME)));
        desejo.setData(cursor.getLong(cursor.getColumnIndex(DESEJO_DATA)));
        desejo.setIdUsuario(cursor.getInt(cursor.getColumnIndex(DESEJO_ID_USUARIO)));
        desejo.setId(cursor.getInt(cursor.getColumnIndex(DESEJO_ID)));
        desejo.setEstado(cursor.getInt(cursor.getColumnIndex(DESEJO_ESTADO)));
        desejo.setPrioridade(cursor.getInt(cursor.getColumnIndex(DESEJO_PRIORIDADE)));

        //Gambiarra!
        Perfil perfil = new Perfil();
        perfil.setFoto("https://pbs.twimg.com/profile_images/726252987/imagem_400x400.JPG");
        perfil.setNome("Raphael Ramos");

        desejo.setPerfil(perfil);
        return desejo;
    }

    public ArrayList<Desejo> retornaDesejos(Integer estado){
        ArrayList<Desejo> desejos = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(NOME_TABELA_DESEJO, null, DESEJO_ESTADO + " = ?", new String[] {estado.toString()}, null,null,null);
        while (cursor.moveToNext()){
            desejos.add(montaDesejo(cursor));
        }
        return desejos;
    }

    public ArrayList<Desejo> retornaAtivos() {
        return retornaDesejos(0);
    }

    public ArrayList<Desejo> retornaRealizados() {
        return retornaDesejos(1);
    }

    public ArrayList<Desejo> retornaCancelados() {
        return retornaDesejos(2);
    }

    public ArrayList<Desejo> retornaLista(int position) {
        return retornaDesejos(position);
    }
}
