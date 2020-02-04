package com.example.pintores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pintores> pintores;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        pintores = new ArrayList<>();
        pintores.add(new Pintores("Vasili Kandinski", "Vasili Vasílievich Kandinski fue un pintor ruso, precursor del arte abstracto en pintura y teórico del arte. Se considera que con él comienzan la abstracción lírica y el expresionismo", R.drawable.kandinski));
        pintores.add(new Pintores("Leonardo da Vinci", "Leonardo da Vinci (Leonardo di ser Piero da Vinci) fue un polímata florentino del Renacimiento italiano. Fue a la vez pintor, anatomista, arquitecto, paleontólogo, artista, botánico, científico, escritor, escultor, filósofo, ingeniero, inventor, músico, poeta y urbanista", R.drawable.picasso));
        pintores.add(new Pintores("Claude Monet", "Claude Monet (París, 14 de noviembre de 1840-Giverny, 5 de diciembre de 1926) fue un pintor francés, uno de los creadores del impresionismo. El término impresionismo deriva del título de su obra Impresión, sol naciente", R.drawable.monet));
        pintores.add(new Pintores("Paul Cézanne", "Fue un pintor francés posimpresionista, considerado el padre de la pintura moderna y cuyas obras establecieron las bases de la transición entre la concepción artística decimonónica hacia el mundo artístico del siglo XX, nuevo y diferente", R.drawable.paulcezanne));
        pintores.add(new Pintores("Pablo Picasso", "Es considerado desde la génesis del siglo xx como uno de los mayores pintores que participaron en muchos movimientos artísticos que se propagaron por el mundo y ejercieron una gran influencia en otros grandes artistas de su tiempo", R.drawable.picasso));
        pintores.add(new Pintores("Rembrandt", " La historia del arte lo considera uno de los mayores maestros barrocos de la pintura y el grabado, siendo con seguridad el artista más importante de la historia de los Países Bajos", R.drawable.rembradt));
        pintores.add(new Pintores("Diego Velázquez", "Fue un pintor barroco español considerado uno de los máximos exponentes de la pintura española y maestro de la pintura universal.", R.drawable.velazquez));

    }

    private void initializeAdapter(){
        PintorAdapter adapter = new PintorAdapter(this, pintores);
        rv.setAdapter(adapter);
    }
}
