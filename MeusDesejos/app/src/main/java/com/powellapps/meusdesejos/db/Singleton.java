package com.powellapps.meusdesejos.db;

import com.powellapps.meusdesejos.model.Desejo;

import java.util.ArrayList;

public class Singleton {

    //Cria uma instância única desta classe
    private static Singleton instance;
    //Lista que vocês queiram salvar
    private static ArrayList<Desejo> desejos;

    //Construtor que inicializa o array
    public Singleton(){
        desejos = new ArrayList<>();
    }

    //Método que retonrna a instancia única
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();

        }

        return instance;
    }

    public void add(Desejo desejo){
        this.desejos.add(desejo);
    }

    public ArrayList<Desejo> getDesejos(){
        return desejos;
    }
}
