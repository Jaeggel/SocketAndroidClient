package com.example.joel.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Joel on 09/07/2017.
 */

public class Obtener extends AppCompatActivity
{
    Button btnObtener;
    Button btnRegresar;
    TextView txtNum;
    EditText txtNombre;
    Socket socket;
    public PrintWriter out;
    public BufferedReader in;
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.obtener);
        txtNum = (TextView) findViewById(R.id.txtNumObt);
        txtNum.setText("");
        txtNombre = (EditText) findViewById(R.id.txtNombreObt);
        btnObtener= (Button) findViewById(R.id.btnObtenerContObt);//main
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try {
                    socket = new Socket(MainActivity.dip,MainActivity.puertoP);
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    DataInputStream inI=new DataInputStream(socket.getInputStream());
                    out.write(2);
                    out.println(txtNombre.getText().toString());
                    String num=in.readLine();
                    txtNum.setText(num);
                    if(!num.equals("No existe esa Referencia..."))
                    {
                        Toast.makeText(getApplicationContext(), "Contacto Obtenido Exitosamente...", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "No existe esa referencia...", Toast.LENGTH_LONG).show();
                    }
                    socket.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error durante la obtención...", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegresar= (Button) findViewById(R.id.btnRegresarOBTC);//main
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent menu=new Intent(Obtener.this,Menu.class);
                startActivity(menu);
            }
        });
    }
}
