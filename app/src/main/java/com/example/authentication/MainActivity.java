package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Dialog mdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       mdialog = new Dialog(this);
    }
    public void ShowPopup(View v){
        TextView txtClose;
        Button add_btn;
        mdialog.setContentView(R.layout.activity_popup_add_window);
        txtClose=(TextView) mdialog.findViewById(R.id.txt_close);
        txtClose.setText("X");
        add_btn = (Button) mdialog.findViewById(R.id.btnadd);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.dismiss();
            }
        });
        mdialog.show();
    }
}