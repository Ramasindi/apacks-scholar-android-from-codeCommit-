package com.apacksscholar.android;

public class University {

    private String mUniversityName;
    private String mUniversityWebsite;
    private int mUniversityLogoId;
    private String mNationalRanking;
    private String mInternationalRanking;
    private String mProvince;
    private String mPhysicalAddress;
    private String mLatLong;
    private int mInstitutionId;
    private int mPhotosLink;

    public University(String universityName, String universityWebsite,int universityLogoId,
                      String nationalRanking,String internationalRanking, String province,
                      String physicalAddress, String latLong,int institutionId, int photoLink){
     mUniversityName = universityName;
     mUniversityWebsite = universityWebsite;
     mUniversityLogoId = universityLogoId;
     mNationalRanking = nationalRanking;
     mInternationalRanking = internationalRanking;
     mProvince = province;
     mPhysicalAddress = physicalAddress;
     mLatLong = latLong;
     mInstitutionId = institutionId;
     mPhotosLink = photoLink;
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
    public String getNationalRanking(){return mNationalRanking;}
    public String getInternationalRanking(){return mInternationalRanking;}
    public String getProvince(){return mProvince;}
    public String getPhysicalAdress(){return mPhysicalAddress;}
    public String getLatLong(){return mLatLong;}
    public int getInstitutionId(){return mInstitutionId;}
    public int getPhotosLink(){return mPhotosLink;}

}

