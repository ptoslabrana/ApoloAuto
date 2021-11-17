package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    //intent implicito
    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); // accion para el marcado de telefono
        i.setData(Uri.parse("tel:" + "87309841"));
        startActivity(i);
    }
}