package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.adapter.TimeRecycleAdapter;
import com.example.hp.mycampus.adapter.myItemTouchHelperCallBack;
import com.example.hp.mycampus.model.Lesson;
import com.example.hp.mycampus.model.Time;
import com.example.hp.mycampus.util.TimeDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity {

    // 1. 声明一个对象，一个适配器 和 一个数据结构
    RecyclerView recyclerView;
    TimeRecycleAdapter adapter;
    List<Time> list;

    //SQLite Helper类
    private TimeDatabaseHelper timeDatabaseHelper = new TimeDatabaseHelper
            (this, "timedatabase.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        //工具条
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 2. 获取对象
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // 3. 设定 布局管理，如果设定为 gridLayoutManger 则为 Grid 布局
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        // 4. 初始化数据
        list = new ArrayList<>();
        loadData();
        // 5. 实例化一个adapter,并建立关联
        adapter = new TimeRecycleAdapter(list, this,timeDatabaseHelper);

        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new myItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);


    }



    //从数据库加载数据
    private void loadData() {
        SQLiteDatabase sqLiteDatabase =  timeDatabaseHelper.getWritableDatabase();
        //执行SQL语句
        //sqLiteDatabase.execSQL("insert into time(name, date) values('计算机组成', '2018年7月4日')");
        //游标，表示每一行的集合
        Cursor cursor = sqLiteDatabase.rawQuery("select * from time", null);
        if (cursor.moveToFirst()) {
            do {
                list.add(new Time(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("date"))
                       ));
            } while(cursor.moveToNext());
        }
        cursor.close();

        //使用从数据库读取出来的课程信息来加载课程表视图
        for (Time time : list) {
          System.out.println(time.getName());
        }
    }

    //保存数据到数据库  1.打开数据库2.执行SQL语句
    private void saveData(Lesson lesson) {
        //当数据库不可写入时，getReadableDatabase()以只读的方式打开数据库，而getWritableDatabase()会出现异常
        SQLiteDatabase sqLiteDatabase =  timeDatabaseHelper.getWritableDatabase();
        //执行SQL语句
        sqLiteDatabase.execSQL("insert into time(name, date) values('计算机组成', '2018年7月4日')");
    }

    //获取创建课表中的course实例
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == 0 && data != null) {
            Time time_single = (Time) data.getSerializableExtra("time");
            SQLiteDatabase sqLiteDatabase =  timeDatabaseHelper.getWritableDatabase();
            //执行SQL语句
            String name=time_single.getName();
            String date=time_single.getDate();
            sqLiteDatabase.execSQL("insert into time(name,date) " + "values(?, ?)",
                    new String[] {name, date});
            loadData();
            refresh();
        }
    }

    public void refresh() {
        Intent intent = new Intent(TimeActivity.this, TimeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.time_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_menu:
                Intent intent = new Intent(TimeActivity.this, AddTimeActivity.class);
                startActivityForResult(intent, 0);
                break;
        }
        return true;
    }
}