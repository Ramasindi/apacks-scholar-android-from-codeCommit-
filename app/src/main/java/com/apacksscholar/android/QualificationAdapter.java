package com.apacksscholar.android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class QualificationAdapter extends ArrayAdapter<Qualification> {


    public QualificationAdapter(Activity context, ArrayList<Qualification> qualifications){
        super(context,0,qualifications);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.qualification_list, parent, false);
        }

        Qualification currentQualification = getItem(position);

        TextView qCode = listItemView.findViewById(R.id.qCode);
        qCode.setText(currentQualification.getQualificationCode());

        TextView qName = listItemView.findViewById(R.id.qName);
        qName.setText(currentQualification.getmQualificationName());

        TextView faculty = listItemView.findViewById(R.id.faculty);
        faculty.setText(currentQualification.getFacultyName());

        TextView level = listItemView.findViewById(R.id.level);
        level.setText(currentQualification.getLevel());

        TextView type = listItemView.findViewById(R.id.type);
        type.setText(currentQualification.getmType());

        TextView campus = listItemView.findViewById(R.id.campus);
        campus.setText(currentQualification.getCampus());

        TextView careers = listItemView.findViewById(R.id.career);
        careers.setText(currentQualification.getCareers());

        TextView minimum_aps = listItemView.findViewById(R.id.minimum_aps);
        minimum_aps.setText(currentQualification.getMinimumAps());

        TextView duration = listItemView.findViewById(R.id.duration);
        duration.setText(currentQualification.getDuration());

        TextView additional_recognised_language = listItemView.findViewById(R.id.additional_language);
        additional_recognised_language.setText(currentQualification.getAdditionalRecognisedLanguage());

        TextView english = listItemView.findViewById(R.id.english);

        if (currentQualification.hasData()) {
            english.setText(currentQualification.getEnglish());
        }else{
            english.setVisibility(View.GONE);
        }
        //english.setText(currentQualification.getEnglish());

        TextView mathematics = listItemView.findViewById(R.id.mathematics);
        if (currentQualification.hasData()) {
            mathematics.setText(currentQualification.getMathematics());
        }else{
            mathematics.setVisibility(View.GONE);
        }
        //mathematics.setText(currentQualification.getMathematics());

        TextView mathematical_literacy = listItemView.findViewById(R.id.mathematical_literacy);
        if (currentQualification.hasData()) {
            mathematical_literacy.setText(currentQualification.getMathematicsLiteracy());
        }else{
            mathematical_literacy.setVisibility(View.GONE);
        }
       // mathematical_literacy.setText(currentQualification.getMathematicsLiteracy());

        TextView geography = listItemView.findViewById(R.id.geography);
        if (currentQualification.hasData()) {
            geography.setText(currentQualification.getGeography());
        }else{
            geography.setVisibility(View.GONE);
        }
        //geography.setText(currentQualification.getGeography());

        TextView life_science = listItemView.findViewById(R.id.life_science);
        if (currentQualification.hasData()) {
            life_science.setText(currentQualification.getLifeScience());
        }else{
            life_science.setVisibility(View.GONE);
        }
        //life_science.setText(currentQualification.getLifeScience());

        TextView afrikaans = listItemView.findViewById(R.id.afrikaans);
        if (currentQualification.hasData()) {
            afrikaans.setText(currentQualification.getAfrikaans());
        }else{
            afrikaans.setVisibility(View.GONE);
        }
        //afrikaans.setText(currentQualification.getAfrikaans());

        TextView physical_science = listItemView.findViewById(R.id.physical_science);
        if (currentQualification.hasData()) {
            physical_science.setText(currentQualification.getPhysicalScience());
        }else{
            physical_science.setVisibility(View.GONE);
        }
        //physical_science.setText(currentQualification.getPhysicalScience());

        return listItemView;
    }
}
