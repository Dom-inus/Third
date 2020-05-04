package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private Button buttonReset, buttonTest, buttonPlay;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        buttonReset = findViewById(R.id.buttonReset);
        buttonTest = findViewById(R.id.buttonTest);
        buttonPlay = findViewById(R.id.buttonPlay);


        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
            }
        });

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom;
                nom = nome.getText().toString();
                if(!nom.isEmpty()){
                    toast = Toast.makeText(getApplicationContext(), nom, Toast.LENGTH_LONG);
                } else {
                    toast = Toast.makeText(getApplicationContext(), "Inserisci il nome", Toast.LENGTH_LONG);
                }
                toast.show();
            }
        });
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().isEmpty()){
                    toast = Toast.makeText(getApplicationContext(), "Campo vuoto", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intent = new Intent(v.getContext(), Activity2.class);
                    intent.putExtra("nome", nome.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}