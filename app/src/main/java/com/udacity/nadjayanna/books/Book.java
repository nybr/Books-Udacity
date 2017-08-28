package com.udacity.nadjayanna.books;

/**
 * Created by nadja on 27/08/2017.
 */

public class Book {

    private String mPreviewLink;
    private String mImageLink;
    private String [] mCategories;
    private String mTitle;
    private String [] mAuthors;
    private String mPublisher;
    private String mDescription;

    public Book(String title, String description) {
        this.mTitle = title;
        this.mDescription = description;
    }

    public Book(String title, String description, String imageLink) {
        this.mTitle = title;
        this.mDescription = description;
        this.mImageLink = imageLink;
    }

    public Book(String previewLink, String[] categories, String title, String[] authors, String publisher, String description) {
        this.mPreviewLink = previewLink;
        this.mCategories = categories;
        this.mTitle = title;
        this.mAuthors = authors;
        this.mPublisher = publisher;
        this.mDescription = description;
    }

    public Book(String previewLink, String imageLink, String[] categories, String title, String[] authors, String publisher, String description) {
        this.mPreviewLink = previewLink;
        this.mImageLink = imageLink;
        this.mCategories = categories;
        this.mTitle = title;
        this.mAuthors = authors;
        this.mPublisher = publisher;
        this.mDescription = description;
    }

    public String getPreviewLink() {
        return mPreviewLink;
    }

    public String getImageLink() {
        return mImageLink;
    }

    public String[] getCategories() {
        return mCategories;
    }

    public String getTitle() {
        return mTitle;
    }

    public String[] getAuthors() {
        return mAuthors;
    }

    public String getmPublisher() {
        return mPublisher;
    }

    public String getDescription() {
        return mDescription;
    }
}
