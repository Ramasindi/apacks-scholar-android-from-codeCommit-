package com.apacksscholar.android;

import android.app.Activity;
import android.net.Uri;
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

//        TextView detailedUniversity = listItemView.findViewById(R.id.universityName_textView);
//        detailedUniversity.setText(currentUniversity.getUniversityName());
//
//        TextView universityWesite = listItemView.findViewById(R.id.website_textView);
//        universityWesite.setText(currentUniversity.getUniversityWebsite());
//
//        TextView nationalRanking;
//        nationalRanking = listItemView.findViewById(R.id.nationalRanking);
//        nationalRanking.setText(currentUniversity.getNationalRanking());
//
//        TextView internationalRanking = listItemView.findViewById(R.id.international_ranking);
//        internationalRanking.setText(currentUniversity.getInternationalRanking());
//
//        TextView province = listItemView.findViewById(R.id.province);
//        province.setText(currentUniversity.getProvince());
//
//        TextView physicalAddress = listItemView.findViewById(R.id.physicalAddress);
//        physicalAddress.setText(currentUniversity.getPhysicalAdress());
//
//        TextView latLong = listItemView.findViewById(R.id.lat_long);
//        latLong.setText(currentUniversity.getLatLong());


        TextView university = listItemView.findViewById(R.id.universityName_textView);
        university.setText(currentUniversity.getUniversityName());
        TextView website = listItemView.findViewById(R.id.website_textView);
        website.setText(currentUniversity.getUniversityWebsite());



       ImageView universityLogo = listItemView.findViewById(R.id.universityLogo);
        universityLogo.setImageBitmap(currentUniversity.getUniversityLogoId());

       //universityLogo.setImageURI(u);

        return listItemView;
    }
}
