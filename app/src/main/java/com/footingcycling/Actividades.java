package com.footingcycling;


import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TabHost;


public class Actividades extends ActionBarActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button inicio,fin,inicio2,fin2;
    private Chronometer crono,crono2;



   /* public void  chronometerBici(View view){

       // crono= (Chronometer)findViewById(R.id.chronometer);
        //inicio= (Button)findViewById(R.id.button_inicio);
        //fin = (Button)findViewById(R.id.button_fin);



        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio.setEnabled(false);
                fin.setEnabled(true);
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();

            }
        });

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio.setEnabled(true);
                fin.setEnabled(false);
                crono.stop();

            }
        });
    }*/



   /* public void  chronometerCorrer(View view){

       // crono2= (Chronometer)findViewById(R.id.chronometer2);
       // inicio2= (Button)findViewById(R.id.button_inicio2);
       // fin2 = (Button)findViewById(R.id.button_fin2);

        inicio2.setEnabled(true);
        fin2.setEnabled(false);

        inicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio2.setEnabled(false);
                fin2.setEnabled(true);
                crono2.setBase(SystemClock.elapsedRealtime());
                crono2.start();

            }
        });

        fin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio2.setEnabled(true);
                fin2.setEnabled(false);
                crono2.stop();

            }
        });
    }*/







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        crono= (Chronometer)findViewById(R.id.chronometer);
        inicio= (Button)findViewById(R.id.button_inicio);
        fin = (Button)findViewById(R.id.button_fin);

        crono2= (Chronometer)findViewById(R.id.chronometer2);
        inicio2= (Button)findViewById(R.id.button_inicio2);
        fin2 = (Button)findViewById(R.id.button_fin2);

        inicio.setOnClickListener(this);
        inicio2.setOnClickListener(this);
        fin.setOnClickListener(this);
        fin2.setOnClickListener(this);

        // Para anyadir la barra de acciones
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        /**Aqui va el codigo para volver al layout principal medante la flecha de la barra de herramientas*/
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Aqui va el codigo de las pestañas del Layout "activity_actividades"

        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",
                res.getDrawable(R.drawable.pestanya_bici));//TAB1
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("",
                res.getDrawable(R.drawable.pestanya_correr)); //TAB2
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
            }
        });


        //********************************* CHRONOMETER1

        /**
         crono= (Chronometer)findViewById(R.id.chronometer);
         inicio= (Button)findViewById(R.id.button_inicio);
         fin = (Button)findViewById(R.id.button_fin);

         inicio.setEnabled(true);
         fin.setEnabled(false);

         inicio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        inicio.setEnabled(false);
        fin.setEnabled(true);
        crono.setBase(SystemClock.elapsedRealtime());
        crono.start();

        }
        });


         fin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        inicio.setEnabled(true);
        fin.setEnabled(false);
        crono.stop();

        }
        });


         //********************************* CHRONOMETER2

         crono2= (Chronometer)findViewById(R.id.chronometer2);
         inicio2= (Button)findViewById(R.id.button_inicio2);
         fin2 = (Button)findViewById(R.id.button_fin2);

         inicio2.setEnabled(true);
         fin2.setEnabled(false);

         inicio2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        inicio2.setEnabled(false);
        fin2.setEnabled(true);
        crono2.setBase(SystemClock.elapsedRealtime());
        crono2.start();

        }
        });


         fin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        inicio2.setEnabled(true);
        fin2.setEnabled(false);
        crono2.stop();

        }
        });

         */





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividades, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);// hay que configurar un par de cosas en el manifests


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_inicio){

            inicio.setEnabled(false);
            fin.setEnabled(true);
            crono.setBase(SystemClock.elapsedRealtime());
            crono.start();

        }
        if(v.getId()==R.id.button_fin){
            inicio.setEnabled(true);
            fin.setEnabled(false);
            crono.stop();
        }
        if(v.getId()==R.id.button_inicio2){
            inicio2.setEnabled(false);
            fin2.setEnabled(true);
            crono2.setBase(SystemClock.elapsedRealtime());
            crono2.start();
        }
        if(v.getId()==R.id.button_fin2){
            inicio2.setEnabled(true);
            fin2.setEnabled(false);
            crono2.stop();
        }

    }
}

