package com.example.shoppingprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button register, login;
    EditText name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Register
        //Mapping
        register = findViewById(R.id.btn_signUp);
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Explicit Intent
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                String sname = name.getText().toString();
                String semail = email.getText().toString();
                //Data packaging
                Bundle bundle = new Bundle();
                bundle.putString("username", sname);
                bundle.putString("email", semail);
                //Put into Intent
                intent.putExtra("user", bundle);
                startActivity(intent);
            }
        });
        //Login
        login = findViewById(R.id.btn_singIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
