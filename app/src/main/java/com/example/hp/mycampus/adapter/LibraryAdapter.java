package com.example.hp.mycampus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.mycampus.R;
import com.example.hp.mycampus.model.Book;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {

    private List<Book> mbook;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView book_name;

        public ViewHolder(View view){
            super(view);
            book_name = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public LibraryAdapter(List<Book> bookList){
        mbook = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mbook.get(position);
        holder.book_name.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return mbook.size();
    }
}
