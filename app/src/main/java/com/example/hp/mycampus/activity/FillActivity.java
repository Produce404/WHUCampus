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
                ArrayList<Lesson> lessons =  new ArrayList<Lesson>();
                //Lesson lesson1 = new Lesson("模式识别","怀念","3区 1-605","1","3","5");
                //Lesson lesson2 = new Lesson("电子商务与电子政务","陈艳娇","3区 1-201","1","6","7");
                //Lesson lesson3 = new Lesson("系统级程序设计","韩波","3区 605","2","3","5");
                //Lesson lesson4 = new Lesson("软件体系结构","刘浩文","3区 1-631","2","6","8");
                Lesson lesson1 = new Lesson("沙雕安卓","","","1","3","5");
                Lesson lesson2 = new Lesson("沙雕安卓","","","2","3","5");
                Lesson lesson3 = new Lesson("沙雕安卓","","","3","3","5");
                Lesson lesson4 = new Lesson("沙雕安卓","","","4","3","5");
                Lesson lesson5 = new Lesson("沙雕安卓","","","5","3","5");
                Lesson lesson6 = new Lesson("沙雕安卓","","","6","3","5");
                Lesson lesson7 = new Lesson("沙雕安卓","","","7","3","5");
                Lesson lesson8 = new Lesson("沙雕安卓","","","1","6","8");
                Lesson lesson9 = new Lesson("沙雕安卓","","","2","6","8");
                Lesson lesson10 = new Lesson("沙雕安卓","","","3","6","8");
                Lesson lesson11 = new Lesson("沙雕安卓","","","4","6","8");
                Lesson lesson12 = new Lesson("沙雕安卓","","","5","6","8");
                Lesson lesson13 = new Lesson("沙雕安卓","","","6","6","8");
                Lesson lesson14 = new Lesson("沙雕安卓","","","7","6","8");


                lessons.add(lesson1);
                lessons.add(lesson2);
                lessons.add(lesson3);
                lessons.add(lesson4);
                lessons.add(lesson5);
                lessons.add(lesson6);
                lessons.add(lesson7);
                lessons.add(lesson8);
                lessons.add(lesson9);
                lessons.add(lesson10);
                lessons.add(lesson11);
                lessons.add(lesson12);
                lessons.add(lesson13);
                lessons.add(lesson14);
                //登录后获取用户的课程信息
                //ArrayList<Lesson> lessons =InfoUtil.getLessons();

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
