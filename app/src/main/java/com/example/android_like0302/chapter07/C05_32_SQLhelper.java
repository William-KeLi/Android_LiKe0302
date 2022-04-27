package com.example.android_like0302.chapter07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

public class C05_32_SQLhelper extends AppCompatActivity implements View.OnClickListener {
    Button buttonQuery,buttonAdd,buttonDelete,buttonUpdate;
    EditText username,pswd;

    //3.定义SQLiteOpenHelper子类对象
    MyDpHelper dp;
    //4.定义数据库对象
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0532_sqlhelper);
        init();
        //5.创建MyDpHelper对象
        dp = new MyDpHelper(this,"secondBase.db",null,1);
        //6.通过数据库打开数据表
        db=dp.getWritableDatabase();
    }
    private void init(){
        buttonAdd=(Button) findViewById(R.id.buttonAdd1);
        buttonUpdate=(Button) findViewById(R.id.buttonUpdate1);
        buttonDelete=(Button) findViewById(R.id.buttonDelete1);
        buttonQuery=(Button) findViewById(R.id.buttonQuery1);
        username=(EditText) findViewById(R.id.editTextTextPersonName5);
        pswd=(EditText) findViewById(R.id.editTextTextPassword3);
        buttonUpdate.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonQuery.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //7. 判断用户名是否为空，空则结束方法
        if (username.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId()){
            case R.id.buttonAdd1://8.添加数据
             //判断密码是否为空
                if (pswd.getText().toString().trim().isEmpty()) {
                    return;
                }
                //要插入数据，首先就需要创建ContentValue对象，利用对象来插入数据
                ContentValues values=new ContentValues();
                values.put("name",username.getText().toString().trim());
                values.put("password",pswd.getText().toString().trim());
             //向数据库中插入数据，并获取返回值
                long insertID = db.insert("users",null,values);
                //判断是否插入成功
                if (insertID==-1) {
                    Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.buttonQuery1://11.查询数据（最难的）
                //查询的数据需要梵高游标中
                Cursor cursor = db.query("users"//表名
                        ,new String[]{"password"} //要查询的列名
                        ,"name=?"//查询条件子句，也就是password对应的那一列
                        ,new String[]{username.getText().toString().trim()}//name的实际值
                        ,null //分组条件
                        ,null//过滤分组
                       ,null//排序方式
                        ,null//偏移量
                );
                //读取cursor中的数据
                if (cursor.getCount()==0) {
                    pswd.setText("用户不存在");
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                }else {
                    cursor.moveToFirst();
                    pswd.setText(cursor.getString(0));
                }
                cursor.close();//关闭游标
                break;
            case R.id.buttonUpdate1://10.更新数据
                //首先还是却人密码框有内容
                if (pswd.getText().toString().trim().isEmpty()) {
                    return;
                }
                //要插入数据，首先就需要创建ContentValue对象，利用对象来插入数据
                ContentValues valuess=new ContentValues();
                valuess.put("password",pswd.getText().toString().trim());
                //更新，并获取被修改的行数
                int whichLine =db.update("users",valuess,"name=?",new String[]{username.getText()
                        .toString().trim()});
                //提示信息
                Toast.makeText(this, "修改了第"+whichLine+"条内容", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDelete1://9.删除数据
                int deleteNum = db.delete("users","name=?",new String[]{username.getText()
                        .toString().trim()});
                //提示删除的行数
                Toast.makeText(this, "删除"+deleteNum+"条记录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        db.close();//关闭数据库
        super.onDestroy();
    }

    //1.创建SQLiteOpenHelper的子类
    class MyDpHelper extends SQLiteOpenHelper{

        public MyDpHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //这是一个回调方法
            //2.在第一次打开时，创建一个数据表
            db.execSQL("create table if not exists users(name varchar(50),password varchar(50),primary key(name))");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             //这也是一个回调方法，进行版本升级时调用
        }
    }
}