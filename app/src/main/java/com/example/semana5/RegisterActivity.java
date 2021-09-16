package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private TextView titleRegister, textViewRegister;
    private EditText editTextName, editTextCod;
    private Button buttonRegister;

    private boolean allowContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        titleRegister = findViewById(R.id.titleRegister);
        textViewRegister = findViewById(R.id.textViewRegister);
        editTextName = findViewById(R.id.editTextName);
        editTextCod = findViewById(R.id.editTextCod);
        buttonRegister = findViewById(R.id.buttonRegister);


        //SharedPreferences sp1 = getSharedPreferences("name",MODE_PRIVATE);

        //De register a preparation
        buttonRegister.setOnClickListener(
                (v) ->{
                    checkInfo(); //llamo a este método
                    String userName = editTextName.getText().toString();
                    String userCod = editTextCod.getText().toString();

                    if(userName==null || userCod==null || userName.isEmpty() || userCod.isEmpty()){
                        Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show(); //mensaje cuando deja algo vacio
                    }else if(allowContinue){
                        Intent i = new Intent(this, PreparationActivity.class);
                        i.putExtra("nombre", userName);
                        i.putExtra("código", userCod);
                        startActivity(i);
                        finish();
                         }
                     });
         }

    public void checkInfo(){
        allowContinue=true;
        String userInfo = getSharedPreferences("datos", MODE_PRIVATE).getString("usuario", "No hay datos almacenados");

        if (userInfo.contains(editTextName.getText().toString()) && userInfo.contains(editTextCod.getText().toString())){
            Toast.makeText(this, "El usuario ya está registrado", Toast.LENGTH_SHORT).show();
            allowContinue=false;
        }
    }
}