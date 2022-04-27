package com.example.android_like0302.chapter05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_like0302.R;

public class C03_05_Practise01_waibu extends AppCompatActivity {
    Button button;
    int count=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0305_practise01);
        init();
    }
    private void init() {
        button = (Button) findViewById(R.id.button_practise01);
        button.setOnClickListener(new MyListeners(button, count));
    }
}

//这是外部类事件监听器
class MyListeners  implements  View.OnClickListener{
    Button button;
    int count;
    public MyListeners(Button button,int count){
        this.button=button;
        this.count=count;
    }
    public void onClick(View v) {
        count++;
        button.setText("我被点击了" + count + "次");
    }

}


