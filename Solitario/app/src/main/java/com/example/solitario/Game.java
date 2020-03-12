package com.example.solitario;
public class Game{

    //Dimensión del tablero
    static final int NFILAS = 4;
    static final int NCOLUMNAS = 3;

    static final int VACIO = 0;
    static final int OCUPADO = 1;

    public int tablero[][];

    public Game(){
        tablero = new int [NFILAS][NCOLUMNAS];

        for (int i=0;i < NFILAS; i++){
            for(int j=0; j < NCOLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }



}
