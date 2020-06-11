package com.example.hundirlaflota;

import java.util.ArrayList;

public class Barco {
    private int id;
    private int tipo; //serán 1,2,3 o 4.
    private ArrayList<String> modulo = new ArrayList<String>(); //$fila, $columna, $estado
    private String color;
    private String mensaje;

    Barco(int id, int tipo){
        this.id = id;
        this.tipo = tipo;

        for (int i=0; i < tipo; i++) {
            this.modulo = array("fila" => -1, "columna" => -1, "estado" => 0);     //estado 0 significa intacto
            // int [][] matriz = {{2,4,4},{6,6,9},{8,10,12}};
        }
       this.mensaje = "Barco $tipo creado con el id $id";
    }

    public void navega(int fila, int columna, String direccion, Flota flota){
        int columnaFinal;
        int filaFinal;
        int saltoFila;
        int saltoColumna;
        boolean lError;

        //valores de direccion N, S, E, O.
        switch (direccion) {
            case "N":
                columnaFinal = columna;
                filaFinal = fila - (this.tipo - 1);
                saltoFila = -1;
                saltoColumna = 0;
                lError = (filaFinal <0)? true : false;
                break;

            case "S":
                columnaFinal = columna;
                filaFinal = fila + (this.tipo - 1);
                saltoFila = +1;
                saltoColumna = 0;
                lError = (filaFinal > 9)? true : false;
                break;

            case "E":
                filaFinal = fila;
                columnaFinal = columna + (this.tipo - 1);
                saltoFila = 0;
                saltoColumna = +1;
                lError = (columnaFinal > 9)? true : false;
                break;

            case "O":
                filaFinal = fila;
                columnaFinal = columna - (this.tipo - 1);
                saltoFila = 0;
                saltoColumna = -1;
                lError = (columnaFinal < 0)? true : false;
                break;

            default:
                break;
        }

        if (!lError && !$this->objetoEnRadar(Math.min(fila,filaFinal), Math.min(columna, columnaFinal), Math.max(fila, filaFinal), Math.max(columna, columnaFinal), flota)) {
            for (int i=0; i < this.tipo; i++) {
                this.modulo[i][fila] = fila;
                this.modulo[i][columna] = columna;
                $flota->ocupaEspacio(fila, columna, this.tipo);

                fila = fila + saltoFila;
                columna = columna + saltoColumna;
            }

            this.mensaje = "En posición $fila : $columna";
            return true;
        }else{
            this.mensaje = "Barco no colocado";
            return false;
        }

    }

    private void objetoEnRadar(int filaInicio, int columnaInicio, int filaFinal, int columnaFinal, Flota flota){
        filaInicio = Math.max(0, filaInicio-1); //Si la fila empieza en la fila 0, no va a comprobar la fila de la izquierda, ya que no existe
        columnaInicio = Math.max(0, columnaInicio-1);
        filaFinal = Math.min(9, filaFinal+1);
        columnaFinal = Math.min(9,columnaFinal+1);

        lexisteObstaculo = false;

        for(int i=filaInicio; i <= filaFinal; i++){
            for(int j=columnaInicio; j <= columnaFinal; j++){
                if(flota->getEspacio(i, j) !=0){
                    return true;
                }
            }
        }return lexisteObstaculo;
    }

    public String getMensaje(){
        return this.mensaje;
    }

}
