package com.iesgrancapitan.hlc.sysmana.mData;

/**
 * Created by Oclemmy on 5/9/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class Ponencias {

    String name;
    int image;
    String hora;
    String descripcion;
    String ponente;

    public Ponencias(String name, int image, String hora, String descripcion,String ponente) {
        this.name = name;
        this.image = image;
        this.hora = hora;
        this.descripcion = descripcion;
        this.ponente = ponente;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPonente() {
        return ponente;
    }
}
