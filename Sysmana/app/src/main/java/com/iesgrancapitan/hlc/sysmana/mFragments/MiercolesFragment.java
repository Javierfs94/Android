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


public class MiercolesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.miercoles_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.miercolesListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getPonenciasMiercoles());
        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Ponencias> getPonenciasMiercoles() {
        ArrayList<Ponencias> movies=new ArrayList<>();

        Ponencias ponencias =new Ponencias("Creamos API Rest con NodeJS y de paso croquetas",R.drawable.miercoles1, "08:30 - 10:00", "Creamos una API Rest en un momentito, con NodeJS y Express", "Emanuel Fontalba");

        movies.add(ponencias);

        ponencias =new Ponencias("Taller Raspberry (asistente voz)",R.drawable.miercoles2, "08:30 - 10:00", "El taller consistirá en instalar y configurar en una Raspberry el software necesario para convertirla en un asistente de voz similar a Alexa o Google Home.", "Francisco Javier Rodriguez Méndez y Juan José Gil Luna");
        movies.add(ponencias);

        ponencias =new Ponencias("Drones Low Cost", R.drawable.miercoles3, "10:00 - 11:00", "Drones Low Cost", "Daniel Verdú");
        movies.add(ponencias);

        ponencias =new Ponencias("La Desinformación: Qué es y Cómo nos afecta", R.drawable.miercoles4, "11:45 - 12-45", "Estudiaremos el fenómeno de la desinformación (las mal llamadas Fake News), su importancia y difusión. Cómo funcionan, qué forma tienen, cómo se difunden, quién las emiten y qué trabajo hacemos desde MALDITA.ES","Stéphane M. Grueso");
        movies.add(ponencias);

        ponencias =new Ponencias("Mesa redonda: Fake News; que no te la cuelen", R.drawable.miercoles5,  "12:45 - 14:30", "Mesa redonda: Fake News; que no te la cuelen", "Stéphane M. Grueso, Alfonso Alba Cuesta y Mª Eugenia Vilches");
        movies.add(ponencias);

        return movies;
    }

    @Override
    public String toString() {
        String title="MIE";
        return title;
    }
}
