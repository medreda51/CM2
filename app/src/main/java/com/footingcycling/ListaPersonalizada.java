package com.footingcycling;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;


public class ListaPersonalizada extends ListActivity {

    public static Cursor cursor;
    private DB_Metodos manager;
    private MiAdaptador miAdaptador = null;
    //long v;
    public static ArrayList<TablaRegistros> mArray = new ArrayList<TablaRegistros>();
//String fecha,Double distancia,Integer tiempo,Integer calorias
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = new DB_Metodos(this);
       // manager.insertar("11/05/28915",8.6,15,5000);
       // manager.insertar("11/05/2015",8.6,20,300);
       // manager.insertar("11/05/2015", 8.6, 8, 200);
        //Toast.makeText(this, "ha devuelto : " + v, Toast.LENGTH_SHORT).show();

        cursor = manager.CursorCargarContactos();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TablaRegistros fila = DB_Metodos.converCursoTablePeso(cursor);
            mArray.add(fila);
            //le damos la vuelta a los datos para que salgan los mas recientes primero :D ;D
            Collections.reverse(mArray);
            cursor.moveToNext();
        }
        miAdaptador = new MiAdaptador(this);
        setListAdapter(miAdaptador);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lista_personalizada, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
