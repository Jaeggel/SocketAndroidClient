package com.example.joel.prueba;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    Socket socket;
    public PrintWriter out;
    public BufferedReader in;
    Button btnConectar;
    EditText ip;
    EditText puerto;
    static String dip;
    static int puertoP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        btnConectar = (Button) findViewById(R.id.btn_conectar);//main
        ip= (EditText) findViewById(R.id.txtIP);
        puerto= (EditText) findViewById(R.id.txtPuerto);
        btnConectar.requestFocus();
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dip=ip.getText().toString();
                puertoP=Integer.parseInt(puerto.getText().toString());
                try {
                    socket = new Socket(dip,puertoP);
                    Toast.makeText(getApplicationContext(), "Conectado a: "+socket.getRemoteSocketAddress(), Toast.LENGTH_LONG).show();
                    Intent menu=new Intent(MainActivity.this,Menu.class);
                    startActivity(menu);
                    socket.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error en la conexión", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

}

