package com.bp.pruebaparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    TextView user;
    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        user = (TextView) findViewById(R.id.userLogin);
        pass = (TextView) findViewById(R.id.userPass);

        /*Recuperamos el intent de la actividad inicial*/
        Intent i = getIntent();
        /*Recuperamos el objeto completo*/
        Modelo modelo = i.getParcelableExtra("user");

        /*Establecemos el valor en los textViews empleando los getters de la clase Modelo*/
        user.setText(modelo.getUser());
        pass.setText(modelo.getPass());
    }
}
