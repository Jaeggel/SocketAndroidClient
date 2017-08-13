package com.example.joel.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Joel on 09/07/2017.
 */

public class Menu extends AppCompatActivity
{
    Button btnAgregar;
    Button btnObtener;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnAgregar = (Button) findViewById(R.id.btnCrearContact);//main
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try
                {
                    Intent agregar=new Intent(Menu.this,Agregar.class);
                    startActivity(agregar);
                }catch(Exception e)
                {
                }

            }
        });

        btnObtener = (Button) findViewById(R.id.btnObtenerCont);//main
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try
                {
                    Intent agregar=new Intent(Menu.this,Obtener.class);
                    startActivity(agregar);
                }catch(Exception e)
                {

                }
            }
        });
    }
}
