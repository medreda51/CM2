package com.footingcycling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Amin on 24/04/2015.
 */
public class DB_Metodos {
    public static final String TABLE_NAME = "registrosFotting";
    public static final String CN_ID = "_id";
    public static final String CN_FECHA= "fecha";
    public static final String CN_DISTANCIA= "distancia";
    public static final String CN_TIEMPO= "tiempo";
    public static final String CN_CALORIAS = "calorias";

    //metodo para crear la base de dato
    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_FECHA + " text not null,"
            + CN_DISTANCIA + " text not null ,"
            + CN_TIEMPO + " text not null ,"
            + CN_CALORIAS + " text not null) ;";
    private DB_Helper helper;
    private SQLiteDatabase db;

    public DB_Metodos(Context context) {
        helper = new DB_Helper(context);
        db = helper.getWritableDatabase();
    }

//metodo para generar contenido,lo usaremos mas abajo en los otros metodos que vienen.
    private ContentValues generadorContentValues(String fecha,String distancia,String tiempo,String calorias){
        ContentValues valores = new ContentValues();

        valores.put(CN_FECHA,fecha);
        valores.put(CN_DISTANCIA,distancia);
        valores.put(CN_TIEMPO,tiempo);
        valores.put(CN_CALORIAS,calorias);
        return valores;
    }
//metodos para insertar y eleminar y modificar registros de la base de datos.

public long insertar(String fecha, String distancia, String tiempo, String calorias){
    long res;
    //si devuelve -1 algo falla , si devuelve un numero aleatorio los datos se han insertado bien.
    res = db.insert(TABLE_NAME,null,generadorContentValues(fecha,distancia,tiempo,calorias));

    return res;
   }
    public static TablaRegistros converCursoTablePeso(Cursor cursor) {
        TablaRegistros fila = new TablaRegistros();
        fila.setId(cursor.getInt(0));
        fila.setFecha(cursor.getString(1));
        fila.setdistancia(cursor.getString(2));
        fila.settiempo(cursor.getString(3));
        fila.setcalorias(cursor.getString(4));
        return fila;
    }
    public Cursor CursorCargarContactos(){
        String [] columnas = new String[]{CN_ID,CN_FECHA,CN_DISTANCIA,CN_TIEMPO,CN_CALORIAS};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }
    //vaciar la tabla
    public void eliminarTodo(){
        db.delete(TABLE_NAME,null,null);


    }

}
