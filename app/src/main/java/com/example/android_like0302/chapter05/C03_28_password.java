package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C03_28_password extends AppCompatActivity {
    private EditText password,surePassword;
    private TextView tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0328_password);
        init();
    }
    private void init(){
        password=(EditText) findViewById(R.id.editTextTextPassword4);
        surePassword=(EditText) findViewById(R.id.editTextTextPassword5);
        tip=(TextView) findViewById(R.id.textView51);
        surePassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String Password=password.getText().toString().trim();
                String Surepassword="";
                if (event.getAction()==KeyEvent.ACTION_UP){
                    Surepassword=surePassword.getText().toString().trim();
                    if (Surepassword.equals(Password)){
                        tip.setText("√");
                    }else {
                        tip.setText("两次输入不一致啊，咋回事");
                    }
                }
                return false;
            }
        });
    }
}