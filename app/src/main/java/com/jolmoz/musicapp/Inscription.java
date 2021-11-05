package com.jolmoz.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inscription extends AppCompatActivity {

    private Button acceptButton;
    private Button cleanButton;
    private EditText editName;
    private EditText editAge;
    private EditText editEmail;
    private EditText editMusic;

    private String name;
    private int age;
    private String email;
    private String music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        acceptButton = findViewById(R.id.btn_accept);
        cleanButton = findViewById(R.id.btn_clean);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
        editMusic = findViewById(R.id.editMusic);

        createListeners();
    }

    private void createListeners(){
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllEdits();
                Intent i = new Intent(Inscription.this, Finish.class);
                i.putExtra("name",name);
                i.putExtra("age",age+"");
                i.putExtra("email",email);
                i.putExtra("music",music);
                startActivity(i);
            }
        });

        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanAllEdits();
            }
        });
    }

    private void getAllEdits(){
        name = editName.getText().toString();
        age = Integer.parseInt(editAge.getText().toString());
        email = editEmail.getText().toString();
        music = editMusic.getText().toString();
    }

    private void cleanAllEdits(){
         editName.setText("");
         editAge.setText("");
         editEmail.setText("");
         editMusic.setText("");
    }

}