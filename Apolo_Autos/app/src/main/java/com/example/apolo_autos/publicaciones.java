package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apolo_autos.database.AdminSQLiteOpenHelper;

public class publicaciones extends AppCompatActivity {

    private EditText patentes,titles, type_cars,rows_cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        patentes = findViewById(R.id.pa);
        titles = findViewById(R.id.ti);
        type_cars = findViewById(R.id.type);
        rows_cars = findViewById(R.id.rows);

    }

    public void guardarClases(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Apolo_Autos", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permite sobreescribir la base de datos
        String patente = patentes.getText().toString();

        String titulo = titles.getText().toString();
        String tipo_vehiculos = type_cars.getText().toString();
        String filas = rows_cars.getText().toString();

        if(!patente.isEmpty() && !titulo.isEmpty() && !tipo_vehiculos.isEmpty() && !filas.isEmpty()){
            //Guardar los campos de la base de datos
            ContentValues cont = new ContentValues();
            cont.put("patent", patente);
            cont.put("title", titulo);
            cont.put("type_car", tipo_vehiculos);
            cont.put("rows_car", filas);

            db.insert("publicaciones", null, cont); //guardo en la database.
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Publicacion creada con exito", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getBaseContext(), "Por favor rellene los campos vacios", Toast.LENGTH_SHORT).show();
        }

    }

    public void mostrarPublicaciones(View view)
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

    public void EliminarVehiculo(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Apolo_Autos", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permite sobreescribir la base de datos

        String paten = patentes.getText().toString();

        if(!paten.isEmpty())
        {
            db.delete("publicaciones", "patent="+paten, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado el vehiculo con la patente: "+ paten + " con exito", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "La patente no puede quedar vacia", Toast.LENGTH_SHORT).show();

        }
    }

    public void ActualizarVehiculo(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Apolo_Autos", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permite sobreescribir la base de datos

        String paten = patentes.getText().toString();
        String titulo = titles.getText().toString();
        String tipo_vehiculos = type_cars.getText().toString();
        String filas = rows_cars.getText().toString();

        if(!paten.isEmpty() && !titulo.isEmpty() && !tipo_vehiculos.isEmpty() && !filas.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("patent", paten);
            cont.put("title", titulo);
            cont.put("type_car", tipo_vehiculos);
            cont.put("rows_car", filas);

            db.update("publicaciones", cont, "patent="+paten, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Actualizacion realizada con exito!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Campos vacios porfavor rellenelos.", Toast.LENGTH_SHORT).show();

        }
    }

    //Metodo para limpiar los campos
    public void Clean()
    {
        titles.setText("");
        type_cars.setText("");
        rows_cars.setText("");

    }
}