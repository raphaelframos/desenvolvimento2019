package com.powellapps.aulaum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Cria classe que será nossa activity, não esquecer de colocar a primeira letra maiúscula. Case camel.
public class PrimeiraActivity extends AppCompatActivity {

    //Método mais importante da nossa activity. Aqui é onde tudo acontece.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Método que mostra o xml na tela.
        setContentView(R.layout.activity_primeira);

        //Declara a intenção de mudar de tela
        Intent trocaDeTela = new Intent(this, SegundaActivity.class);
        //Método que faz a troca de activity
        startActivity(trocaDeTela);
    }
}
