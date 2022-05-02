package com.example.android_like0302.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android_like0302.R;

import com.example.android_like0302.chapter06.c0410_task1.page1;
import com.example.android_like0302.chapter06.c0418_task2.task2_page1;
import com.example.android_like0302.chapter06.c0432_task2.C04_32_page01;
import com.example.android_like0302.chapter06.c0433_practise03.C04_33;
import com.example.android_like0302.chapter06.c0438_tak4.C04_38;
import com.example.android_like0302.chapter06.practise01.practise_page1;

public class list extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.chapter06_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent();
                switch (position){
                    case 0:
                        intent.setClass(getApplicationContext(), page1.class);
                        break;
                    case 1:
                        intent.setClass(getApplicationContext(), task2_page1.class);
                        break;
                    case 2:
                        intent.setClass(getApplicationContext(), C04_32_page01.class);
                        break;
                    case 3:
                        intent.setClass(getApplicationContext(), C04_38.class);
                        break;
                    case 4:
                        intent.setClass(getApplicationContext(), practise_page1.class);
                        break;
                    case 5:
                        intent.setClass(getApplicationContext(), C04_33.class);
                        break;
                    case 6:
                        intent.setClass(getApplicationContext(), C04_39.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}