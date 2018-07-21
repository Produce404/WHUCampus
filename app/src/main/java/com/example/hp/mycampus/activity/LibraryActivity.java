package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.SharedLibraryInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.adapter.LibraryAdapter;
import com.example.hp.mycampus.model.Book;
import com.example.hp.mycampus.util.LibraryInfo;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private ArrayList<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("历史借阅");
        toolbar.setNavigationIcon(R.drawable.btn_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LibraryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        bookList = LibraryInfo.getHistoryList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LibraryAdapter adapter = new LibraryAdapter(bookList);
        recyclerView.setAdapter(adapter);
    }
}