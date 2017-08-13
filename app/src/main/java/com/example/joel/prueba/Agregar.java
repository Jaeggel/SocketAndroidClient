package com.example.joel.prueba;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Joel on 09/07/2017.
 */

public class Agregar extends AppCompatActivity
{
    Button btnGuardar;
    Button btnRegresar;
    EditText txtNombre;
    EditText txtNum;
    public Socket socket;
    public PrintWriter out;
    public BufferedReader in;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar);
        btnGuardar= (Button) findViewById(R.id.btnGuardarCrear);//main
        txtNombre= (EditText) findViewById(R.id.txtNombreAgr);//main
        txtNum= (EditText) findViewById(R.id.txtNumCrear);//main
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try {

                    socket = new Socket(MainActivity.dip,MainActivity.puertoP);
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out.write(1);
                    out.println(txtNombre.getText().toString());
                    out.println(txtNum.getText().toString());
                    Toast.makeText(getApplicationContext(), "Contacto Agregado Exitosamente...", Toast.LENGTH_LONG).show();
                    Intent guardar=new Intent(Agregar.this,Menu.class);
                    startActivity(guardar);
                    socket.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error durante el ingreso...", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        });

        btnRegresar= (Button) findViewById(R.id.btnRegresarCrear);//main
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent menu=new Intent(Agregar.this,Menu.class);
                startActivity(menu);
            }
        });

    }

}


