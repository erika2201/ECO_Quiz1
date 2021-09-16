package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private TextView titleRegister, textViewRegister;
    private EditText editTextName, editTextCod;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        titleRegister = findViewById(R.id.titleRegister);
        textViewRegister = findViewById(R.id.textViewRegister);
        editTextName = findViewById(R.id.editTextName);
        editTextCod = findViewById(R.id.editTextCod);
        buttonRegister = findViewById(R.id.buttonRegister);

        //De register a preparation
        buttonRegister.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, PreparationActivity.class);
                    startActivity(i);
                });

    }
}