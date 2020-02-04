package com.iesgrancapitan.hlc.sysmana.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iesgrancapitan.hlc.sysmana.R;
import com.iesgrancapitan.hlc.sysmana.mData.Ponencias;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 5/9/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Ponencias> ponencias;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Ponencias> ponencias) {
        this.c = c;
        this.ponencias = ponencias;
    }

    @Override
    public int getCount() {
        return ponencias.size();
    }

    @Override
    public Object getItem(int position) {
        return ponencias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.movieImage);
        TextView horaTxt= (TextView) convertView.findViewById(R.id.posTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
        TextView ponTxt= (TextView) convertView.findViewById(R.id.ponTxt);


        final String name= ponencias.get(position).getName();
        int image= ponencias.get(position).getImage();
        final String hora= ponencias.get(position).getHora();
        final String desc= ponencias.get(position).getDescripcion();
        final String pon= ponencias.get(position).getPonente();

        nameTxt.setText(name);
        img.setImageResource(image);
        horaTxt.setText(hora);
        descTxt.setText(desc);
        ponTxt.setText(pon);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
