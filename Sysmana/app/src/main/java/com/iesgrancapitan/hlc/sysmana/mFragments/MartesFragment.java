package com.iesgrancapitan.hlc.sysmana.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iesgrancapitan.hlc.sysmana.R;
import com.iesgrancapitan.hlc.sysmana.mData.Ponencias;
import com.iesgrancapitan.hlc.sysmana.mListView.CustomAdapter;

import java.util.ArrayList;


public class MartesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.martes_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.martesListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getPonenciasMartes());
        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Ponencias> getPonenciasMartes() {
        ArrayList<Ponencias> movies=new ArrayList<>();

        Ponencias ponencias=new Ponencias("Taller de Microbit",R.drawable.martes1, "8:30-11:15", "Taller de microbit basado en la resolución de pequeños retos, donde se pueden poner en práctica y aprender programación de forma, divertido y al alcance de todos.",  "Manuel Jiménez y Álvaro Molina Ayuso");
        movies.add(ponencias);
        ponencias=new Ponencias("Top Web Hacking",R.drawable.martes2, "8:30-9:30", "En esta ponencia vamos a conocer cuáles son las vulnerabilidades web más comunes siguiendo el top 10 de OWASP y aprenderemos a explotarlas.",  "Rafael Sojo");
        movies.add(ponencias);
        ponencias=new Ponencias("Phishing en la escuela",R.drawable.martes3, "9:30-10:10", "¿Qué es el Phishing? ¿Me afecta? Durante esta charla veremos ejemplos reales de ataques de phishing y qué técnicas utilizan para recopilar información de nosotros una vez que hemos sido 'pescados'.",  "Rafael López");
        movies.add(ponencias);
        ponencias=new Ponencias("Técnicas de intrusión con Powershell y BadUsb",R.drawable.martes4, "10:15-11:15", "potencial de un ataque con un BadUsb de bajo coste unido a la ejecución de código PowerShell. Veremos como se puede comprometer una máquina en segundos por no tener las medidas de seguridad adecuadas. Todo ello con un dispositivo que cualquiera puede conseguir por 1€ y haciendo uso de Arduino y Powershell. La seguridad física importa y mucho, pues puede ser tu equipo el que ya esté comprometido sin que tú lo sepas.",  "Eduardo Sánchez Toril");
        movies.add(ponencias);
        ponencias=new Ponencias("Encriptación y búsqueda por campos encriptados en BBDD",R.drawable.martes5, "11:45-12:45", "Charla sobre como encriptar datos de forma segura, para ser almacenados en BBDD y poder realizar, posteriormente, búsquedas sobre los mismos, sin afectar de forma brusca al rendimiento de la aplicación.",  "Alejandro Arrabal Hidalgo");
        movies.add(ponencias);
        ponencias=new Ponencias("DevOps (Development y Operations)",R.drawable.martes6, "12:45-13:45", "Metodología de desarrollo de software que se centra en la comunicación, colaboración e integración entre desarrolladores de software y los profesionales de sistemas.",  "Sergio Caballero");
        movies.add(ponencias);
        ponencias=new Ponencias("Machine Learning & BPMN",R.drawable.martes7, "13:45-14:45", "Toma de decisiones automatizada y dinámica basada en procesos. Generar automáticamente árboles de decisión dinámicos (basados en el conjunto de datos) que puedan aprender, ser evaluados y pregunten al usuario por el valor de alguna característica que desconozcan para continuar con su clasificación.",  "Jesús Gil Cabezas");
        movies.add(ponencias);

        return movies;
    }

    @Override
    public String toString() {
        String title="MAR";
        return title;
    }
}
