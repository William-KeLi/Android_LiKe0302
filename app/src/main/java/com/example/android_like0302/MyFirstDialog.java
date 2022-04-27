package com.example.android_like0302;

import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MyFirstDialog extends AlertDialog {
    private TextView title1,message1;//显示的标题和内容
    private Button postive1,negative1;//确认和取消按钮
    public MyFirstDialog(Context context){//构造器
         super(context);
    }

    private String messagec;
    private String titlec;
    private String positivec,negativec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        initView();
        initEvent();
    }
    private void initView(){
        title1=(TextView) findViewById(R.id.title1);
        message1=(TextView) findViewById(R.id.message1);
        postive1=(Button) findViewById(R.id.postive1);
        negative1=(Button) findViewById(R.id.negative1);
    }
    //初始化界面的确定额和取消监听器
    private void initEvent(){
        //设置确定按钮的监听器·
        postive1.setOnClickListener((view) ->{
            if (onClickListener!=null){
                onClickListener.onPositiveClick();
            }
        } );
        //设置取消按钮的监听器
        negative1.setOnClickListener((view) ->{
            if (onClickListener!=null){
                onClickListener.onPositiveClick();
            }
        } );
    }

    @Override
    public void show() {
        super.show();
    }
     public interface OnClickListener{
        void onPositiveClick();//实现确认按钮点击事件的方法
         void OnNegativeClick();//实现取消按钮点击事件的方法
     }
     //设置确定取消按钮的回调
     public OnClickListener onClickListener;//设置确认取消点击按钮的回调
    public MyFirstDialog setOnClickListner(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
        return this;
    }
   public MyFirstDialog setTitle(String titlec){
        this.titlec=titlec;
        return this;
   }
    public MyFirstDialog setMessage(String messagec){
        this.messagec=messagec;
        return this;
    }
    public void setPositive(String positivec){
        postive1.setText(positivec);

    }
    public MyFirstDialog setNegative(String negativec){
        this.negativec=negativec;
        return this;
    }

}