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


public class JuevesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.jueves_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.juevesListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getPonenciasJueves());
        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Ponencias> getPonenciasJueves() {
        ArrayList<Ponencias> movies=new ArrayList<>();

        Ponencias ponencias=new Ponencias("Adios VirtualBox, Hola Nube (AWS)", R.drawable.jueves1, "8:30 - 9:30", "Migración de servicios a la nube (AWS), instlacion de dos pilas LAMP, una base de datos, y un balanceador de carga", "Francisco Alberto Torres Higuera, Jorge Rodríguez Mora, Juan Pavón Vázquez");
        movies.add(ponencias);
        ponencias=new Ponencias("Introducción a web components con NextJS", R.drawable.jueves2, "8:20 - 9:20", "Introducción a web components con NextJS", "Miguel Ángel Gavilán");
        movies.add(ponencias);
        ponencias=new Ponencias("React para muggles: Redux, Storybook y otros trucos para hacer magia en el frontend", R.drawable.jueves3, "9:20 - 10:20", "Aprenderemos lo básico para comprender cómo funciona React, además de algunos trucos muggles que harán que nuestro trabajo con esta librería parezca magia. Aprenderemos a crear componentes fantásticos sin caer en las artes oscuras", "Nieves Borrero");
        movies.add(ponencias);
        ponencias=new Ponencias("Qubit(bit cuántico)", R.drawable.jueves4, "9:30 - 10:20", "El auge en ciencia y en informática nos ha llevado a poder expresar la información en el lenguaje mismo que se expresa los más elemental del universo, sus partículas. Poder entender los principios de la mecánica cuántica nos abre un abanico de posibilidades en informática, pues podemos dejar atrás el clásico sistema binario, en el que solo existen dos opciones, a un infinito de posibilidades, contenidas entre esos dos únicos valores clásicos (0 y 1), aumentando de manera el número de procesos complejos simultáneos que pueden realizarse en un ordenador.", "Rafa Siles");
        movies.add(ponencias);
        ponencias=new Ponencias("Desmárcate con una buena marca personal", R.drawable.jueves5, "10:20 - 11:15", "Nos esforzamos muy mucho en la nuestra formación técnica, pero para llegar al trabajo que deseamos necesitamos llamar la atención y desmarcarnos de los demás. Tras trabajar en varios procesos de selección en distintas empresas internacionales vamos a repasar todo lo que se puede hacer para demostrar lo que valemos antes incluso de ser entrevistados por la empresa en la que queremos trabajar.", "Javier Aguirre");
        movies.add(ponencias);
        ponencias=new Ponencias("Tips para optimizar tu web y convertirla en una PWA", R.drawable.jueves6, "11:45 - 12:45", "Taller donde se indicarán una serie de buenas prácticas para optimizar tu sitio web y además convertirlo en una PWA y así llevarlo a otro nivel.", "Jesús Mejías");
        movies.add(ponencias);
        ponencias=new Ponencias("SONS OF ELK", R.drawable.jueves7, "11:45 - 12:45", "Presentación y demostración de como instalar un clúster ELK en UNIX. Configuración de este conjunto de herramientas de gran potencial, las cuales combinadas realizan una eficiente gestión de registros.", "Pablo Murillo Ávila, José Jiménez Romero, Francisco Zamorano Zamorano");
        movies.add(ponencias);
        ponencias=new Ponencias("El día a día de la lucha contra el malware",R.drawable.jueves8, "12:45 - 13:25", "Hablaremos sobre la lucha contra el malware, porque siguen produciéndose grandes incidentes de seguridad y las limitaciones de las soluciones del mercado junto a algunas soluciones innovadoras.", "Adrián Rodríguez");
        movies.add(ponencias);
        ponencias=new Ponencias("Soc: el secreto de la seguridad",R.drawable.jueves9, "13:25 - 14:05", "Conoceremos lo que es un SOC (Centros de Operaciones de Seguridad) y sus principales funciones como el  seguimiento y análisis de la actividad en redes, servidores, puntos finales, bases de datos, aplicaciones, sitios web y otros sistemas, siempre buscando actividades anómalas que puedan ser indicativas de un incidente o compromiso de seguridad.", "Fernando Muñoz");
        movies.add(ponencias);
        ponencias=new Ponencias("Ingenia. Búsqueda de empleo y cómo entrenar para una entrevista de trabajo.", R.drawable.jueves10, "14:05 - 14:45","Conoce más acerca de Ingenia. Realidad del mercado laboral: búsqueda de empleo y entrenamiento para afrontar una entrevista de trabajo.", "Ángela López Muñoz");
        movies.add(ponencias);
        return movies;
    }

    @Override
    public String toString() {
        String title="JUE";
        return title;
    }
}
