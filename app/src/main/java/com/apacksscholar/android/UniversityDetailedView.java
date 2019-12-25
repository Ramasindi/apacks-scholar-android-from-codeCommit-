package com.apacksscholar.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URLEncoder;

public class UniversityDetailedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_detailed_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView universityNameText = findViewById(R.id.universityDetailed_name);

        TextView universityWebsiteText = findViewById(R.id.detaildeWebsite);

        TextView nationalRanking = findViewById(R.id.nationalRanking);

        TextView internationalRanking = findViewById(R.id.international_ranking);


        TextView province = findViewById(R.id.province);


        TextView physicalAddress = findViewById(R.id.physicalAddress);


        final TextView latLong = findViewById(R.id.lat_long);


        Intent intent = getIntent();

        String universityName = intent.getStringExtra("University Name");
        final String mUniversityWebsite = intent.getStringExtra("Website");
        String mNationalRanking = intent.getStringExtra("NationalRanking");
        String mInternationalRanking = intent.getStringExtra("InternationalRanking");
        String mProvince = intent.getStringExtra("Province");
        final String mLatLong = intent.getStringExtra("LatLong");
        String mPhysicalAddress = intent.getStringExtra("PhysicalAddress");
        //final String universityWebsite = intent.getStringExtra("Website");
        //String universityLogoId = intent.getStringExtra("LOGO");


        universityNameText.setText(universityName);
        nationalRanking.setText("National Ranking: " + mNationalRanking);
        internationalRanking.setText("International Ranking: " +mInternationalRanking);
        province.setText("Province: " + mProvince);
        physicalAddress.setText("Physical Address: " + mPhysicalAddress);
        latLong.setText("Latitude,Longitude: " + mLatLong);

        universityWebsiteText.setText("Website: " + mUniversityWebsite);


        latLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
//                locationIntent.setData(Uri.parse("https://www.google.com/search?q=" + mLatLong));
//                startActivity(locationIntent);

                //String url = "";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:" + mLatLong));



                startActivity(i);

            }
        });


        universityWebsiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert the String URL into a URI object (to pass into the Intent constructor)


                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse(mUniversityWebsite ));
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


    }

//    @Override
//    public void onBackPressed() {
//        //super.onBackPressed();
//        //finish();
//        startActivity(new Intent(UniversityDetailedView.this, MainActivity.class));
//
//    }
}
