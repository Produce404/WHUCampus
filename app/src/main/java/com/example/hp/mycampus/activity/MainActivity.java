package com.example.hp.mycampus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.model.Information;
import com.example.hp.mycampus.util.InfoUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {

    private CardView select_lesson;
    private CardView select_score;
    private CardView select_news;
    private CardView select_lost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示用户信息
        Information studentInfo=InfoUtil.getInformation();
        TextView textView=(TextView) findViewById(R.id.textView27);
        textView.setText(studentInfo.getId()+"-"+studentInfo.getName());

        //设置课表查询按钮的监听
        select_lesson=(CardView) findViewById(R.id.lesson);
        select_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(intent);
            }

        });

        //设置通知查询按钮的监听
        select_news=(CardView) findViewById(R.id. news);
        select_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }

        });

        //设置成绩查询按钮的监听
        select_score=(CardView) findViewById(R.id.score);
        select_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });

        //设置失物招领按钮的监听
        select_lost=(CardView) findViewById(R.id.lost);
        select_lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(MainActivity.this, LostActivity.class);
                startActivity(intent);
            }
        });
    }
}



