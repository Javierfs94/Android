package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView vText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonSuma= (Button)findViewById(R.id.botonSuma);
        botonSuma.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                EditText edit1 = (EditText)findViewById(R.id.edit1);
                EditText edit2 = (EditText)findViewById(R.id.edit2);
                TextView resultado = (TextView)findViewById(R.id.text4);

                double num1= Double.parseDouble(edit1.getText().toString());
                double num2= Double.parseDouble(edit2.getText().toString());

                try {
                    resultado.setText(String.valueOf(num1 + num2));
                }
                catch(Exception e){
                }
            }
        });

        Button botonResta = (Button)findViewById(R.id.botonResta);
        botonResta.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                EditText edit1 = (EditText)findViewById(R.id.edit1);
                EditText edit2 = (EditText)findViewById(R.id.edit2);
                TextView resultado = (TextView)findViewById(R.id.text4);

                double num1= Double.parseDouble(edit1.getText().toString());
                double num2= Double.parseDouble(edit2.getText().toString());

                resultado.setText(String.valueOf(num1-num2));
            }
        });

        Button botonMult = (Button)findViewById(R.id.botonMultiplicar);
        botonMult.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                EditText edit1 = (EditText)findViewById(R.id.edit1);
                EditText edit2 = (EditText)findViewById(R.id.edit2);
                TextView resultado = (TextView)findViewById(R.id.text4);

                double num1= Double.parseDouble(edit1.getText().toString());
                double num2= Double.parseDouble(edit2.getText().toString());

                resultado.setText(String.valueOf(num1*num2));
            }
        });

        Button botonDividir = (Button)findViewById(R.id.botonDividir);
        botonDividir.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                EditText edit1 = (EditText)findViewById(R.id.edit1);
                EditText edit2 = (EditText)findViewById(R.id.edit2);
                TextView resultado = (TextView)findViewById(R.id.text4);

                double num1= Double.parseDouble(edit1.getText().toString());
                double num2= Double.parseDouble(edit2.getText().toString());

                resultado.setText(String.valueOf(num1/num2));

            }
        });



    }
}
