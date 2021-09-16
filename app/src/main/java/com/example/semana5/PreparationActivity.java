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

    private String userName, userCod;
    private int levelPrepa;

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

        userName = getIntent().getExtras().getString("nombre");
        userCod = getIntent().getExtras().getString("código");

        levelPrepa = 0;

        changeColorButton();
        //De preparation a evaluation
        buttonPrepa.setOnClickListener(
                (v) ->{
                    calLevel();
                    Intent i = new Intent(this, EvaluationActivity.class);
                    i.putExtra("nombre2",userName);
                    i.putExtra("código2",userCod);
                    i.putExtra("valores",levelPrepa);
                    startActivity(i);
                    finish();
                });
    }

    public void calLevel (){
        if (checkBox1Prepa.isChecked()){
            levelPrepa = levelPrepa+1;
        }

        if (checkBox2Prepa.isChecked()){
            levelPrepa = levelPrepa+3;
        }

        if (checkBox3Prepa.isChecked()){
            levelPrepa = levelPrepa+0;
        }

    }

    public void changeColorButton(){
        buttonPrepa.setEnabled(false);
        buttonPrepa.setBackgroundResource(R.drawable.editbuttonbackground2);
        new Thread(
                ()->{
                    while(true){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(checkBox1Prepa.isChecked() || checkBox2Prepa.isChecked() || checkBox3Prepa.isChecked()){
                            runOnUiThread(
                                    ()->{
                                        buttonPrepa.setEnabled(true);
                                        buttonPrepa.setBackgroundResource(R.drawable.editbuttonbackground);
                                    });
                        }else{
                            runOnUiThread(
                                    ()->{
                                        buttonPrepa.setEnabled(false);
                                        buttonPrepa.setBackgroundResource(R.drawable.editbuttonbackground2);
                                    });
                        }
                    }
                }

        ).start();
    }
}