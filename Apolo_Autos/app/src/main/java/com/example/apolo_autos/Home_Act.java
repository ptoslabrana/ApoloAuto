package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Home_Act extends AppCompatActivity {

    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);

        //obtener la ruta del video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.apoloautovideo;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        video.start();
    }



    public void Autos_Nuevos(View view)
    {
        Intent i = new Intent(this, Auto_nuevos.class);
        Toast.makeText(this, "Mejor vehiculo del año 2021", Toast.LENGTH_LONG).show();
        startActivity(i);
    }

    public void Publicar_Vehiculo(View view)
    {
        Intent i = new Intent(this, publicaciones.class);
        Toast.makeText(this, "Publicar un vehiculo", Toast.LENGTH_LONG).show();
        startActivity(i);
    }

    public void Cuenta(View view)
    {
        Intent i = new Intent(this, MiCuenta_Act.class);
        Toast.makeText(this, "Bienvenido a tu cuenta", Toast.LENGTH_LONG).show();
        startActivity(i);
    }

    public void Autos_Usados(View view)
    {
        Intent i = new Intent(this, Auto_Usado_act.class);
        Toast.makeText(this, "Seccion de Vehiculos Usados", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
}