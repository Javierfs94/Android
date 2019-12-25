package com.example.mmemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Juego extends Activity {

    ImageButton boton00, boton01, boton02, boton03, boton04,boton05, boton06, boton07, boton08,boton09,boton10, boton11,boton12,boton13,boton14,
            boton15,boton16, boton17,boton18,boton19, boton20,boton21,boton22,boton23,boton24,boton25,boton26,boton27,boton28,boton29, boton30, boton31;

    int imagenes[];
    ImageButton [] botonera = new ImageButton[32];
    Button reiniciar, salir;

    int fondo;

    ArrayList<Integer> arrayBarajado;

    ImageButton primero;
    int numeroPrimero, numeroSegundo;
    boolean bloqueo = false;

    final Handler handler = new Handler();

    int aciertos=0;
    int puntuacion=0;
    TextView textoPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        cargarImagenes();
        iniciar();
    }

    public void cargarImagenes(){
        imagenes = new int[]{
                R.drawable.ficha1,
                R.drawable.ficha2,
                R.drawable.ficha3,
                R.drawable.ficha4,
                R.drawable.ficha5,
                R.drawable.ficha6,
                R.drawable.ficha7,
                R.drawable.ficha8,
                R.drawable.ficha9,
                R.drawable.ficha10,
                R.drawable.ficha11,
                R.drawable.ficha12,
                R.drawable.ficha13,
                R.drawable.ficha14,
                R.drawable.ficha15,
                R.drawable.ficha16,
        };
        fondo = R.drawable.fondo;
    }

    public ArrayList<Integer> mezclar(int longitud) {
        ArrayList arrayParaMezclar = new ArrayList<Integer>();
        for (int i = 0; i < longitud; i++)
            arrayParaMezclar.add(i % longitud / 2);
        Collections.shuffle(arrayParaMezclar);
        return arrayParaMezclar;
    }


    public void cargarBotones(){
        boton00 = (ImageButton) findViewById(R.id.boton00);
        botonera[0] = boton00;
        boton01 = (ImageButton) findViewById(R.id.boton01);
        botonera[1] = boton01;
        boton02 = (ImageButton) findViewById(R.id.boton02);
        botonera[2] = boton02;
        boton03 = (ImageButton) findViewById(R.id.boton03);
        botonera[3] = boton03;
        boton04 = (ImageButton) findViewById(R.id.boton04);
        botonera[4] = boton04;
        boton05 = (ImageButton) findViewById(R.id.boton05);
        botonera[5] = boton05;
        boton06 = (ImageButton) findViewById(R.id.boton06);
        botonera[6] = boton06;
        boton07 = (ImageButton) findViewById(R.id.boton07);
        botonera[7] = boton07;
        boton08 = (ImageButton) findViewById(R.id.boton08);
        botonera[8] = boton08;
        boton09 = (ImageButton) findViewById(R.id.boton09);
        botonera[9] = boton09;
        boton10 = (ImageButton) findViewById(R.id.boton10);
        botonera[10] = boton10;
        boton11 = (ImageButton) findViewById(R.id.boton11);
        botonera[11] = boton11;
        boton12 = (ImageButton) findViewById(R.id.boton12);
        botonera[12] = boton12;
        boton13 = (ImageButton) findViewById(R.id.boton13);
        botonera[13] = boton13;
        boton14 = (ImageButton) findViewById(R.id.boton14);
        botonera[14] = boton14;
        boton15 = (ImageButton) findViewById(R.id.boton15);
        botonera[15] = boton15;
        boton16 = (ImageButton) findViewById(R.id.boton16);
        botonera[16] = boton16;
        boton17 = (ImageButton) findViewById(R.id.boton17);
        botonera[17] = boton17;
        boton18 = (ImageButton) findViewById(R.id.boton18);
        botonera[18] = boton18;
        boton19 = (ImageButton) findViewById(R.id.boton19);
        botonera[19] = boton19;
        boton20 = (ImageButton) findViewById(R.id.boton20);
        botonera[20] = boton20;
        boton21 = (ImageButton) findViewById(R.id.boton21);
        botonera[21] = boton21;
        boton22 = (ImageButton) findViewById(R.id.boton22);
        botonera[22] = boton22;
        boton23 = (ImageButton) findViewById(R.id.boton23);
        botonera[23] = boton23;
        boton24 = (ImageButton) findViewById(R.id.boton24);
        botonera[24] = boton24;
        boton25 = (ImageButton) findViewById(R.id.boton25);
        botonera[25] = boton25;
        boton26 = (ImageButton) findViewById(R.id.boton26);
        botonera[26] = boton26;
        boton27 = (ImageButton) findViewById(R.id.boton27);
        botonera[27] = boton27;
        boton28 = (ImageButton) findViewById(R.id.boton28);
        botonera[28] = boton28;
        boton29 = (ImageButton) findViewById(R.id.boton29);
        botonera[29] = boton29;
        boton30 = (ImageButton) findViewById(R.id.boton30);
        botonera[30] = boton30;
        boton31 = (ImageButton) findViewById(R.id.boton31);
        botonera[31] = boton31;

        textoPuntuacion = (TextView)findViewById(R.id.textoPuntuacion);
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

    public void botonesMenu(){
        reiniciar = (Button) findViewById(R.id.Reiniciar);
        salir = (Button) findViewById(R.id.Salir);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){

            primero = imgb;

            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);

            primero.setEnabled(false);

            numeroPrimero=arrayBarajado.get(i);
        }else{

            bloqueo=true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            imgb.setEnabled(false);
            numeroSegundo=arrayBarajado.get(i);
            if(numeroPrimero==numeroSegundo){

                primero=null;
                bloqueo=false;

                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);

                if(aciertos==8){
                    Toast toast = Toast.makeText(getApplicationContext(), "Has ganado!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.fondo);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(R.drawable.fondo);

                        primero.setEnabled(true);
                        imgb.setEnabled(true);

                        primero = null;
                        bloqueo = false;

                        if (puntuacion > 0) {
                            puntuacion--;
                            textoPuntuacion.setText("Puntuación: " + puntuacion);
                        }
                    }
                }, 1000);//al cabo de un segundo
            }
        }

    }

    public void iniciar(){
        arrayBarajado = mezclar(imagenes.length*2);
        cargarBotones();

        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        puntuacion=0;
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

}
