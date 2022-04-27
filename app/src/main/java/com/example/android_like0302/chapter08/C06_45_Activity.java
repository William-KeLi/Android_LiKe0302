package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class C06_45_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button taocan1,taocan2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0645);
        init();
    }
    private void init(){
        taocan1=(Button) findViewById(R.id.taocan1);
        taocan2=(Button) findViewById(R.id.taocan2);
        taocan1.setOnClickListener(this);
        taocan2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //创建FragmentManage
        FragmentManager fragmentManager=getSupportFragmentManager();
        //创建FragmentTanscisition
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //创建Fragment对象
        Fragment fragment1=new C06_45_dongtaif2();
        Fragment fragment2=new C06_45_dongtaif3();
        switch (v.getId()){
            case R.id.taocan1:
                fragmentTransaction.replace(R.id.baomihua,fragment1);
                break;
            case R.id.taocan2:
                fragmentTransaction.replace(R.id.baomihua,fragment2);
                break;
        }
        fragmentTransaction.commit();
    }
}