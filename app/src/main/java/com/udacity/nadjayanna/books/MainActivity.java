package com.udacity.nadjayanna.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);

        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("TITULO 1",  "DESCRIÇÃO LIVRO 1"));
        books.add(new Book("TITULO 2", "DESCRIÇÃO LIVRO 2"));

        // specify an adapter
        mAdapter = new BookAdapter(books);

        //set the adapter in the view
        mRecyclerView.setAdapter(mAdapter);
    }
}
