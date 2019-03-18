package com.powellapps.aulaum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    //Declaração da variável to tipo Button, que chamado de buttonTrocaActivity. Essa variável que vamos usar para referenciar ao botão criado no xml
    private Button buttonTrocaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Método que vincula o xml a variável java.
        buttonTrocaActivity = findViewById(R.id.button_troca_tela);

        //método de click do botão. Melhor caminho é utilizar o control + espaço depois do new View.OnClickListener
        buttonTrocaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ação para trocar de tela
                Intent trocaDeTela = new Intent(SegundaActivity.this, TerceiraActivity.class);
                startActivity(trocaDeTela);
            }
        });


    }
}
