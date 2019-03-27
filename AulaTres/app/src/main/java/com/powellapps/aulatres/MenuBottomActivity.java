package com.powellapps.aulatres;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuBottomActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    trocaFragmento(new PerfilFragment());
                    return true;
                case R.id.navigation_dashboard:
                    trocaFragmento(new NoticiasFragment());
                        return true;
                case R.id.navigation_notifications:
                    trocaFragmento(new NoticiasFragment());
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bottom);

        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        trocaFragmento(new PerfilFragment());

    }

    private void trocaFragmento(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout_raiz, fragment).commit();

    }

}
