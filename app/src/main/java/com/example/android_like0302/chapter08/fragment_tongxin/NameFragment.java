package com.example.android_like0302.chapter08.fragment_tongxin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_like0302.R;


public class NameFragment extends Fragment {
    ListView listView;

    //因为要把剧名显示在Listview中，所以要获取名字
    String[] name;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //1.获取宿主Activity
        Fragment_mainac mainac = (Fragment_mainac) getActivity();
        name = mainac.getName();
        //2.加载布局
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        //3.获取控件
        listView = view.findViewById(R.id.fragcall_listview);
        //4.绑定Adapter
        ArrayAdapter adapter = new ArrayAdapter(mainac, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(adapter);
        //5.绑定事件监听器,点击某一布局上，更新现显示的额呢绒
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取ContentFragment对象
                ContentFragment contentFragment = (ContentFragment) getActivity().getSupportFragmentManager().findFragmentByTag("content");
                //更新显示的内容
                contentFragment.setName(position);
                contentFragment.setImage(position);
                contentFragment.setRating(position);
                contentFragment.setIntroduce(position);
            }

        });
        return view;
    }
}