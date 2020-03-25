package com.apacksscholar.android;

import android.content.Context;


import android.content.AsyncTaskLoader;
import java.util.List;

public class QualificationLoader extends AsyncTaskLoader<List<Qualification>> {

/** Tag for log messages */
//private static final String LOG_TAG = UniversityLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link UniversityLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public QualificationLoader(Context context, String url) {
        super(context);

        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Qualification> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of qualifications.
        List<Qualification> qualifications = QualificationQuery.fetchQualificationData(mUrl);
        return qualifications;
    }
}
