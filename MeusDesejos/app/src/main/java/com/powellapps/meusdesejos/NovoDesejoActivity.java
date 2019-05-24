package com.powellapps.meusdesejos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.powellapps.meusdesejos.adapter.AdapterDesejos;
import com.powellapps.meusdesejos.db.DesejoDAO;
import com.powellapps.meusdesejos.model.Desejo;

public class NovoDesejoActivity extends AppCompatActivity {

    private Desejo desejo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_desejo);

        final EditText editTextNome = findViewById(R.id.editText_nome);
        final Spinner spinnerPrioridade = findViewById(R.id.spinner_prioridade);
        final Spinner spinnerEstado = findViewById(R.id.spinner_estado);
        Button buttonSalvar = findViewById(R.id.button_salvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                desejo.setNome(nome);
                desejo.setPrioridade(spinnerPrioridade.getSelectedItemPosition());
                desejo.setEstado(spinnerEstado.getSelectedItemPosition());
                new DesejoDAO(getApplicationContext()).salvar(desejo);
               // Singleton.getInstance().add(desejo);
                finish();
            }
        });

        desejo = (Desejo) getIntent().getSerializableExtra(AdapterDesejos.DESEJO);
        try{
            if(desejo == null){
                desejo = new Desejo();
            }else{
                editTextNome.setText(desejo.getNome());
                spinnerEstado.setSelection(desejo.getEstado());
                spinnerPrioridade.setSelection(desejo.getPrioridade());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
