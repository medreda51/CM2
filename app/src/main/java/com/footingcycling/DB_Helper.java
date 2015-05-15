package com.footingcycling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amin on 24/04/2015.
 */
public class DB_Helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Footing&Cycling.sqlite";
    private static final int DB_SHEME_VERSION = 1;


    public DB_Helper(Context context) {
        super(context, DB_NAME, null, DB_SHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_Metodos.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

