package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.model.Lesson;
import com.example.hp.mycampus.util.InfoUtil;

import java.io.Serializable;
import java.util.ArrayList;

public class FillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        Button button_testing = (Button) findViewById(R.id.button_test);
        button_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  course course = new course(courseName, teacher, classRoom, Integer.valueOf(day), Integer.valueOf(start), Integer.valueOf(end));
             /*   ArrayList<Lesson> lessons =  new ArrayList<Lesson>();
                Lesson lesson1 = new Lesson("模式识别","怀念","3区 1-605","1","3","5");
                Lesson lesson2 = new Lesson("电子商务与电子政务","陈艳娇","3区 1-201","1","6","7");
                Lesson lesson3 = new Lesson("系统级程序设计","韩波","3区 605","2","3","5");
                Lesson lesson4 = new Lesson("软件体系结构","刘浩文","3区 1-631","2","6","8");
                lessons.add(lesson1);
                lessons.add(lesson2);
                lessons.add(lesson3);
                lessons.add(lesson4);*/
                ArrayList<Lesson> lessons =InfoUtil.getLessons();

                Intent intent = new Intent(FillActivity.this, CourseActivity.class);
                //传递实例
                //intent.putExtra("course", course);
                intent.putExtra("lessons",(Serializable)lessons);
                setResult(1, intent);
                finish();
                //startActivity(intent);
            }
        });
    }
}
