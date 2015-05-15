package com.footingcycling;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MapActivity extends FragmentActivity  {

    private DB_Metodos manager;
    private MiAdaptador miAdaptador = null;
    private Chronometer crono;
    private Button b2,b1;

    public static Cursor cursor;
    public static  TextView campo,campo2 ;
    public static  PolylineOptions rectOptions;
    public static GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        campo = (TextView) findViewById(R.id.textView);
        campo2 = (TextView) findViewById(R.id.textView2);

        b1 = (Button)findViewById(R.id.buttonParar);
        b2 = (Button)findViewById(R.id.buttonRegistros);

        crono =(Chronometer)findViewById(R.id.chronometer);
        crono.start();

        //creamos una instancia BD
        manager = new DB_Metodos(this);

        //crear el intent del servicio
        final Intent serv = new Intent(MapActivity.this, MyService.class);

        //Me envia a ver base de datos en otra layout
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redireccionamos a la otra activity de BD
                Intent act = new Intent(MapActivity.this, ListaPersonalizada.class);
                startActivity(act);
            }
        });

        //Parar el servicio y insertar datos en la BBDD
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crono.stop();
                //manager.eliminarTodo()--SI CEREMOS BORRAR LA TABLA LO ACTIVAMOS;
                Integer calorias = new Integer(50);
                //creamos la variable donde almacenamos la fecha actual
                long ahora = System.currentTimeMillis();
                Date fecha = new Date(ahora);
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                String salida = df.format(fecha);
                //insertamos los datos en la BD
                manager.insertar(salida, campo.getText().toString(), crono.getText().toString(), calorias.toString());
               //paramos el servicio
                MyService.PararLitener();
                stopService(serv);
            }
        });
        //activamos el servicio
        startService(serv);
        //imprimir el mapa
        setUpMapIfNeeded();
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    private void setUpMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);
    }
    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
