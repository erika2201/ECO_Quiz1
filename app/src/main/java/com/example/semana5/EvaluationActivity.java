package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class EvaluationActivity extends AppCompatActivity {

    private TextView titleEval, textViewEval;
    private CheckBox checkBox1Eval, checkBox2Eval, checkBox3Eval;
    private Button buttonEval;

    private String userName, userCod;
    private int levelPrepa, levelEval, totalLevel;

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

        userName = getIntent().getExtras().getString("nombre2");
       // userCod = getIntent().getExtras().getString("código2");
        levelPrepa = getIntent().getExtras().getInt("valores");

        levelEval = 0;
        totalLevel = 0;

        //De evaluation a Main
        buttonEval.setOnClickListener(
                (v) ->{
                    calLevel();
                    Intent i = new Intent(this, MainActivity.class);
                    totalLevel = levelEval + levelPrepa;
                    startActivity(i);
                    saveInfo();
                    finish();
                });
    }

    private void calLevel() {
        if (checkBox1Eval.isChecked()){
            levelEval = levelEval+3;
        }

        if (checkBox2Eval.isChecked()){
            levelEval = levelEval+3;
        }

        if (checkBox3Eval.isChecked()){
            levelEval = levelEval+0;
        }
    }

    private void saveInfo() {
        SharedPreferences preferences = getSharedPreferences("datos", MODE_PRIVATE);
        String userInfo = userName + "\n";
        String infoActual = preferences.getString("usuario", "");
        preferences.edit().putString("usuario", infoActual + userInfo).apply();
    }
}