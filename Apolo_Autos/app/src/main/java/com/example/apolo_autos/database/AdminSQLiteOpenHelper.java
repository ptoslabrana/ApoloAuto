package com.example.apolo_autos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    //Constructor para instanciar mi database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodo que crea las tablas y campos (modelos relacionales)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE publicaciones ( patent int primary key, title text, type_car text, rows_car text)");
    }

    //Se utiliza para actualizar cambios esquimaticos en la database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
