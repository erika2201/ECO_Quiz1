package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleMain, textViewMain;
    private Button buttonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleMain = findViewById(R.id.titleMain);
        textViewMain = findViewById(R.id.textViewMain);
        buttonMain = findViewById(R.id.buttonMain);

        //De main a register
        buttonMain.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, RegisterActivity.class);
                    startActivity(i);
                });
    }
}