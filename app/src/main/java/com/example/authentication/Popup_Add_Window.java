package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.auth.FirebaseAuth;

public class Popup_Add_Window extends AppCompatActivity {
    EditText item_name,item_price,item_dis,item_cat;
    Button btn_upload,btn_Exit,btn_Save;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_add_window);

        item_name=(EditText)findViewById(R.id.item_Name);
        item_price=(EditText)findViewById(R.id.itemPrice);
        item_dis=(EditText)findViewById(R.id.itemDis);
        item_cat=(EditText)findViewById(R.id.itemCotegoris);

        btn_upload=(Button)findViewById(R.id.btnUploadItemImage);
        btn_Exit=(Button)findViewById(R.id.btnExit);
        btn_Save=(Button)findViewById(R.id.btnSave);


        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExit=new Intent(Popup_Add_Window.this,Login.class);
                startActivity(intentExit);
            }
        });





    }
}