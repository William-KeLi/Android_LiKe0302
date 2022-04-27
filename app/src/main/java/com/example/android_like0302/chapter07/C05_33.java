package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_like0302.R;

public class C05_33 extends AppCompatActivity implements View.OnClickListener{
   EditText shengci,jieshi,sousuo;
   Button tianjia,search,suoyou;
   LinearLayout lo;
   SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0533);
        init();

        //建立数据库和数据表
        db=SQLiteDatabase.openOrCreateDatabase(getFilesDir().toString()+"/third.db",null);
        db.execSQL("create table if not exists words(word varchar(50),intro varchar(50),primary key(word))");
    }
    private void init(){
        shengci=(EditText) findViewById(R.id.editTextTextPersonName6);
        jieshi=(EditText) findViewById(R.id.editTextTextPersonName9);
        sousuo=(EditText) findViewById(R.id.editTextTextPersonName10);
        lo=(LinearLayout) findViewById(R.id.wuliao);
        tianjia=(Button) findViewById(R.id.button32);
        search=(Button) findViewById(R.id.button33);
        suoyou=(Button) findViewById(R.id.button34);
        suoyou.setOnClickListener(this);
        tianjia.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.button32://这是添加
                   //获取输入框内容。
                 String wordes = shengci.getText().toString().trim();
                 String inter = jieshi.getText().toString().trim();
                 //根据内容判断
                   if (wordes.isEmpty()||inter.isEmpty()) {
                       Toast.makeText(this, "请输入生词或解释！", Toast.LENGTH_SHORT).show();
                       return;
                   }
                   try {
                       db.execSQL("insert into words(word,intro) values(?,?)", new Object[]{wordes, inter});
                       Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
                   }catch (Exception e){
                       Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
                   }
                   break;


               case R.id.button33://这是搜索
                   //首先确定用户是否输入了
                   wordes=sousuo.getText().toString().trim();
                   if (wordes.isEmpty()) {
                       Toast.makeText(this, "不能输入为空！", Toast.LENGTH_SHORT).show();
                       return;
                   }

                   String result ="未搜索到结果";
                   Cursor cursor = db.rawQuery("select * from words where word=?" ,new String[]{wordes});
                   //循环读取下一行
                   while (cursor.moveToNext()){
                       result=cursor.getString(1);
                   }
                   //显示搜索到的词汇
                   Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                       cursor.close();
                   break;
               case R.id.button34://取出所有词
               Cursor cursor_list =db.rawQuery("select * from words",null);
               //游标循环读取下一行
                   while (cursor_list.moveToNext()) {
                       TextView tv = new TextView(C05_33.this);
                       tv.setText("生词"+cursor_list.getString(0)+"\n解释："+cursor_list.getString(1));
                       lo.addView(tv);
                   }
                   cursor_list.close();
            break;
           }
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}