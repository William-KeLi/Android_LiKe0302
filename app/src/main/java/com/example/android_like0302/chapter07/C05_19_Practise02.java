package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_like0302.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class C05_19_Practise02 extends AppCompatActivity implements View.OnClickListener {
    EditText content;
    Button replace;
    String name = "beiwanglu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0519_practise02);
        init();
        try {
            FileInputStream f1 = openFileInput(name);
            byte[] bytes=new byte[1024];
            f1.read(bytes);
            content.setText(new String(bytes));
            f1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void init(){
        content=(EditText) findViewById(R.id.editTextTextMultiLine3);
        replace=(Button) findViewById(R.id.button29);
        replace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button29){
            try {
                FileOutputStream f2=openFileOutput(name,MODE_PRIVATE);
                byte[] Bytes=content.getText().toString().trim().getBytes();
                f2.write(Bytes);
                f2.flush();
                f2.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}