package com.example.pintores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PintorAdapter  extends RecyclerView.Adapter<PintorAdapter.PersonViewHolder> {

    private Context contexto;
    private List<Pintores> pintores;
    //Establecemos contexto y lista de personas en el constructor

    public PintorAdapter(Context contexto, List<Pintores> pintores){
        this.contexto = contexto;
        this.pintores = pintores;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View v = inflater.inflate(R.layout.item, null);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(pintores.get(i).nombre);
        personViewHolder.personAge.setText(pintores.get(i).desc);
        personViewHolder.personPhoto.setImageResource(pintores.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return pintores.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        public PersonViewHolder(View itemView) {
            super(itemView);

            personName = (TextView)itemView.findViewById(R.id.pintor_nombre);
            personAge = (TextView)itemView.findViewById(R.id.pintor_desc);
            personPhoto = (ImageView)itemView.findViewById(R.id.pintor_foto);
        }
    }



    PintorAdapter(List<Pintores> pintores){
        this.pintores = pintores;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
