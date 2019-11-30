package com.apacksscholar.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<University> universities = new ArrayList<>();

        universities.add(new University("University of Johannesburg","www.uj.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("University of Pretoria","www.up.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("Vaal University of Technology","www.vut.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("University of Free State","www.ufs.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("University of Witswaterand","www.wits.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("Tshwane University of Technology","www.tut.ac.za",R.mipmap.ic_launcher));
        universities.add(new University("University of CapeTown","www.uct.ac.za",R.mipmap.ic_launcher));

        UniversityAdapter adapter = new UniversityAdapter(this,universities);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                University university = universities.get(position);
                Intent intent = new Intent(MainActivity.this, UniversityDetailedView.class);
                intent.putExtra("University Name", university.getUniversityName());
                intent.putExtra("Website", university.getUniversityWebsite());
                intent.putExtra("LOGO", university.getUniversityLogoId());
                startActivity(intent);
            }
        });

    }
}
