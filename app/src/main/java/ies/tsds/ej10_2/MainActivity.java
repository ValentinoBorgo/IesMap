package ies.tsds.ej10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }

    private void accionBotonSalir() {
        finish();
    }
}