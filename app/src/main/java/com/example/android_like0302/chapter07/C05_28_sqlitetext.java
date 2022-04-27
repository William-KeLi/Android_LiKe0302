package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

public class C05_28_sqlitetext extends AppCompatActivity implements View.OnClickListener {
    Button buttonQuery,buttonAdd,buttonDelete,buttonUpdate;
    EditText username,pswd;

    //1.创建定义数据库对象，在成员变量这定义，避免资源空间浪费
    SQLiteDatabase sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0528_sqlitetext);
        init();
        //2.通过创建数据库
        sd=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/firstBase.db",null);
        //3.创建数据表
        sd.execSQL("create table if not exists users(name varchar(50),password varchar(50),primary key(name))");

    }
    private void init(){
        buttonAdd=(Button) findViewById(R.id.buttonAdd);
        buttonUpdate=(Button) findViewById(R.id.buttonUpdate);
        buttonDelete=(Button) findViewById(R.id.buttonDelete);
        buttonQuery=(Button) findViewById(R.id.buttonQuery);
        username=(EditText) findViewById(R.id.editTextTextPersonName4);
        pswd=(EditText) findViewById(R.id.editTextTextPassword2);
        buttonUpdate.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonQuery.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //4.确认用户名是否输入，因为每个功能都需要用户名，所以就卸载了这里
        if (username.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId()){
            case R.id.buttonAdd://添加数据
                //5.首先要确认输入了密码
                if (pswd.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "请输入密码后再添加", Toast.LENGTH_SHORT).show();
                    return;
                }
                //套上try-catch来防止出错
                try {
                    sd.execSQL("insert into users(name,password)values(?,?)", new String[]{username.getText().toString().trim()
                            , pswd.getText().toString().trim()});
                    Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(this, "插入失败，语法有错误！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonQuery://查询数据
                //先预设以下用户不存在的情况

                try {
                    String condition = "用户不存在";

                    Cursor cursor = sd.rawQuery("select name,password from users where name=?", new String[]{username.getText()
                            .toString().trim()});
                    while (cursor.moveToNext()) {
                        condition = cursor.getString(1);
                    }

                    cursor.close();//关门游标
                    pswd.setText(condition);
                    Toast.makeText(this, "查询成功，结果已显示在密码框内", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, "查询失败，语法有错误啊", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonUpdate://更新数据
                //6.首先确认输入了密码
                if (pswd.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "不输入密码改你嘛呢", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    sd.execSQL("update users set password = ?where name =?",new String[]{username.getText().toString().trim()});
                    Toast.makeText(this, "更改成功", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, "更新失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonDelete://删除数据

               try {
                   sd.execSQL("delete from users where name = ? ",new String[]{username.getText().toString().trim()});
                   Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
               }catch (Exception e){
                   Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
               }
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sd.close();//关闭数据库
    }
}