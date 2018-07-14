package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.mycampus.R;

public class NewsShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_show);
        Intent intent = getIntent();
        int chosenPosition= (int)intent.getExtras().get("chosenPosition");
        //工具条
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView1 = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.text);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        switch (chosenPosition) {
            case 0:
                textView1.setText((String) this.getResources().getText(R.string.title0));
                textView2.setText((String) this.getResources().getText(R.string.text0));
                break;
            case 1:
                textView1.setText((String) this.getResources().getText(R.string.title1));
                textView2.setText((String) this.getResources().getText(R.string.text1));
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.news1));
                textView1.setGravity(Gravity.CENTER);
                textView2.setGravity(Gravity.CENTER);
                break;
            case 2:
                textView1.setText((String) this.getResources().getText(R.string.title2));
                textView2.setText((String) this.getResources().getText(R.string.text2));
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.news2));
                break;
            case 3:
                textView1.setText((String) this.getResources().getText(R.string.title3));
                textView2.setText((String) this.getResources().getText(R.string.text3));
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.news3));
                textView1.setGravity(Gravity.CENTER);
                textView2.setGravity(Gravity.CENTER);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.like_menu:
                Intent intent = new Intent(NewsShowActivity.this, AddCourseActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.collect_menu:
                Intent intent1 = new Intent(NewsShowActivity.this, FillActivity.class);
                startActivityForResult(intent1, 1);
                break;
        }
        return true;
    }
}
