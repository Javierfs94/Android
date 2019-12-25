package com.example.sieteymedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_sacarCarta;
    Button btn_plantarse;
    Button btn_reinicio;
    ImageView imagen;
    Game game;
    TextView txt_puntos;
    TextView txt_puntosMaquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sacarCarta = (Button)findViewById(R.id.btn_sacarcarta);
        btn_plantarse = (Button)findViewById(R.id.btn_plantarse);
        btn_reinicio = (Button)findViewById(R.id.btn_reinicio);
        imagen = findViewById(R.id.carta);
        txt_puntos = findViewById(R.id.puntos);
        txt_puntosMaquina = findViewById(R.id.puntosMqn);

        game = new Game();
        game.rellenarBaraja();
        game.barajar();
    }


    public void sacaCarta(View v){
        if(game.getEstado() == "iniciado"){
            int carta = game.sacarCarta();

            int identificadorCarta = getResources().getIdentifier("com.example.sieteymedia:drawable/c"+carta, null, null);
            imagen.setImageResource(identificadorCarta);

            game.actualizarPuntuacion(carta);

            if(game.getPuntuacionMaquina() <=7){
                int cartaMqn = game.sacarCarta();
                game.actualizarPuntuacionMaquina(cartaMqn);
            }


            txt_puntos.setText("Puntuación: "+game.getPuntuacion());
            game.compruebaEstado(false);
        }else if(game.getEstado() == "ganado"){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has Ganado, enhorabuena!", Toast.LENGTH_SHORT);
            toast1.show();

            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }else if(game.getEstado() == "empate"){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has empatado, echate otra!", Toast.LENGTH_SHORT);
            toast1.show();
            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }else{
            Toast toast2 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has perdido, echate otra!", Toast.LENGTH_SHORT);
            toast2.show();
            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }

    }
    public void plantarse(View v){
        game.compruebaEstado(true);
        if(game.getEstado() == "ganado"){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has Ganado, enhorabuena!", Toast.LENGTH_SHORT);
            toast1.show();

            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }else if(game.getEstado() == "empate"){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has empatado, echate otra!", Toast.LENGTH_SHORT);
            toast1.show();
            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }else{
            Toast toast2 =
                    Toast.makeText(getApplicationContext(),
                            "¡Has perdido, echate otra!", Toast.LENGTH_SHORT);
            toast2.show();
            txt_puntosMaquina.setText("Puntuación Máquina: "+game.getPuntuacionMaquina());
        }
    }
    public void reiniciar(View v){
        game = new Game();
        game.rellenarBaraja();
        game.barajar();

        Toast toast3 =
                Toast.makeText(getApplicationContext(),
                        "¡Partida Reiniciada!", Toast.LENGTH_SHORT);
        toast3.show();
        txt_puntos.setText("Puntuación: 0");
        txt_puntosMaquina.setText("");
    }
}
