package com.example.sopadeletras;

import java.util.Random;

public class Palabra {
    public int x;
    public int y;
    public int xInicial;
    public int yInicial;
    public int dir;
    public String[] palabraArray;
    public static String[] arrayPalabras;
    public String palabra;

    public Palabra(){
        Random r = new Random();
        this.palabra = arrayPalabras[r.nextInt(8)];
        this.palabraArray = this.palabra.split("");
        this.x = r.nextInt(10);
        this.y = r.nextInt(10);
        this.xInicial = this.x;
        this.yInicial = this.y;
        this.dir = r.nextInt(8);
    }
    public void calculaDireccion(){
        switch (this.dir) {
            case 0:
                //Abajo arriba
                this.x -= 1;
                break;
            case 1:
                //Izquierda derecha
                this.y += 1;
                break;
            case 2:
                //Arriba abajo
                this.x += 1;
                break;
            case 3:
                //Derecha izquierda
                this.y -= 1;
                break;
            case 4:
                //Abajo izquierda - Arriba derecha
                this.x -= 1;
                this.y += 1;
                break;
            case 5:
                //Abajo derecha - Arriba izquierda
                this.x -= 1;
                this.y -= 1;
                break;
            case 6:
                //Arriba izquierda - Abajo derecha
                this.x += 1;
                this.y += 1;
                break;
            case 7:
                //Arriba derecha - Abajo izquierda
                this.x += 1;
                this.y -= 1;
                break;
        }
    }

    public void retrocederDir(){
        switch (this.dir) {
            case 0: //Abajo arriba
                this.x += 1;
                break;
            case 1: //Izquierda derecha
                this.y -= 1;
                break;
            case 2: //Arriba abajo
                this.x -= 1;
                break;
            case 3: //Derecha izquierda
                this.y += 1;
                break;
            case 4: //Abajo izquierda - Arriba derecha
                this.x += 1;
                this.y -= 1;
                break;
            case 5: //Abajo derecha - Arriba izquierda
                this.x += 1;
                this.y += 1;
                break;
            case 6: //Arriba izquierda - Abajo derecha
                this.x -= 1;
                this.y -= 1;
                break;
            case 7: //Arriba derecha - Abajo izquierda
                this.x -= 1;
                this.y += 1;
                break;
        }
    }

    public void revertirPalabra(){
        this.x = this.xInicial;
        this.y = this.yInicial;
    }

    public static void setArrayPalabras(String aP){
        arrayPalabras = aP.split(",");
    }

}
