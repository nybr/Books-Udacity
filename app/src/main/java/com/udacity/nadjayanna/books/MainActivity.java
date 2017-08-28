package com.udacity.nadjayanna.books;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>>{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final String FAKE_JSON = "{\"boolean\": true,\"null\": null,\"items\": [{\"id\": \"1\",\"volumeInfo\":{\"title\": \"titulo1\",\"author\":[\"a1\", \"b1\"],\"publisher\": \"f1\",\"description\":\"string description 1\",\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=jD9cCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=jD9cCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"}},\"searchInfo\": {\"a\": \"b\",\"c\":\"d\",\"e\": \"f\"}},{\"id\": \"2\",\"volumeInfo\": {\"title\": \"titulo2\",\"author\": [\"a2\", \"b2\"],\"publisher\": \"f2\",\"description\":\"string description 2\",\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=joUrDQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=jD9cCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"}},\"searchInfo\": {\"a\": \"b\",\"c\": \"d\",\"e\": \"f\"}}],\"number\": 123,\"object\": {\"a\": \"b\",\"c\": \"d\",\"e\": \"f\"},\"string\": \"Hello World\"}";
    private static final String BOOKS_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
    private static final int BOOK_LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(BOOK_LOADER_ID, null, this).forceLoad();
    }

    private void updateUi(List<Book> books) {
        mRecyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);

        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //ArrayList<Book> books = Utils.extractBooks(FAKE_JSON);

        // specify an adapter
        mAdapter = new BookAdapter(books);

        //set the adapter in the view
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(MainActivity.this, BOOKS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {

        updateUi(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {

        updateUi(new ArrayList<Book>());
    }
}
