package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Auto_nuevos extends AppCompatActivity {

    private RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_nuevos);

        ratingBar = (RatingBar)findViewById(R.id.rb);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Auto_nuevos.this, "!Gracias por calificar!, el puntaje enviado es de: " + rating , Toast.LENGTH_LONG).show();
            }
        });
    }



    public void Precio(View view)
    {

        String valor = "28.000.000$ CLP + IVA incluida";

        Toast.makeText(Auto_nuevos.this, "El valor del vehiculo es de: " + valor , Toast.LENGTH_LONG).show();


    }
}