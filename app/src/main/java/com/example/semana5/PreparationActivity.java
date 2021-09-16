package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class PreparationActivity extends AppCompatActivity {

    private TextView titlePrepa, textViewPrepa;
    private CheckBox checkBox1Prepa, checkBox2Prepa, checkBox3Prepa;
    private Button buttonPrepa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);

        titlePrepa = findViewById(R.id.titlePrepa);
        textViewPrepa = findViewById(R.id.textViewPrepa);
        checkBox1Prepa = findViewById(R.id.checkBox1Prepa);
        checkBox2Prepa = findViewById(R.id.checkBox2Prepa);
        checkBox3Prepa = findViewById(R.id.checkBox3Prepa);
        buttonPrepa = findViewById(R.id.buttonPrepa);

        //De preparation a evaluation
        buttonPrepa.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, EvaluationActivity.class);
                    startActivity(i);
                });
    }
}