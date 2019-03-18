package com.powellapps.aulaum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TerceiraActivity extends AppCompatActivity {

    //Variável do tipo TextView
    private TextView textViewResultado;
    private Button buttonTrocaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        //Vinculando xml ao java
        textViewResultado = findViewById(R.id.textView_resultado);
        buttonTrocaTexto = findViewById(R.id.button_trocar_texto);

        buttonTrocaTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setText mostra um texto na tela.
                textViewResultado.setText("Flamengo minha vida, flamengo minha história, flamengo meu amor.");
            }
        });
    }
}
