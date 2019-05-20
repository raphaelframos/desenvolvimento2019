package com.powellapps.meusdesejos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.powellapps.meusdesejos.fragments.FeedFragment;
import com.powellapps.meusdesejos.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_desejos:
                    infla(new FeedFragment(), "feed");
                    return true;
                case R.id.navigation_perfil:
                    infla(new PerfilFragment(), "desejos");
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        infla(new FeedFragment(), "desejos");


    }

    public void infla(Fragment fragmento, String tag){
        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout_main, fragmento, tag).commit();
    }

    @Override
    public void onBackPressed() {

        /*
        DesejoFragment fragment = (DesejoFragment) getSupportFragmentManager().findFragmentByTag("desejos");
        if(fragment != null && fragment.isVisible()){
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setTitle("Atenção!").setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("Não", null).setMessage("Deseja sair do aplicativo?").show();

        }else{
            navigation.setSelectedItemId(R.id.navigation_desejos);

        }
        */
    }
}
