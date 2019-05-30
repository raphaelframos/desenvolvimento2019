package com.powellapps.meusdesejos;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.powellapps.meusdesejos.adapter.AdapterDesejos;
import com.powellapps.meusdesejos.db.DesejoDAO;
import com.powellapps.meusdesejos.model.Desejo;

public class NovoDesejoActivity extends AppCompatActivity {

    private Desejo desejo;
    private boolean novoDesejo = true;
    private DesejoDAO desejoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_desejo);

        final EditText editTextNome = findViewById(R.id.editText_nome);
        final Spinner spinnerPrioridade = findViewById(R.id.spinner_prioridade);
        final Spinner spinnerEstado = findViewById(R.id.spinner_estado);
        Button buttonSalvar = findViewById(R.id.button_salvar);

        desejoDao = new DesejoDAO(getApplicationContext());

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                desejo.setNome(nome);
                desejo.setPrioridade(spinnerPrioridade.getSelectedItemPosition());
                desejo.setEstado(spinnerEstado.getSelectedItemPosition());

                desejoDao.salvar(desejo);
                finish();
            }
        });

        desejo = (Desejo) getIntent().getSerializableExtra(AdapterDesejos.DESEJO);
        try{
            if(isNew()){
                desejo = new Desejo();
            }else{
                TextView textViewMensagem = findViewById(R.id.textView_mensagem_novo_desejo);
                novoDesejo = false;
                editTextNome.setText(desejo.getNome());
                spinnerEstado.setSelection(desejo.getEstado());
                spinnerPrioridade.setSelection(desejo.getPrioridade());
                textViewMensagem.setText("Editando o desejo" + " " + desejo.getNome());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!novoDesejo) {
            getMenuInflater().inflate(R.menu.novo_desejo, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    private boolean isNew() {
        return desejo == null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_excluir:
                AlertDialog.Builder alerta = new AlertDialog.Builder(NovoDesejoActivity.this);
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        desejoDao.remove(desejo.getId());
                        finish();
                    }
                }).setNegativeButton("Não", null).setMessage("Deseja remover o desejo " + desejo.getNome()).setTitle("Atenção").show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
