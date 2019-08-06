package com.example.android.accenturenewjoiners.Activities;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<GetNews>> {
    private String mURL;

    public NewsLoader(Context context, String URL) {
        super(context);
        mURL = URL;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<GetNews> loadInBackground() {
        if (mURL == null) {
            return null;
        }
        List<GetNews> result = QueryUtils.fetchNewsData(mURL);
        return result;
    }}