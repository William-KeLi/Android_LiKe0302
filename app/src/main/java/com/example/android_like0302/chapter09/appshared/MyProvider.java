package com.example.android_like0302.chapter09.appshared;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import com.example.android_like0302.R;

public class MyProvider extends ContentProvider {
    MyHelper myHelper;
    SQLiteDatabase db;
     //这里的AUTHORITY就是一回我们需要在AndroidMainifest.xml中配置的权限
    private static final String AUTHORITY="com.example.android_like0302.chapter09.appshared";
    //定义两个匹配吗
    private static final int USERS_CODE=1;  //数据库的所有数据
    private static final int USER_CODE=2;   //数据库的单条数据

    //初始化Uri
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        //添加需要的URi
        //定义users代表该uri指向users整表
        //content：//com.example.android_like0302.chapter09.appshared/users——》1
        uriMatcher.addURI(AUTHORITY,"users",USERS_CODE);


        //#:匹配由任意数字组成的字符串
        //*：匹配任意有效字符任意长度组成的字符串
        //定义:user/#表示匹配users表中的某一条数据
        uriMatcher.addURI(AUTHORITY,"user/#",USER_CODE);

        //注意：users和user都是自己定义的字符串，与原users表名没有任何关系
    }

    @Override
    public boolean onCreate() {
        //创建或打开数据库或者数据表

        //创建SQLiteOpenHelper对象，创建数据库“provider.db”
        myHelper=new MyHelper(getContext(),"provider.db",null,1);

        //通过DB打开数据表
        db=myHelper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    //查询数据
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //设置一个int数值，用于获取传过来的的uri的匹配码，用来确认是获取整个数据表的数据，还是单行数据
        int matchWhich =uriMatcher.match(uri);
        //根据匹配码进行判断
        switch (matchWhich){
            case USERS_CODE://整表匹配
                //如果uri代表全体数据，即根据参数传来的条件在所有数据中查找数据
                //直接使用方法接收的参数进行查询
                break;
            case USER_CODE://单行匹配
                //如果URi代表单条数据，即根据URi的ID进行查询

                //此步需要进行SQL语句的拼接，因为我们添加了一个ID，传统的查询只需要name来确定是哪一行，也就是（name=?,new String[]{"name"}）
                //但是此方法传回来的selection不但包含name，还包含id，所以原本的query()中的形参 String where

                long id=ContentUris.parseId(uri);
                String where="_id = " +id;
                if (selection!=null&&!selection.equals("")) {
                    selection=selection+"and"+where;
                }else {
                    selection=where;
                }
                break;
            default:
                throw new IllegalArgumentException("无法识别的Uri"+uri);
        }
        Cursor cursor=db.query("user",//表名
                projection,    //要查询出来的列名
                selection,     //选择条件语句
                selectionArgs, //查询条件字句具体的参数
                null,  //分组条件
                null,   //过滤分组
                sortOrder);    //排序方式

        return cursor;

    }

    @Nullable
    @Override
    //返回指定uri参数对应的数据的MIME类型，一般返回null
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    //插入数据
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        //insert只考虑Uri参数代表全表数据的情况
        switch (uriMatcher.match(uri)){
            case USERS_CODE:
                long id=db.insert("users","_id",values);
                //如果插入成功，则返回Uri
                if (id>0){
                    //在原来uri的最后加上id
                    Uri newUri = ContentUris.withAppendedId(uri,id);
                    //通知数据已经改变
                    getContext().getContentResolver().notifyChange(newUri,null);
                    return newUri;
                }
                break;
            default:
                //如果不是全表数据的Uri
                throw new IllegalArgumentException("无法处理的Uri"+uri);
        }
        return null;
    }

    @Override
    //删除数据
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        //记录所删除的列数
        int colum=0;
        switch (uriMatcher.match(uri)){
            case USER_CODE:
                long id=ContentUris.parseId(uri);
                String where="_id = "+id;

                if (selection!=null&&!selection.equals("")) {
                   selection=selection+"and"+where;
                }else {
                    selection=where;
                }
                colum=db.delete("user",selection,selectionArgs);
                break;
            case USERS_CODE:
                colum=db.delete("user",selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的Uri"+uri);
        }
        return colum;
    }

    @Override
    //更新数据
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        //记录所修改的列数
        //记录所删除的列数
        int colum=0;
        switch (uriMatcher.match(uri)){
            case USER_CODE:
                long id=ContentUris.parseId(uri);
                String where="_id = "+id;

                if (selection!=null&&!selection.equals("")) {
                    selection=selection+"and"+where;
                }else {
                    selection=where;
                }
                colum=db.update("user",values,selection,selectionArgs);
                break;
            case USERS_CODE:
                colum=db.update("user",values,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的Uri"+uri);
        }

        //修改数据
        colum=db.update("user",values,selection,selectionArgs);
        //通知数据已经改变
        getContext().getContentResolver().notifyChange(uri,null);
        return colum;

    }


    //1.定义内部类MyHelper，并使它继承自SQLiteoPENHelper
    class MyHelper extends SQLiteOpenHelper{

        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            //Context context：上下文对象
            //String name:数据库名称
            //SQLiteDatabase.CursorFactory factory：允许查询数据时返回一个curson，一般填写null
            //int version ：版本号

        }
         //第一次创建对象时，调用的方法，一般在此方法中创建数据表
        @Override
        public void onCreate(SQLiteDatabase db) {
              //在此方法中创建数据表    autuincrement
            //ID为integer,该列被设置为住建，且ID值自增（ID需要设置为数字，因为ContentUris.parseId工具方法会叫最后的ID解析为数字）
            db.execSQL("create table if not exists user (_id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(50) unique,password varchar(50))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}