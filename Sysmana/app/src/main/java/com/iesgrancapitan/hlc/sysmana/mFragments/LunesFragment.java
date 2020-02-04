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


public class LunesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.lunes_fragment,container,false);

        ListView lv= (ListView) rootView.findViewById(R.id.lunesListView);
        CustomAdapter adapter=new CustomAdapter(this.getActivity(), getPonenciasLunes());
        lv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Ponencias> getPonenciasLunes() {
        ArrayList<Ponencias> movies=new ArrayList<>();

        Ponencias ponencias=new Ponencias("Inauguración de las jornadas Sysmana XII",R.drawable.lunes1, " 9:00 - 9:15", "Inauguración y presentación de la Sysmana XII a cargo de la directora Dª. Carmen Domingo",  "Dª. Carmen Domingo");
        movies.add(ponencias);
        ponencias=new Ponencias("Red Hat OpenShift: vitaminando Kubernetes con nube híbrida", R.drawable.lunes2, "9:10 - 10:10", "Cómo puede ayudar a desarrolladores y admin. de sistemas Red Hat OpenShift, una plataforma de aplicaciones en contenedores completa que integra de manera nativa tecnologías, como Docker y Kubernetes —un poderoso sistema de administración y desarrollo de clústeres de contenedores—, y las combina con una base empresarial en Red Hat Enterprise Linux.", "Nacho Álvarez (Technical Analyst en @Redsys_es)");
        movies.add(ponencias);
        ponencias=new Ponencias("Liberad a Willy 5", R.drawable.lunes3, "10:10 - 11:10", "Proceso de despliegue continuo con Gitlab, Digital Ocean y Kubernetes", "Rafael Delgado");
        movies.add(ponencias);
        ponencias=new Ponencias("aUXilio: usuarios en apuros", R.drawable.lunes4, "10:10 - 11:10" ,"Breve introducción a la eXperiencia de Usuario", "Claudia López Iglesias");
        movies.add(ponencias);
        ponencias=new Ponencias("Crea tu perfil profesional con React y Firebase", R.drawable.lunes5, "11:50 - 12:50", "Utilizando el servicio de Google Firebase y las librerías React de front, construiremos una webapp con tu porfolio profesional publicado.", "Juan Calero");
        movies.add(ponencias);
        ponencias=new Ponencias("La Administración de Sistemas y el Cambio Climático", R.drawable.lunes6, "12:50 - 13:40", "La Administración de Sistemas y el Cambio Climático", "Oscar Martín Martínez");
        movies.add(ponencias);
        ponencias=new Ponencias("Integración continua GITlab y Docker", R.drawable.lunes7, "13:40 - 14:40", "Introducción a quién es Dobuss y posteriormente se explicará de forma básica como trabajamos con un control de versiones y como automatizar un despliegue continuo de nuestras aplicaciones en un entorno de producción utilizando contenedores.", "Miguel Angel Piedras y José Huertas");
        movies.add(ponencias);
        return movies;
    }

    @Override
    public String toString() {
        String title="LUN";
        return title;
    }
}
