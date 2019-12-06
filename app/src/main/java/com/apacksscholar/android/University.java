package com.apacksscholar.android;

public class University {

    private String mUniversityName;
    private String mUniversityWebsite;
    private int mUniversityLogoId;

    public University(String universityName, String universityWebsite,int universityLogoId){
     mUniversityName = universityName;
     mUniversityWebsite = universityWebsite;
     mUniversityLogoId = universityLogoId;
    }

    public University() {
    }

    public  String getUniversityName(){
        return mUniversityName;
    }

    public  String getUniversityWebsite(){
        return mUniversityWebsite;
    }
    public int getUniversityLogoId(){
        return mUniversityLogoId;
    }
}
