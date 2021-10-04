package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button login_btn;
    TextView txt_signup,txt_forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Page");


        login_btn=findViewById(R.id.btnLogin);
        txt_signup=findViewById(R.id.txtsignup);
        txt_forgot=findViewById(R.id.txtforgot);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login=new Intent(Login.this,MainActivity.class);
                startActivity(intent_login);
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_signup=new Intent(Login.this,Signup.class);
                startActivity(intent_signup);
            }
        });

        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_forgot=new Intent(Login.this,ForgotPassword.class);
                startActivity(intent_forgot);
            }
        });
    }
}