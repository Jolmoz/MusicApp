package com.jolmoz.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    private TextView txtFinal1;
    private TextView txtFinal2;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        txtFinal1 = findViewById(R.id.txtFinal1);
        txtFinal2 = findViewById(R.id.txtFinal2);

        btnClose = findViewById(R.id.btnClose);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String email = getIntent().getStringExtra("email");
        String music = getIntent().getStringExtra("music");

        String completeText1 = "Muchas gracias por registrarte " + name + ", es genial que tengas " + age + " años!";
        String completeText2 = "A traves de tu email: " + email + " vamos a enviarte musica del tipo " + music;

        txtFinal1.setText(completeText1);
        txtFinal2.setText(completeText2);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("EXIT", true);
                startActivity(main);

            }
        });
    }
}