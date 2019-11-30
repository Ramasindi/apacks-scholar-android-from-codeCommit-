package com.apacksscholar.android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class UniversityAdapter extends ArrayAdapter<University> {

    public UniversityAdapter(Activity context, ArrayList<University> universities){
        super(context,0,universities);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.university_list, parent, false);
        }

        University currentUniversity = getItem(position);

        TextView university = listItemView.findViewById(R.id.universityName_textView);
        university.setText(currentUniversity.getUniversityName());

        TextView universityWesite = listItemView.findViewById(R.id.website_textView);
        universityWesite.setText(currentUniversity.getUniversityWebsite());

        ImageView universityLogo = listItemView.findViewById(R.id.universityLogo);
        universityLogo.setImageResource(currentUniversity.getUniversityLogoId());

        return listItemView;
    }
}
