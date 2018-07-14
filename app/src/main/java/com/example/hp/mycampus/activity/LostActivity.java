package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hp.mycampus.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LostActivity extends AppCompatActivity {
    private String[] Title={"丢失手机","捡到钱包","丢失校园卡","捡到校园卡","妈呀","这啥呀"};
    List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        for(int i=0;i<Title.length;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("title",Title[i]);
            list.add(map);
        }
        ListView listview=(ListView) this.findViewById(R.id.listView);
        listview.setAdapter(new MyAdapter());

    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder mHolder;
            if(convertView==null){
                view= LayoutInflater.from(LostActivity.this).inflate(R.layout.lost_item,null);
                mHolder=new ViewHolder();
                mHolder.card_title=(TextView)view.findViewById(R.id.cardTitle);
                view.setTag(mHolder);  //将ViewHolder存储在View中
            }else {
                view=convertView;
                mHolder=(ViewHolder)view.getTag();  //重新获得ViewHolder
            }
            mHolder.card_title.setText(list.get(position).get("title").toString());
            return view;
        }
    }

    class ViewHolder{
        TextView card_title;
    }
    }

