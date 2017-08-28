package com.udacity.nadjayanna.books;

/**
 * Created by nadja on 27/08/2017.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Utility class with methods to help perform the HTTP request and
 * parse the response.
 */

public class Utils {

    /** Tag for the log messages */
    public static final String LOG_TAG = Utils.class.getSimpleName();

    /**
     * Return a list of {@link Book} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Book> extractBooks (String bookJSON){

        //Create an empty ArrayList to start adding books to
        ArrayList<Book> books = new ArrayList<>();

        //Tr to parse the JSON. If there's a problem a JSONException will be thrown.

        try {
            JSONObject baseJsonResponse = new JSONObject(bookJSON);
            JSONArray bookArray = baseJsonResponse.getJSONArray("items");

            //looping through all books
            for (int i=0; i<bookArray.length(); i++){
                JSONObject currentBook = bookArray.getJSONObject(i);
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");

                String title = volumeInfo.getString("title");
                String description = volumeInfo.getString("description");

                JSONObject linkImagem = volumeInfo.getJSONObject("imageLinks");
                String imageLink = linkImagem.getString("smallThumbnail");

                books.add(new Book(title,description, imageLink));
            }

        }catch (JSONException e){
            Log.e(LOG_TAG, "Problem parsing the book JSON results", e);
        }
        return books;
    }
}
