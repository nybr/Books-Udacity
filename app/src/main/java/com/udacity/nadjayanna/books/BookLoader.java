package com.udacity.nadjayanna.books;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by nadja on 28/08/2017.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>>{

    private String mUrl;

    public BookLoader(Context context, String url) {
        super(context);
        this.mUrl=url;
    }

    @Override
    public List<Book> loadInBackground() {

        List<Book> result = null;

        if (mUrl == null || mUrl.isEmpty()){
            return null;
        }

        result = Utils.fetchBookData(mUrl);
        return result;
    }
}
