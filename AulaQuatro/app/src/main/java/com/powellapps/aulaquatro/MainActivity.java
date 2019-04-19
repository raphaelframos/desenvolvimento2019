package com.powellapps.aulaquatro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.powellapps.aulaquatro.adapter.AdapterJogador;
import com.powellapps.aulaquatro.model.Jogador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewJogadores = findViewById(R.id.recycler_jogadores);
        recyclerViewJogadores.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Jogador> jogadores = new ArrayList<>();
        Jogador jogador1 = new Jogador();
        jogador1.setNome("Obina");
        jogador1.setTime("Flamengo");

        jogadores.add(jogador1);

        Jogador jogador2 = new Jogador();
        jogador2.setTime("Flamengo");
        jogador2.setNome("Marcio Araujo");

        jogadores.add(jogador2);
        jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);jogadores.add(jogador2);

        recyclerViewJogadores.setAdapter(new AdapterJogador(jogadores));
        recyclerViewJogadores.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }













    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_sair:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
