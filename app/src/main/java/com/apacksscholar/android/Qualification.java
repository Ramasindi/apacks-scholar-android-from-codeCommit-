package com.apacksscholar.android;

public class Qualification {

    private static final String NO_DATA_PROVIDED = "N/A";
    private String data = NO_DATA_PROVIDED;
    private String mQualificationCode;
    private String mQualificationName;
    private String mFacultyName;
    private String mLevel;
    private String mType;
    private String mCampus;
    private String mCareers;
    private String mMinimumAps;
    private String mDuration;
    private String mAdditionalRecognisedLanguage;
    private String mMathematics;
    private String mMathematicsLiteracy;
    private String mLifeScience;
    private String mEnglish;
    private String mGeography;
    private String mAfrikaans;
    private String mPhysicalScience;


    public Qualification(String qualificationCode, String qualificationName,String faculyName,
                         String level,String type, String campus,String careers,String minimumAps,
                         String duration, String additionalRecognisedLanguage,String mathematics,
                         String mathematicsLiteracy,String lifeScience,String english,String geography,
                         String afrikaans,String physicalScience){
        mQualificationCode = qualificationCode;
        mQualificationName = qualificationName;
        mFacultyName = faculyName;
        mLevel = level;
        mType = type;
        mCampus = campus;
        mCareers = careers;
        mMinimumAps = minimumAps;
        mDuration = duration;
        mAdditionalRecognisedLanguage = additionalRecognisedLanguage;
        mMathematics = mathematics;
        mMathematicsLiteracy = mathematicsLiteracy;
        mLifeScience = lifeScience;
        mEnglish = english;
        mGeography = geography;
        mAfrikaans = afrikaans;
        mPhysicalScience = physicalScience;
    }

    public Qualification(){
    }

    public String getQualificationCode(){
        return mQualificationCode;
    }
    public  String getmQualificationName(){
        return mQualificationName;
    }
    public String getFacultyName(){
        return mFacultyName;
    }
    public String getLevel(){
        return mLevel;
    }
    public String getmType(){
        return mType;
    }
    public String getCampus(){
        return mCampus;
    }
    public String getCareers(){
        return mCareers;
    }
    public String getMinimumAps(){
        return mMinimumAps;
    }
    public String getDuration(){
        return mDuration;
    }
    public String getAdditionalRecognisedLanguage(){
        return mAdditionalRecognisedLanguage;
    }
    public String getMathematics(){
        return mMathematics;
    }
    public String getMathematicsLiteracy(){
        return mMathematicsLiteracy;
    }
    public String getLifeScience(){
        return mLifeScience;
    }
    public String getEnglish(){
        return mEnglish;
    }
    public String getGeography(){
        return mGeography;
    }
    public String getAfrikaans(){
        return mAfrikaans;
    }
    public String getPhysicalScience(){
        return mPhysicalScience;
    }
    public boolean hasData() {
        return data != NO_DATA_PROVIDED;
    }

}
