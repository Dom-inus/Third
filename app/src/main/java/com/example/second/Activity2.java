package com.example.second;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private TextView nome;
    private EditText modifica;
    private Bundle bundle;
    private Intent intent;
    private Button buttonModifica, buttonBack;
    private AlertDialog dialog;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        nome = (TextView) findViewById(R.id.nome);
        buttonModifica = findViewById(R.id.buttonModifica);
        buttonBack = findViewById(R.id.buttonBack);
        intent = getIntent();
        bundle = intent.getExtras();
        nome.setText(bundle.getString("nome"));
        modifica = new EditText(this);

        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("Modifica il nome");
        dialog.setView(modifica);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Salva", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nome.setText(modifica.getText());
            }
        });

        buttonModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifica.setText(nome.getText());
                dialog.show();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("nome", nome.getText().toString());
                startActivity(intent);
                toast = Toast.makeText(getApplicationContext(), nome.getText(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
