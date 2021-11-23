package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button login_btn;
    TextView txt_signup,txt_forgot;
    private EditText txt_email,txt_password;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        login_btn=findViewById(R.id.btnLogin);
        txt_signup=findViewById(R.id.txtsignup);
        txt_forgot=findViewById(R.id.txtforgot);
        txt_email=findViewById(R.id.edtEmail);
        txt_password=findViewById(R.id.edtPassword);
        auth=FirebaseAuth.getInstance();


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txt_email.getText().toString().trim();
                String password=txt_password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                              if(task.isSuccessful()){
                                  startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                  Toast.makeText(Login.this, "Login is Successful", Toast.LENGTH_SHORT).show();

                              }else {
                                  Toast.makeText(Login.this, "Login Is Failed", Toast.LENGTH_SHORT).show();
                              }
                            }
                        });
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