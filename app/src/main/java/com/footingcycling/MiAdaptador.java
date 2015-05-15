package com.footingcycling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Amin on 28/04/2015.
 */
public class MiAdaptador extends BaseAdapter {

    private Context mContext;

    public MiAdaptador(Context mContext) {

        this.mContext = mContext;
    }


    @Override
    public int getCount() {

        return ListaPersonalizada.mArray.size();
    }

    @Override
    public Object getItem(int position) {

        return ListaPersonalizada.mArray.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view =null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_personalizada,null);
        }else{
            view = convertView;
        }
       // ImageView img = (ImageView) view.findViewById(R.id.imagen);
      //  img.setImageDrawable(mContext.getResources().getDrawable(ListaPersonalizada.mArray.get(position).getimageSource()));



        TextView fText = (TextView) view.findViewById(R.id.fecha);
        fText.setText(ListaPersonalizada.mArray.get(position).getFecha());

        TextView dText = (TextView) view.findViewById(R.id.distancia);
        dText.setText(ListaPersonalizada.mArray.get(position).getdistancia().toString()+"m");

        TextView tText = (TextView) view.findViewById(R.id.tiempo);
        tText.setText(ListaPersonalizada.mArray.get(position).gettiempo().toString()+"Time");

        TextView cText = (TextView) view.findViewById(R.id.calorias);
        cText.setText(ListaPersonalizada.mArray.get(position).getcalorias().toString()+"Cal");


        return view;
    }
}
