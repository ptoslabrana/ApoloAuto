package com.example.apolo_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apolo_autos.Objetos.Administrador;

public class MainActivity extends AppCompatActivity {
    private EditText name, pass;
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        pass = (EditText)findViewById(R.id.pass);
        btn = findViewById(R.id.login);
        barra = findViewById(R.id.pb);
        barra.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //el boton reconoce la tarea asincrona y la ejecuta
                new Task().execute();
            }
        });
    }

    //tarea asincrona para recorrer procesos en segundo plano
    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                for(int i = 0; i <= 10; i++)
                {
                    Thread.sleep(500); // tiempo de espera de mi barra, duerme un proceso
                }

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Home_Act.class);
            startActivity(i);


        }
    }

    public void Login(View view)
    {
        String usuario = name.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();
        String nameObj = adm.getName().trim();
        String passObj = adm.getPass().trim();

        switch(usuario)
        {
            case "Pablo":
                if(usuario.equals(nameObj) && contrasena.equals(passObj))
                {
                    //inicio de sesion
                    Intent i = new Intent(this, Home_Act.class);
                    Toast.makeText(this, "Bienvenido " + nameObj, Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
                break;
            case "":
                if(usuario.equals("") && contrasena.equals(""))
                {
                    //campos vacios
                    Toast.makeText(this, "No pueden quedar los campos vacios. ", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                if(!usuario.equals(nameObj) && !contrasena.equals(passObj))
                {
                    // Campos Incorrectos
                    Toast.makeText(this, "Credenciales invalidas, intente nuevamente", Toast.LENGTH_LONG).show();


                }
                break;
        }
    }


    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://youtu.be/wCzotBkwPl4"));
        startActivity(i);
    }

    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://es-la.facebook.com"));
        startActivity(i);
    }

    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/?lang=es"));
        startActivity(i);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);

    }

    public void Salir_De_Apolo_autos(View view)
    {
        finish();
    }
}