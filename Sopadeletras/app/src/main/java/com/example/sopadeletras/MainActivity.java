package com.example.sopadeletras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String URL = "http://192.168.1.58/json.php"; // La IP puede variar. Se necesita XAMP con servidor Apache y MySQL funcionando (Servicios ON). Además la MV y el Móvil donde se ejecuta la App deben estar en la misma red.

    private final int imgsIDs[][] = {
            {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9, R.id.img10},
            { R.id.img11,R.id.img12,R.id.img13,R.id.img14,R.id.img15,R.id.img16,R.id.img17,R.id.img18,R.id.img19,R.id.img20},
            { R.id.img21,R.id.img22,R.id.img23,R.id.img24,R.id.img25,R.id.img26,R.id.img27,R.id.img28,R.id.img29,R.id.img30},
            { R.id.img31,R.id.img32,R.id.img33,R.id.img34,R.id.img35,R.id.img36,R.id.img37,R.id.img38,R.id.img39,R.id.img40},
            { R.id.img41,R.id.img42,R.id.img43,R.id.img44,R.id.img45,R.id.img46,R.id.img47,R.id.img48,R.id.img49,R.id.img50},
            { R.id.img51,R.id.img52,R.id.img53,R.id.img54,R.id.img55,R.id.img56,R.id.img57,R.id.img58,R.id.img59,R.id.img60},
            { R.id.img61,R.id.img62,R.id.img63,R.id.img64,R.id.img65,R.id.img66,R.id.img67,R.id.img68,R.id.img69,R.id.img70},
            { R.id.img71,R.id.img72,R.id.img73,R.id.img74,R.id.img75,R.id.img76,R.id.img77,R.id.img78,R.id.img79,R.id.img80},
            { R.id.img81,R.id.img82,R.id.img83,R.id.img84,R.id.img85,R.id.img86,R.id.img87,R.id.img88,R.id.img89,R.id.img90},
            { R.id.img91,R.id.img92,R.id.img93,R.id.img94,R.id.img95,R.id.img96,R.id.img97,R.id.img98,R.id.img99,R.id.img100}
    };

    private final int letras[] = {
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,
            R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,
            R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,
            R.drawable.y,R.drawable.z};

    private String[] arrayLetras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private Juego game;

    RequestQueue queue;

    boolean pulsado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String respuesta = response.replaceAll("\\[", "");
                respuesta = respuesta.replaceAll("\\]", "");
                respuesta = respuesta.replaceAll("\"", "");
                Palabra.setArrayPalabras(respuesta);
                iniciarJuego();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });
        queue.add(request);
    }


    private int convertirLetraAIndice(String letter){
        for(int i = 0; i < arrayLetras.length; i++){
            letter = letter.replaceAll("\\*", "");
            if(letter.equals(arrayLetras[i])){
                return i;
            }
        }
        return 0;
    }

    private void iniciarJuego(){
        game = new Juego();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(game.getTablero().get(i).get(j) == "#"){
                    Random r = new Random();
                    ImageView img= (ImageView) findViewById(imgsIDs[i][j]);
                    img.setImageResource(letras[r.nextInt(26)]);
                }else{
                    ImageView img= (ImageView) findViewById(imgsIDs[i][j]);
                    img.setImageResource(letras[convertirLetraAIndice(game.getTablero().get(i).get(j))]);
                }
            }
        }
    }

     public void clickLetra(View v){
        if(game.aciertos >0){
            for(int i = 0; i < imgsIDs.length; i++){
                for(int j = 0; j < imgsIDs[i].length; j++){
                    if(v.getId() == imgsIDs[i][j]){
                        if(pulsado){
                            if(game.comprobarSeleccion(i, j)){
                                actualizarVista();
                                if(game.aciertos == 0){
                                    startActivity(new Intent(this, Victory.class));
                                }
                            }
                        }else{
                            pulsado = true;
                            game.setAlmacenado(i, j);
                        }
                    }
                }
            }
        }
    }

    private void actualizarVista(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(game.getTablero().get(i).get(j).length() >1){
                    ImageView img = (ImageView) findViewById(imgsIDs[i][j]);
                    img.setImageResource(0);

                }
            }
        }
    }
}
