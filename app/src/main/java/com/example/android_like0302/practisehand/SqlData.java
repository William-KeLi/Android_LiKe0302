package com.example.android_like0302.practisehand;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

public class SqlData extends AppCompatActivity implements View.OnClickListener {
    EditText name,password;
    Button tijiao,chaxun;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_data);
        init();
    }
    private void init(){
        name=findViewById(R.id.sqlet_1);
        password=findViewById(R.id.sqlet_2);
        tijiao=findViewById(R.id.sqlbt_1);
        chaxun=findViewById(R.id.sqlbt_2);
        tijiao.setOnClickListener(this);
        chaxun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"Text.db",null);
        db.execSQL("create table if not exists user(name varchar(50),password varchar(50),primary key(name))");
        String Name = name.getText().toString();
        String Pass = password.getText().toString();
        switch (v.getId()) {
            case R.id.sqlbt_1:

            db.execSQL("insert into user(name,password)values(?,?)", new String[]{Name, Pass});
            break;
            case R.id.sqlbt_2:
                Cursor cursor = db.rawQuery("select name,password from user where name=? ",new String[]{Name});
                while(cursor.moveToNext()){
                    String mima=cursor.getString(1);
                    Toast.makeText(this, mima, Toast.LENGTH_SHORT).show();
                }
                cursor.close();

        }
        db.close();
    }
}