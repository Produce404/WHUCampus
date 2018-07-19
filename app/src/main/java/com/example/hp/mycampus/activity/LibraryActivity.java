package com.example.hp.mycampus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.SharedLibraryInfo;
import android.os.Bundle;
import android.os.StrictMode;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.adapter.LibraryAdapter;
import com.example.hp.mycampus.model.Book;
import com.example.hp.mycampus.util.LibraryInfo;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        LibraryInfo.Login("2016302580332", "260050");
        bookList = LibraryInfo.getHistoryList();
        //init();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LibraryAdapter adapter = new LibraryAdapter(bookList);
        recyclerView.setAdapter(adapter);
    }
    private void init(){
        Book a = new Book("Math");
        bookList.add(a);
        Book b = new Book("Chinese");
        bookList.add(b);
    }
}