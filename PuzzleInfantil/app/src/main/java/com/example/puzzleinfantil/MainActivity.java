package com.example.puzzleinfantil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> piezasIzquierda = new ArrayList<String>();
    ArrayList<String> piezasCentrales = new ArrayList<String>();
    ArrayList<String> piezasDerecha = new ArrayList<String>();

    Button botonIzquierda;
    Button botonCentro ;
    Button botonDerecha;

    String pieza1;
    String pieza2;
    String pieza3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIzquierda = (Button) findViewById(R.id.buttonIzquierda);
        botonCentro = (Button) findViewById(R.id.buttonCentro);
        botonDerecha = (Button) findViewById(R.id.buttonDerecha);

        Field[] drawablesFields = com.example.puzzleinfantil.R.drawable.class.getFields();

        for (Field field : drawablesFields) {
            try {
               String[] cadenas = field.getName().split("_");
                if (cadenas[0].equals("puzzle")){
                    if (cadenas[2].equals("1")){
                        piezasIzquierda.add(field.getName());
                    }
                    if (cadenas[2].equals("2")){
                        piezasCentrales.add(field.getName());
                    }
                    if (cadenas[2].equals("3")){
                        piezasDerecha.add(field.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inicializarPiezas(piezasIzquierda, piezasCentrales, piezasDerecha);

        botonIzquierda.setOnClickListener(clickPieza);
        botonCentro.setOnClickListener(clickPieza);
        botonDerecha.setOnClickListener(clickPieza);
    }

    private View.OnClickListener clickPieza = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonIzquierda:
                    cambiarPieza(piezasIzquierda, botonIzquierda, 1);
                    break;
                case R.id.buttonCentro:
                    cambiarPieza(piezasCentrales, botonCentro, 2);
                    break;
                case R.id.buttonDerecha:
                    cambiarPieza(piezasDerecha, botonDerecha, 3);
                    break;
            }
            comprobarVictoria();
        }
    };

    private void comprobarVictoria() {
        if (pieza1.split("_")[1].equals(pieza2.split("_")[1]) && pieza1.split("_")[1].equals(pieza3.split("_")[1])) {
            startActivity(new Intent(this, Victory.class ));
        }
    }

    private void cambiarPieza(ArrayList<String> piezas, Button boton, int posicion){
        int indice = 0;
        int resID = 0;
        switch(posicion) {
            case 1:
                indice = piezas.indexOf(pieza1);
                if (indice == (piezas.size()-1)){
                    pieza1 = piezas.get(0);
                    resID = getResources().getIdentifier(pieza1 , "drawable", getPackageName());
                }else {
                    pieza1 = piezas.get(indice + 1);
                    resID = getResources().getIdentifier(pieza1 , "drawable", getPackageName());
                }
                break;
            case 2:
                indice = piezas.indexOf(pieza2);
                if (indice == (piezas.size()-1)){
                    pieza2 = piezas.get(0);
                    resID = getResources().getIdentifier(pieza2 , "drawable", getPackageName());
                }else {
                    pieza2 = piezas.get(indice + 1);
                    resID = getResources().getIdentifier(pieza2 , "drawable", getPackageName());
                }
                break;
            case 3:
                indice = piezas.indexOf(pieza3);
                if (indice == (piezas.size()-1)){
                    pieza3 = piezas.get(0);
                    resID = getResources().getIdentifier(pieza3 , "drawable", getPackageName());
                }else {
                    pieza3 = piezas.get(indice + 1);
                    resID = getResources().getIdentifier(pieza3 , "drawable", getPackageName());
                }
                break;
        }

        boton.setBackgroundResource(resID);

    }

    private void inicializarPiezas(ArrayList<String> piezasIzquierda, ArrayList<String> piezasCentro, ArrayList<String> piezasDerecha ){
        Random random = new Random();
        pieza1 = piezasIzquierda.get(random.nextInt(piezasIzquierda.size()));
        pieza2 = piezasCentro.get(random.nextInt(piezasCentro.size()));
        pieza3 = piezasDerecha.get(random.nextInt(piezasDerecha.size()));

        botonIzquierda.setBackgroundResource(getResources().getIdentifier(pieza1, "drawable", getPackageName()));
        botonCentro.setBackgroundResource(getResources().getIdentifier(pieza2, "drawable", getPackageName()));
        botonDerecha.setBackgroundResource(getResources().getIdentifier(pieza3, "drawable", getPackageName()));

    }

}
