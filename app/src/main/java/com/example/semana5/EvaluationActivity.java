package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class EvaluationActivity extends AppCompatActivity {

    private TextView titleEval, textViewEval;
    private CheckBox checkBox1Eval, checkBox2Eval, checkBox3Eval;
    private Button buttonEval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        titleEval = findViewById(R.id.titleEval);
        textViewEval = findViewById(R.id.textViewEval);
        checkBox1Eval = findViewById(R.id.checkBox1Eval);
        checkBox2Eval = findViewById(R.id.checkBox2Eval);
        checkBox3Eval = findViewById(R.id.checkBox3Eval);
        buttonEval = findViewById(R.id.buttonEval);

        //De evaluation a Main
        buttonEval.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                });
    }
}