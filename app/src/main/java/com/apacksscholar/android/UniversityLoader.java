package com.apacksscholar.android;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class UniversityLoader extends AsyncTaskLoader<List<University>> {

/** Tag for log messages */
private static final String LOG_TAG = UniversityLoader.class.getName();

/** Query URL */
private String mUrl;

/**
 * Constructs a new {@link UniversityLoader}.
 *
 * @param context of the activity
 * @param url to load data from
 */
public UniversityLoader(Context context, String url) {
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
public List<University> loadInBackground() {

        if (mUrl == null) {
        return null;
        }

        // Perform the network request, parse the response, and extract a list of universities.
        List<University> universities = QueryUtils.fetchUniversityData(mUrl);
        return universities;
        }
}
