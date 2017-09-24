package com.bp.pruebaparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button conect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        conect = (Button) findViewById(R.id.conect);

        conect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Se crea un intent para pasar de una actividad a otra*/
                Intent i = new Intent(MainActivity.this, ActivityB.class);
                /*Se crea una instancia de la clase modelo*/
                Modelo modelo = new Modelo(user.getText().toString(), pass.getText().toString());
                /*Y se pasa el objeto completo con putExtra*/
                i.putExtra("user", modelo);

                startActivity(i);
            }
        });
    }
}
