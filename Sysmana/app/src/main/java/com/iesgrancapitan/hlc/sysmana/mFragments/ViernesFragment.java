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


public class ViernesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.viernes_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.viernesListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getPonenciasViernes());
        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Ponencias> getPonenciasViernes() {
        ArrayList<Ponencias> movies=new ArrayList<>();
        Ponencias ponencias=new Ponencias("Rickinillo, el poder de la terquedad humana ",R.drawable.viernes2, "8:20 - 9:20", "C+H*A= Todos dicen que no, pues mi terquedad dice que sí. Forma de afrontar la vida de systemas y seguridad, no muriendo en el intento y algunas veces triunfando.",  "Manu Hidalgo");
        movies.add(ponencias);

        ponencias = new Ponencias("Anti Virus - El despertar del Exploit",R.drawable.viernes3, "9:20 - 10:20", "Aprenderemos cómo evadir los antivirus a través de técnicas de camuflaje de payloads y enseñaremos algunos métodos para la ocultación de exploits en imágenes o PDF con el fin de engañar a los usuarios finales.",  "Verónica Berenguer");
        movies.add(ponencias);

        ponencias=new Ponencias("Dockers Reboot",R.drawable.viernes1, "10:20 - 11:15", "Un reinicio y vuelta a empezar con dockers, intentando explicar ansible y todo lo que podamos.",  "Juan José Martínez González");
        movies.add(ponencias);

        ponencias=new Ponencias("Low energy hacking",R.drawable.viernes4, "11:45 - 12:45", "Uso de hardware de bajo consumo para hacking, con ejemplos prácticos con placas reducidas, microcontroladores y algunos usos que se le pueden dar a este tipo de dispositivos y componentes.",  "Miguel Ángel Arroyo");
        movies.add(ponencias);

        ponencias=new Ponencias("Jornadas de relación y valoración de capacidades a través del Juego",R.drawable.viernes5, "12:45 - 14:45", "La LanParty Sngular Córdoba, actividad que realiza mensualmente en sus instalaciones, este año llega a las Sysmana 2020! Realizaremos 2 tracks simultáneos: juegos de mesa, y juegos indie / clásicos. Podremos conocernos mejor y valorar mejor la capacidad / habilidades de nuestros compañeros de juego.",  "Jose María Romero");
        movies.add(ponencias);

        return movies;
    }

    @Override
    public String toString() {
        String title="VIE";
        return title;
    }
}
