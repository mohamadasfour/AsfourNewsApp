package com.example.android.newsapp;

import android.graphics.Bitmap;

public class News {



    private String mSection;

    private String mTitle;

    private String mDate;

    private String mAuthor;

    private Bitmap mImage;

    private String mURL;




    // Set one constructor, containing all the info from the News object
    public News(String section, String title, String date, String author, Bitmap image, String url ) {
        mSection = section;
        mTitle = title;
        mDate = date;
        mAuthor = author;
        mImage = image;
        mURL = url;
    }

    public String getSection() {
        return mSection;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getDate() {
        return mDate;
    }
    public String getAuthor() {
        return mAuthor;
    }
    public Bitmap getImage() {
        return mImage;
    }
    public String getUrl() {
        return mURL;
    }

}
