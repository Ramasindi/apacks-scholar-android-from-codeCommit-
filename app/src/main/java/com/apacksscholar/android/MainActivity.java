package com.apacksscholar.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<University>> {

    private static final String APACKS_REQUEST_URL = "https://7n23t5hjz0.execute-api.eu-west-1.amazonaws.com/Prod/list/";

    private TextView mEmptyStateTextView;


    private static final int UNIVERSITY_LOADER_ID = 1;

    private UniversityAdapter mAdapter;



   // ApiClientFactory factory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // factory = new ApiClientFactory().apiKey("4ypcmvmBYk2siQMkjcGB0aLXRLFTisexaeW9fTSL");







//        AWSCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
//                this,          // activity context
//                "identityPoolId", // Cognito identity pool id
//                Regions.US_EAST_1 // region of Cognito identity pool
//        );
//
//         factory = new ApiClientFactory()
//                .credentialsProvider(credentialsProvider);







        ListView listView = findViewById(R.id.list);

        mAdapter = new UniversityAdapter(this, new ArrayList<University>());


        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               University currentUniversity = mAdapter.getItem(position);

                Intent intent = new Intent(MainActivity.this, UniversityDetailedView.class);
                intent.putExtra("University Name", currentUniversity.getUniversityName());
                intent.putExtra("PhysicalAddress", currentUniversity.getPhysicalAdress());
                intent.putExtra("NationalRanking", currentUniversity.getNationalRanking());
                intent.putExtra("Province", currentUniversity.getProvince());
                intent.putExtra("Website", currentUniversity.getUniversityWebsite());
                intent.putExtra("InternationalRanking", currentUniversity.getInternationalRanking());
                intent.putExtra("LatLong", currentUniversity.getLatLong());
                startActivity(intent);



    }
});

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();


            loaderManager.initLoader(UNIVERSITY_LOADER_ID, null, this);
        }else {

            View loadingIndicator = findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.GONE);


            mEmptyStateTextView = findViewById(R.id.empty1_view);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<University>> onCreateLoader(int id, Bundle args) {
        return new UniversityLoader(this, APACKS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<University>> loader, List<University> data) {
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
    public void onLoaderReset(Loader<List<University>> loader) {
        mAdapter.clear();
    }


}
