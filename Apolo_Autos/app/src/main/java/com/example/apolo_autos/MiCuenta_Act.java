package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MiCuenta_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cuenta);
    }

    public void MiCuenta(View view)
    {
        Toast.makeText(this, "Tu rol es: Administrador y Desarrollador del proyecto Apolo Autos" , Toast.LENGTH_LONG).show();

    }
}