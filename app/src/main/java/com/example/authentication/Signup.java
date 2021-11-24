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

public class Signup extends AppCompatActivity {
    Button button_signup;
    TextView textView_login;
    EditText email_edit,password_edit,confirmpassword_edit;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        button_signup=findViewById(R.id.btnregister);
        textView_login=findViewById(R.id.txt_login);
        email_edit=findViewById(R.id.edtEmail);
        password_edit=findViewById(R.id.edtPassword);
        confirmpassword_edit=findViewById(R.id.edtConfirmPassword);

        firebaseAuth=FirebaseAuth.getInstance();

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_edit.getText().toString().trim();
                String password=password_edit.getText().toString().trim();
                String confirmPassword=confirmpassword_edit.toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Signup.this, "Please Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(Signup.this, "Password is to short", Toast.LENGTH_SHORT).show();

                }
                if (password.equals(confirmPassword)){
                    firebaseAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull  Task<AuthResult> task) {
                                  if (task.isSuccessful()){
                                      startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                      Toast.makeText(Signup.this, "Signup Comp.", Toast.LENGTH_SHORT).show();

                                  }else {
                                      Toast.makeText(Signup.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                  }
                                }
                            });

                }
            }
        });



    }
}