package com.powellapps.auladois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarei variáveis
    private Button buttonPegaNome;
    private TextView textResultado;
    private EditText editTextNome;
    private Button buttonPegaIdade;
    private EditText editTextIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_aula_2);

        //Vinculei ao xml
        textResultado =  findViewById(R.id.textView_resultado);
        editTextNome = findViewById(R.id.editText_nome);
        buttonPegaNome = findViewById(R.id.button_pega_nome);
        buttonPegaIdade = findViewById(R.id.button_pega_idade);
        editTextIdade = findViewById(R.id.editText_idade);

        //Implementação do click
        buttonPegaNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pego o valor do editText e atribuo a uma variável chamada nome
                String nome = editTextNome.getText().toString();
                //Mostra a variável nome no textView
                textResultado.setText(nome);
            }
        });

        buttonPegaIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pego o texto do editText idade
                String valorDoCampoIdade = editTextIdade.getText().toString();
                //Vejo se a variável está em branco
                if(valorDoCampoIdade.isEmpty()){
                    //mostra uma mensagem na tela
                    Toast.makeText(getApplicationContext(), "Você não nasceu!", Toast.LENGTH_LONG).show();
                }else{
                    //Faço uma conversão de string em inteiro
                    int idade = Integer.parseInt(valorDoCampoIdade);

                    //Valido idade
                    if(idade >= 18) {
                        textResultado.setText(valorDoCampoIdade);
                    }else{
                        Toast.makeText(getApplicationContext(), "Você é menor de idade!", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });


    }
}
