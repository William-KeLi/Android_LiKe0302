package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C06_13 extends AppCompatActivity {
    //1.定义资源
    String[] names ={"李克","曹云逸","王志鹏","张安岭","张舒飞"};
    String[] telephones ={"17852368325","1550982408","17563416062","15966007371","13176487195"};
    String[] messages={"你好帅，能留个微信吗","听说你云顶很吊，solo吗","我专门喜欢挑战打篮球厉害的，约吗","内部福利，点击即看，不要在人多的地方打开哦",
    "额，请问一下，怎么追女朋友"};
    int[] pic={R.drawable.like,R.drawable.caoyunyi,R.drawable.wangzhipeng,R.drawable.zhanganling2,R.drawable.zhangshufei};
  //2.定义ListView对象
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0613);
        init();
    }
    private void init(){
        //3.绑定Lisiview
        listView=(ListView) findViewById(R.id.duanxin);

        //4.定义List集合
        List<Map<String,Object>> data = new ArrayList<>();
        //5.通过循环，将数据填入Map集合，并将Map放入List集合
        for (int i =0;i<=4;i++){
            HashMap map=new HashMap();
            map.put("name",names[i]);
            map.put("telephone",telephones[i]);
            map.put("message",messages[i]);
            map.put("touxiang",pic[i]);

            data.add(map);
        }

        //6.创建SimpleAdapter适配器对象
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,
                data,
                R.layout.little_table_2,
                new String[]{"name","telephone","message","touxiang"},
                new int[]{R.id.textView46,R.id.textView44,R.id.textView45,R.id.imageView28});

        //7.将Adapter绑定到ListView上
        listView.setAdapter(simpleAdapter);

        //8.设值监听器玩玩
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //取出信息
                Toast.makeText(C06_13.this, "此时一个帅哥点击了我", Toast.LENGTH_SHORT).show();
            }
        });
    }
}