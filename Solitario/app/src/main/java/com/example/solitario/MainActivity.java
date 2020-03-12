package com.example.solitario;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Game game;
    private int contador = 0;
    TextView contadorJugadas;

    private final int ids[][] = {
            {R.id.f0c0button, R.id.f0c1button, R.id.f0c2button},
            {R.id.f1c0button, R.id.f1c1button, R.id.f1c2button},
            {R.id.f2c0button, R.id.f2c1button, R.id.f2c2button},
            {R.id.f3c0button, R.id.f3c1button, R.id.f3c2button},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

    }

    public void pulsado(View v){
        contador++;
        contadorJugadas = (TextView) findViewById(R.id.cantidadJugadas);
        contadorJugadas.setText(Integer.toString(contador));
    }




    }

