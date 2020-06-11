package com.example.dardos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textPuntos;
    int puntuacion;
    boolean doble = false;
    boolean triple = false;
    int jugadorActivo = 1;
    int puntuacionJugador1 = 351;
    int puntuacionJugador2 = 351;
    int puntuacionJugador3 = 351;
    int puntuacionJugador4 = 351;
    Button buttons[] = new Button[29];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);
        buttons[9] = (Button) findViewById(R.id.button10);
        buttons[10] = (Button) findViewById(R.id.button11);
        buttons[11] = (Button) findViewById(R.id.button12);
        buttons[12] = (Button) findViewById(R.id.button13);
        buttons[13] = (Button) findViewById(R.id.button14);
        buttons[14] = (Button) findViewById(R.id.button15);
        buttons[15] = (Button) findViewById(R.id.button16);
        buttons[16] = (Button) findViewById(R.id.button17);
        buttons[17] = (Button) findViewById(R.id.button18);
        buttons[18] = (Button) findViewById(R.id.button19);
        buttons[19] = (Button) findViewById(R.id.button20);
        buttons[20] = (Button) findViewById(R.id.button25);
        buttons[21] = (Button) findViewById(R.id.button50);
        buttons[22] = (Button) findViewById(R.id.buttonx2);
        buttons[23] = (Button) findViewById(R.id.buttonx3);
        buttons[24] = (Button) findViewById(R.id.buttonP1);
        buttons[25] = (Button) findViewById(R.id.buttonP2);
        buttons[26] = (Button) findViewById(R.id.buttonP3);
        buttons[27] = (Button) findViewById(R.id.buttonP4);
        buttons[28] = (Button) findViewById(R.id.reset);

        buttons[24].setOnClickListener(cambiarJugador);
        buttons[25].setOnClickListener(cambiarJugador);
        buttons[26].setOnClickListener(cambiarJugador);
        buttons[27].setOnClickListener(cambiarJugador);

        for (int i = 0; i < 22; i++) {
            buttons[i].setOnClickListener(calcularPuntos);
        }

        buttons[22].setOnClickListener(multiplicarPuntos);
        buttons[23].setOnClickListener(multiplicarPuntos);
        buttons[28].setOnClickListener(limpiar);

        buttons[24].setBackgroundColor(Color.GREEN);

        textPuntos = (EditText) findViewById(R.id.puntos);
        textPuntos.setEnabled(false);
    }

    private View.OnClickListener calcularPuntos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            puntuacion =  Integer.parseInt(textPuntos.getText().toString());
            int puntos = 0;
            switch(v.getId()){
                case R.id.button1:
                    puntos = 1;
                    break;
                case R.id.button2:
                    puntos = 2;
                    break;
                case R.id.button3:
                    puntos = 3;
                    break;
                case R.id.button4:
                    puntos = 4;
                    break;
                case R.id.button5:
                    puntos = 5;
                    break;
                case R.id.button6:
                    puntos = 6;
                    break;
                case R.id.button7:
                    puntos = 7;
                    break;
                case R.id.button8:
                    puntos = 8;
                    break;
                case R.id.button9:
                    puntos = 9;
                    break;
                case R.id.button10:
                    puntos = 10;
                    break;
                case R.id.button11:
                    puntos = 11;
                    break;
                case R.id.button12:
                    puntos = 12;
                    break;
                case R.id.button13:
                    puntos = 13;
                    break;
                case R.id.button14:
                    puntos = 14;
                    break;
                case R.id.button15:
                    puntos = 15;
                    break;
                case R.id.button16:
                    puntos = 16;
                    break;
                case R.id.button17:
                    puntos = 17;
                    break;
                case R.id.button18:
                    puntos = 18;
                    break;
                case R.id.button19:
                    puntos = 19;
                    break;
                case R.id.button20:
                    puntos = 20;
                    break;
                case R.id.button25:
                    puntos = 25;
                    break;
                case R.id.button50:
                    puntos = 50;
                    break;
            }

            if (doble){
                puntos = puntos * 2;
                doble = false;
                buttons[22].setBackgroundColor(Color.LTGRAY);
            } else if (triple){
                puntos = puntos * 3;
                triple = false;
                buttons[23].setBackgroundColor(Color.LTGRAY);
            }

            if (jugadorActivo == 1){
                puntuacionJugador1 -= puntos;
                textPuntos.setText(String.valueOf(puntuacionJugador1));
            }

            if (jugadorActivo == 2){
                puntuacionJugador2 -= puntos;
                textPuntos.setText(String.valueOf(puntuacionJugador2));
            }

            if (jugadorActivo == 3){
                puntuacionJugador3 -= puntos;
                textPuntos.setText(String.valueOf(puntuacionJugador3));
            }

            if (jugadorActivo == 4){
                puntuacionJugador4 -= puntos;
                textPuntos.setText(String.valueOf(puntuacionJugador4));
            }

            if (puntuacionJugador1 < 0 || puntuacionJugador2 < 0 || puntuacionJugador3 < 0 || puntuacionJugador4 < 0){
                lanzar();
            }
        }
    };

    private void lanzar() {
        startActivity(new Intent(this, Victory.class));
    }

    private View.OnClickListener multiplicarPuntos = new View.OnClickListener() {
       @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonx2:
                    doble = true;
                    buttons[22].setBackgroundColor(Color.RED);
                    break;
                case R.id.buttonx3:
                    triple = true;
                    buttons[23].setBackgroundColor(Color.RED);
                    break;
            }
        }
    };

    private View.OnClickListener cambiarJugador = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonP1:
                    jugadorActivo = 1;
                    textPuntos.setText(String.valueOf(puntuacionJugador1));
                    buttons[24].setBackgroundColor(Color.GREEN);
                    buttons[25].setBackgroundColor(Color.LTGRAY);
                    buttons[26].setBackgroundColor(Color.LTGRAY);
                    buttons[27].setBackgroundColor(Color.LTGRAY);
                    break;
                case R.id.buttonP2:
                    jugadorActivo = 2;
                    textPuntos.setText(String.valueOf(puntuacionJugador2));
                    buttons[24].setBackgroundColor(Color.LTGRAY);
                    buttons[25].setBackgroundColor(Color.GREEN);
                    buttons[26].setBackgroundColor(Color.LTGRAY);
                    buttons[27].setBackgroundColor(Color.LTGRAY);
                    break;
                case R.id.buttonP3:
                    jugadorActivo = 3;
                    textPuntos.setText(String.valueOf(puntuacionJugador3));
                    buttons[24].setBackgroundColor(Color.LTGRAY);
                    buttons[25].setBackgroundColor(Color.LTGRAY);
                    buttons[26].setBackgroundColor(Color.GREEN);
                    buttons[27].setBackgroundColor(Color.LTGRAY);
                    break;
                case R.id.buttonP4:
                    jugadorActivo = 4;
                    textPuntos.setText(String.valueOf(puntuacionJugador4));
                    buttons[24].setBackgroundColor(Color.LTGRAY);
                    buttons[25].setBackgroundColor(Color.LTGRAY);
                    buttons[26].setBackgroundColor(Color.LTGRAY);
                    buttons[27].setBackgroundColor(Color.GREEN);
                    break;
            }
        }
    };

    private View.OnClickListener limpiar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            puntuacionJugador1 = 351;
            puntuacionJugador2 = 351;
            puntuacionJugador3 = 351;
            puntuacionJugador4 = 351;
            textPuntos.setText(String.valueOf(puntuacionJugador1));
            textPuntos.setText(String.valueOf(puntuacionJugador2));
            textPuntos.setText(String.valueOf(puntuacionJugador3));
            textPuntos.setText(String.valueOf(puntuacionJugador4));
        }
    };
}


