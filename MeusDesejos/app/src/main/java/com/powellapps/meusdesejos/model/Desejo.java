package com.powellapps.meusdesejos.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Desejo {

    private String nome;
    private String data;
    private Perfil perfil;

    public Desejo(String nome) {
        setNome(nome);
        Calendar dataDeHoje = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
        setData(format.format(dataDeHoje.getTime()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
