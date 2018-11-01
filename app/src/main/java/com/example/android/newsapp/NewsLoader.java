package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String requestUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        requestUrl = url;
    }

    @Override
    public List<News> loadInBackground() {
        // Do all the network job here

        return QueryUtils.fetchNewsData(requestUrl);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
