package ies.tsds.ej10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ies.tsds.ej10_2.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activarBotones();
    }

    private void activarBotones() {
        Button btSalir = (Button) findViewById(R.id.btSalir);
        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionBotonSalir();
            }
        });
        Button btUsuarioRegristrado = (Button) findViewById(R.id.btUsuarioRegistrado);
        btUsuarioRegristrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionBotonUsuarioRegistrado();
            }
        });
   }

    private void accionBotonUsuarioRegistrado() {
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);
    }


    private void accionBotonSalir() {
        finish();
    }
}
