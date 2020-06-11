package com.example.sopadeletras;

import android.util.Log;

import java.util.ArrayList;

public class Juego {

    private ArrayList<ArrayList<String>> tablero;
    private int ancho = 10;
    private int alto = 10;

    private int xAlmacenada;
    private int yAlmacenada;

    public int aciertos = 5;

    private ArrayList<Palabra> arrayPalabras = new ArrayList<>();

    public Juego(){
        tablero = new ArrayList<ArrayList<String>>();
        for(int i = 0; i<this.alto; i++){
            this.tablero.add(new ArrayList<String>());
            for(int j = 0; j<this.ancho; j++){
                this.tablero.get(i).add("#");

            }
        }
        generarTablero();
    }

    private void generarTablero(){
        boolean noValido;
        int contador = 5;
        ArrayList<String> arrayPalabrasRepetidas = new ArrayList<String>();
        arrayPalabrasRepetidas.add("EJEMPLO");
        do{
            Palabra palabra;
            do{
                noValido = false;

                palabra = new Palabra();

                for(String pal : arrayPalabrasRepetidas){
                    if(pal == palabra.palabra){
                        noValido = true;
                    }
                }

                if(!noValido){
                    for(int i = 0; i< palabra.palabraArray.length; i++){
                        if(palabra.x < 0 || palabra.y <0 || palabra.x>=alto || palabra.y>=ancho){
                            noValido = true;
                        }else{
                            if(this.tablero.get(palabra.x).get(palabra.y) != "#"){
                                if(this.tablero.get(palabra.x).get(palabra.y) != palabra.palabraArray[i]){
                                    noValido = true;
                                }
                            }
                        }
                        palabra.calculaDireccion();
                    }
                }
            }while(noValido);
            arrayPalabrasRepetidas.add(palabra.palabra);
            actualizarTablero(palabra);
            contador--;
        }while(contador != 0);
    }

    private void actualizarTablero(Palabra palabra){
        palabra.revertirPalabra();
        Log.d("palabra", "palabra: "+palabra.palabra);
        for(int i = 0; i< palabra.palabraArray.length; i++){
            Log.d("palabra", "X: "+palabra.x+" Y: "+palabra.y);
            this.tablero.get(palabra.x).set(palabra.y, palabra.palabraArray[i]);
            palabra.calculaDireccion();
        }
        palabra.retrocederDir();
        this.arrayPalabras.add(palabra);
    }

    private void actualizarTableroEncontrado(Palabra palabra){
        palabra.revertirPalabra();
        for(int i = 0; i< palabra.palabraArray.length; i++){
            this.tablero.get(palabra.x).set(palabra.y, palabra.palabraArray[i]+"*");
            palabra.calculaDireccion();
        }
        this.aciertos--;
    }

    public void setAlmacenado(int x, int y){
        this.xAlmacenada = x;
        this.yAlmacenada = y;

    }

    public boolean comprobarSeleccion(int x, int y){
        if(x != this.xAlmacenada || y != this.yAlmacenada){
            Palabra palabraCoincidente = new Palabra();
            boolean encontrado = false;
            for(Palabra palabra: this.arrayPalabras){
                Log.d("contador", "Palabra1: "+palabra.palabra);
                Log.d("contador", "xAlm: "+this.xAlmacenada+" yAlm: "+this.yAlmacenada);
                Log.d("contador", "PalabraXInc: "+palabra.xInicial+" PalabraYInc: "+palabra.yInicial);
                Log.d("contador", "PalabraX: "+palabra.x+" PalabraY: "+palabra.y);

                if(palabra.xInicial == this.xAlmacenada){
                    if(palabra.yInicial == this.yAlmacenada){
                        palabraCoincidente = palabra;
                        encontrado = true;
                        Log.d("contador", "Palabra encontrada");
                    }
                }
                if(palabra.x == this.xAlmacenada){
                    if(palabra.y == this.yAlmacenada){
                        palabraCoincidente = palabra;
                        encontrado = true;
                        Log.d("contador", "Palabra encontrada");
                    }
                }
            }

            if(encontrado){
                Log.d("contador", "hola");
                for(Palabra palabra: this.arrayPalabras){
                    Log.d("contador", "Palabra: "+palabra.palabra);
                    Log.d("contador", "x: "+x+" y: "+y);
                    Log.d("contador", "PalabraXInc: "+palabra.xInicial+" PalabraYInc: "+palabra.yInicial);
                    Log.d("contador", "PalabraX: "+palabra.x+" PalabraY: "+palabra.y);
                    if(palabra.xInicial == x){
                        if(palabra.yInicial == y){
                            if(palabraCoincidente.palabra == palabra.palabra){
                                Log.d("contador", "Palabra2: "+palabra.palabra);
                                actualizarTableroEncontrado(palabra);
                                return true;
                            }

                        }
                    }if(palabra.x == x){
                        if(palabra.y == y){
                            Log.d("contador", "ENCONTRADO");
                            if(palabraCoincidente.palabra == palabra.palabra){
                                Log.d("contador", "Palabra2: "+palabra.palabra);
                                actualizarTableroEncontrado(palabra);
                                return true;
                            }

                        }
                    }
                }
            }

        }
        return false;
    }

    public ArrayList<ArrayList<String>> getTablero(){
        return this.tablero;
    }



}
