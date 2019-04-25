package com.powellapps.meusdesejos.model;

import java.util.Calendar;

public class Desejo {

    private String nome;
    private String data;

    public Desejo(String nome) {
        setNome(nome);
        Calendar dataDeHoje = Calendar.getInstance();
        setData(dataDeHoje.getTime().toString());
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
}
