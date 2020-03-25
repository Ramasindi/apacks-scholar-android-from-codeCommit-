package com.apacksscholar.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class UniversityQualification extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Qualification>> {

    private static final String QUALIFICATION_REQUEST_URL = "https://w4vklu1mac.execute-api.eu-west-1.amazonaws.com/PROD/list?dynamodb_table=DYNAMODB_TABLE_UJ";
    private TextView mEmptyStateTextView;
    private static final int QUALIFICATION_LOADER_ID = 1;
    private QualificationAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_qualification);
        ListView listView = findViewById(R.id.qualification_list);

        mAdapter = new QualificationAdapter(this, new ArrayList<Qualification>());
        listView.setAdapter(mAdapter);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(QUALIFICATION_LOADER_ID, null, this);
        }else {

            View loadingIndicator = findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView = findViewById(R.id.empty1_view);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<Qualification>> onCreateLoader(int id, Bundle args) {
        return new QualificationLoader(this, QUALIFICATION_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Qualification>> loader, List<Qualification> data) {
        ProgressBar progressBar = findViewById(R.id.loading_spinner);
        progressBar.setVisibility(View.GONE);

        mEmptyStateTextView = findViewById(R.id.empty1_view);

        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        } else {

            mEmptyStateTextView.setText(R.string.no_universities);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Qualification>> loader) {
        mAdapter.clear();
    }

}
