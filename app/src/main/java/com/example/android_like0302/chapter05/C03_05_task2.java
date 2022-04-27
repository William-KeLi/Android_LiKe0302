package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.android_like0302.MyFirstDialog;
import com.example.android_like0302.R;

import java.util.Calendar;

public class C03_05_task2 extends AppCompatActivity {
    Button button,button14,button15,button16,button17,button18,button19,button20;
    boolean flag[]=new boolean[]{false,false,true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0305_task2);
       init();
    }
    private void init(){
        button=(Button) findViewById(R.id.button);
        button14=(Button) findViewById(R.id.button14);
        button15=(Button) findViewById(R.id.button15);
        button16=(Button) findViewById(R.id.button16);
        button17=(Button) findViewById(R.id.button17);
        button18=(Button) findViewById(R.id.button18);
        button19=(Button) findViewById(R.id.button19);
        button20=(Button) findViewById(R.id.button20);
        button.setOnClickListener(new MyListenrer());
        button14.setOnClickListener(new MyListenrer());
        button15.setOnClickListener(new MyListenrer());
        button16.setOnClickListener(new MyListenrer());
        button17.setOnClickListener(new MyListenrer());
        button18.setOnClickListener(new MyListenrer());
        button19.setOnClickListener(new MyListenrer());
        button20.setOnClickListener(new MyListenrer());
    }
    class MyListenrer implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button://通知对话框
                    //创建AlterDialog对象
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(C03_05_task2.this);
                    //2.设置对话框标题
                    builder1.setTitle("通知类对话框");
                    //3.设置内容
                    builder1.setMessage("成年人的第二个通知对话框");
                    //4.设置对话框图标
                    builder1.setIcon(R.drawable.t301_chicken);
                    //5.设置确定按钮
                    builder1.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(C03_05_task2.this, "这是确认啦", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //6.设置取消按钮
                    builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(C03_05_task2.this, "这是取消啦", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //7.根据builder1创建dialo
                    AlertDialog dialog1 = builder1.create();
                    //8.将AlertDialog展示出来
                    dialog1.show();
                    break;
                case R.id.button14://单选按钮的AlertDialog
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(C03_05_task2.this);
                    builder2.setTitle("成年人的第一个单选通知对话框");
                    builder2.setIcon(R.drawable.t301_cow);
                    //builder2.setMessage("成年人的第一个单选类对话框");
                    //设置单选按钮！！！！！！！！！！
                    builder2.setSingleChoiceItems(new String[]{"选项一", "选项二", "默认"}, 2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    //设置确定
                    builder2.setPositiveButton("确定", ((dialogInterface, i) -> {
                        Toast.makeText(C03_05_task2.this, "点击了确认", Toast.LENGTH_SHORT).show();
                    }));
                    //设置取消
                    builder2.setNegativeButton("取消", ((dialogInterface, i) -> {
                        Toast.makeText(C03_05_task2.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }));
                    //创建AlertDialog对象
                    AlertDialog dialog2 = builder2.create();
                    //将AD展现出来
                    dialog2.show();
                    break;
                case R.id.button15://多选对话框
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(C03_05_task2.this);
                    builder3.setTitle("成年人的第一个多选通知对话框");
                    builder3.setIcon(R.drawable.t301_dog);
                    //设置多选按钮
                    builder3.setMultiChoiceItems(new String[]{"选项一", "选项二", "选项三"}, flag, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            flag[i] = b;
                        }
                    });
                    builder3.setPositiveButton("确认", ((dialogInterface, i) -> {
                        Toast.makeText(C03_05_task2.this, "我是确定啦", Toast.LENGTH_SHORT).show();
                    }));
                    builder3.setNegativeButton("取消", ((dialogInterface, i) -> {
                        Toast.makeText(C03_05_task2.this, "我是取消啦", Toast.LENGTH_SHORT).show();
                    }));
                    AlertDialog dialog3 = builder3.create();
                    dialog3.show();
                    break;
                case R.id.button16://进度条对话框
                    //ProgressDialog.show静态方法
                    //show（）的五个参数
                    //1.上下文
                    //2.标题
                    //3.提示信息
                    //4.indeterminate:不明确（false）就是滚动条的值在最小值和最大值之间来回滚动，只是告诉别人我正在工作，但不能提示工作进行到了哪个阶段
                    //5.cancelable:当该属性为true时，意味着该对话框可以被取消,且点击ProgressDialog以外的区域也可以让ProgressDialog小时
                    ProgressDialog.show(C03_05_task2.this, "成年人的第一个进度条对话框", "提示信息：正在加载中", false, true);
                    break;
                case R.id.button17://日期选择器对话框
                    Calendar calendar = Calendar.getInstance();
                    //直接创建一个DatePickerDialog实例，并把它显示出来
                    //方法DatePickerDialog（Context context,OnDateSetListener claaback,int year, int monthOfYear,int dayOfMonth）
                    new DatePickerDialog(C03_05_task2.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            Toast.makeText(C03_05_task2.this, "您选择了:"+i+"年"+i1+"月"+i2+"日", Toast.LENGTH_SHORT).show();
                        }
                    },calendar.get(Calendar.YEAR)
                     ,calendar.get(Calendar.MONTH)
                     ,calendar.get(Calendar.DAY_OF_MONTH)).show();
                      break;
                case R.id.button18://时间选择器
                    Calendar calendar1 =Calendar.getInstance();
                    //直接创建一个DatePickerDialog实例，并把它显示出来
                    //方法TimePickerDialog（Context context,OnTimeSetListener cllaback,int hourOfDay, int minute,boolean is24HourView）
                    new TimePickerDialog(C03_05_task2.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        }
                    },calendar1.get(Calendar.HOUR_OF_DAY)
                     ,calendar1.get(Calendar.MINUTE),
                            true).show();//true表示采取24小时制度
                    break;
                case R.id.button19://自定义Dialog
                    final MyFirstDialog myFirstDialog =new MyFirstDialog(C03_05_task2.this);
                   // myDialog.setTitle("年轻人的第一次尝试自定义");
                   // myDialog.setMessage("你好，世界！");
                    myFirstDialog.setPositive("确认");
                   // myDialog.setNegative("取消");

                    myFirstDialog.setOnClickListner(new MyFirstDialog.OnClickListener() {
                        @Override
                        public void onPositiveClick() {
                       myFirstDialog.dismiss();
                        }

                        @Override
                        public void OnNegativeClick() {
                      myFirstDialog.dismiss();
                        }
                    });
                    myFirstDialog.show();
                    break;
                case R.id.button20:
                    AlertDialog.Builder builder7=new AlertDialog.Builder(C03_05_task2.this);
                    builder7.setView(R.layout.activity_my_dialog);
                    AlertDialog dialog7=builder7.create();
                    dialog7.show();
            }
        }
    }
}