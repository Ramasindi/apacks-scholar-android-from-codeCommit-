package com.example.apexscholar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UniversityDetailedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_detailed_view);
        TextView universityNameText = findViewById(R.id.universityDetailed_name);
        TextView universityWebsiteText = findViewById(R.id.detaildeWebsite);



        Intent intent = getIntent();

        String universityName = intent.getStringExtra("University Name");
        final String universityWebsite = intent.getStringExtra("Website");
        //String universityLogoId = intent.getStringExtra("LOGO");
        universityNameText.setText(universityName);

        universityWebsiteText.setText(universityWebsite);

        universityWebsiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert the String URL into a URI object (to pass into the Intent constructor)


                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse("http://" + universityWebsite ));
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


    }
}
