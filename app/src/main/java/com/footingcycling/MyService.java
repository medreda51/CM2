package com.footingcycling;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MyService extends Service {


    private static android.location.LocationListener locListener;
    private Location localizacionInicial = null;
    private static android.location.LocationManager locManager;
    private ArrayList<Location> coordList = new ArrayList<Location>();
    private float acum = 0;
    private int i=0;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //Para hacer una traza en el mapa del trayecto
        MapActivity.rectOptions = new PolylineOptions().width(8).color(Color.BLUE);
        Toast.makeText(this, "Servicio creado !!", Toast.LENGTH_LONG).show();
        System.out.println("------------ Servicio creado !!");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {


        locListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                if (i==0) {
                    //almacenar la posicin inicial en la variable localoacionInicial
                    localizacionInicial = new Location(location);

                    MapActivity.mMap.addMarker(new MarkerOptions().position(new LatLng(localizacionInicial.getLatitude(), localizacionInicial.getLongitude())).
                            title("Aqui estoy").snippet("aqui tenemos la localizacion inicial"));
                    i++;

                }
                else {
                    acum += CalculaDistancia(location);
                    MapActivity.campo.setText("" + acum);
                    coordList.add(location);
                    DibujarCamino(location);
                }

            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,locListener);

    }


    @Override
    public  void onDestroy() {
        super.onDestroy();

    }


    private void DibujarCamino(Location l){
        //LatLng punto = new LatLng(l.getLatitude(),l.getLongitude());
        //coordList.add(punto);
        MapActivity.rectOptions.add(new LatLng(l.getLatitude(), l.getLongitude()));
        MapActivity.mMap.addPolyline(MapActivity.rectOptions);

    }
    private float CalculaDistancia(Location l) {
        float res;
        // if(i==0){
        res = localizacionInicial.distanceTo(l);
        //res=1;
        localizacionInicial = new Location(l);
        ///   i++;
        /// }else{
        ///  res = locacalizacionAntigua.distanceTo(l);
        //   locacalizacionAntigua = new Location(l);

        //  }
        return res;
    }
    public static void PararLitener(){
        locManager.removeUpdates(locListener);

    }
}
