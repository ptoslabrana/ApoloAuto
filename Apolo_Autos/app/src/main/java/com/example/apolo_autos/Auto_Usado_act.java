package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apolo_autos.database.AdminSQLiteOpenHelper;

public class Auto_Usado_act extends AppCompatActivity {

    private EditText patentes,titles, type_cars,rows_cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_usado);

        patentes = findViewById(R.id.pa);
        titles = findViewById(R.id.ti);
        type_cars = findViewById(R.id.type);
        rows_cars = findViewById(R.id.rows);

    }


    public void BuscarAutos_Usados(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Apolo_Autos", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permite sobreescribir la base de datos

        String paten = patentes.getText().toString();

        if(!paten.isEmpty())
        {
            Cursor file =
                    db.rawQuery("SELECT * FROM publicaciones WHERE patent="+paten, null);
            if(file.moveToFirst())
            {
                titles.setText(file.getString(1));
                type_cars.setText(file.getString(2));
                rows_cars.setText(file.getString(3));

            }
            else{
                Toast.makeText(getBaseContext(), "No existe esta patente", Toast.LENGTH_SHORT).show();

            }
        }
        else{
            Toast.makeText(getBaseContext(), "La patente no puede quedar vacia", Toast.LENGTH_SHORT).show();

        }
    }
}