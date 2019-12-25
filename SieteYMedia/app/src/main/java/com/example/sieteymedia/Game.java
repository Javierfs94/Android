package com.example.sieteymedia;


import java.util.ArrayList;
import java.util.Collections;

public class Game {
    String estado;
    float puntuacion;
    float puntuacionMaquina;
    static ArrayList<Integer> baraja = new ArrayList<>();
    Game(){
        setPuntuacion(0);
        setPuntuacionMaquina(0);
        estado = "iniciado";
    }

    private void setPuntuacion(float p){
        this.puntuacion = p;
    }
    private void setPuntuacionMaquina(float p){
        this.puntuacion = p;
    }
    private void setEstado(String est){
        this.estado = est;
    }
    public float getPuntuacion(){
        return puntuacion;
    }
    public float getPuntuacionMaquina(){
        return puntuacionMaquina;
    }
    public String getEstado(){
        return estado;
    }

    public void rellenarBaraja(){
        baraja.clear(); //Limpiamos baraja por si se reinicia juego
        for(int i=1;i<=40;i++){
            baraja.add(i);
        }
    }
    public void barajar(){
        Collections.shuffle(baraja);
    }
    public String recorrerBaraja(){
        String numeros = "";
        for (int num:baraja) {
            numeros += num;
        }
        return numeros;
    }

    public int sacarCarta(){
        return baraja.remove(0); //Extrae la primera carta
    }

    public void actualizarPuntuacion(int numeroCarta){
        int posCarta = numeroCarta%10;

        if (posCarta >7 || posCarta == 0){
            this.puntuacion +=0.5;
        }
        else{
            this.puntuacion += posCarta;
        }
    }
    public void actualizarPuntuacionMaquina(int numeroCarta){
        int posCarta = numeroCarta%10;

        if (posCarta >7 || posCarta == 0){
            this.puntuacionMaquina +=0.5;
        }
        else{
            this.puntuacionMaquina += posCarta;
        }
    }

    public void compruebaEstado(boolean plantarse){

        //Recogemos el valor en variables para que sea más facil establecer los condicionales
        float puntosJgd = getPuntuacion();
        float puntosMqn= getPuntuacionMaquina();

        //Si el jugador pide otra carta y supera el valor 7.5, directamente se declara perdida la partida.
        if(puntosJgd > 7.5){
            setEstado("perdido");
        }
        else{
            //En caso de haber pulsado la opción plantarse:
            if(plantarse){
                //Si la maquina se ha pasado en puntos, el jugador gana, sino se comparan ambas puntuaciones.
                if(puntosMqn <= 7.5){
                    if(puntosJgd == puntosMqn){
                        setEstado("empate");
                    }
                    else if(puntosJgd > puntosMqn){
                        setEstado("ganado");
                    }
                    else{
                        setEstado("perdido");
                    }
                }
                else{
                    setEstado("ganado");
                }
            }
        }

    }

}


