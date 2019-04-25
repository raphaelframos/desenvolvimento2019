package com.powellapps.meusdesejos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.powellapps.meusdesejos.db.Singleton;
import com.powellapps.meusdesejos.model.Desejo;

public class NovoDesejoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_desejo);

        final EditText editTextNome = findViewById(R.id.editText_nome);
        Button buttonSalvar = findViewById(R.id.button_salvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                Desejo desejo = new Desejo(nome);
                Singleton.getInstance().add(desejo);
                finish();
            }
        });
    }
}
