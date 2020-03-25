package com.apacksscholar.android;


import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QualificationQuery {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String API_KEY = "6R0fjbrb4T1QthfDIIqbvlzQ6heKjAc1vSCPCYQd";

    private QualificationQuery(){
    }
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.addRequestProperty(API_KEY_HEADER, API_KEY);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the e JSON results.", e);

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {

                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<Qualification> fetchQualificationData(String requestUrl) {
        // Create URL object
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }


        List<Qualification> qualifications = extractFeatureFromJson(jsonResponse);

        return qualifications;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    private static List<Qualification> extractFeatureFromJson(String qualificationJSON) {

        if (TextUtils.isEmpty(qualificationJSON)) {
            return null;
        }
        List<Qualification> qualifications = new ArrayList<>();
        try {

            // JSONObject baseResponse = new JSONObject(universityJSON);


            JSONArray qualificationArray = new JSONArray(qualificationJSON);



            //TODO: length is not correct
            for (int i = 0; i < qualificationArray.length(); i++) {

                JSONObject currentQualification = qualificationArray.getJSONObject(i);


                String mQualificationCode = currentQualification.getString("qualification_code");
                String mQualificationName = currentQualification.getString("qualification_name");
                String mFacultyName = currentQualification.getString("faculty_name");
                String mLevel = currentQualification.getString("level");
                String mType = currentQualification.getString("type");
                String mCampus = currentQualification.getString("campus");
                String mCareers = currentQualification.getString("careers");
                String mMinimumAps = currentQualification.getString("minimum_aps");
                String mDuration = currentQualification.getString("duration");
                String mAdditionalRecognisedLanguage = currentQualification.getString("additional_recognised_language");
                String mMathematics;
                String mMathematicsLiteracy;
                String mLifeScience;
                String mEnglish;
                String mGeography;
                String mAfrikaans;
                String mPhysicalScience;
//                if (currentQualification.getString("mathematics").isEmpty() || currentQualification.getString("mathematics").contains("N/A") ) {
//                    mMathematics = "N/A";
//                }else{
//                     mMathematics = currentQualification.getString("mathematics");
//                }
//               // String mMathematics = currentQualification.getString("mathematics");
//                if (currentQualification.getString("mathematical_literacy").isEmpty()) {
//                    mMathematicsLiteracy = "N/A";
//                }else{
//                    mMathematicsLiteracy = currentQualification.getString("mathematical_literacy");
//                }
//
//                 //mMathematicsLiteracy = currentQualification.getString("mathematical_literacy");
//                // mLifeScience = currentQualification.getString("life_science");
//                if (currentQualification.getString("life_science").isEmpty()) {
//                    mLifeScience = "N/A";
//                }else{
//                    mLifeScience = currentQualification.getString("life_science");
//                }
//
//                if (currentQualification.getString("english").isEmpty()) {
//                    mEnglish = "N/A";
//                }else{
//                    mEnglish = currentQualification.getString("english");
//                }
//
//                //mEnglish = currentQualification.getString("english");
//                // mGeography = currentQualification.getString("geography");
//
//                if (currentQualification.getString("geography").isEmpty()) {
//                    mGeography = "N/A";
//                }else{
//                    mGeography = currentQualification.getString("geography");
//                }

                //mAfrikaans = currentQualification.getString("afrikaans");

//                if (currentQualification.getString("afrikaans").isEmpty() || currentQualification.getString("afrikaans").contains("N/A") ) {
//                    mAfrikaans = "N/A";
//                }else{
//                    mAfrikaans = currentQualification.getString("afrikaans");
//                }

                //String mPhysicalScience = currentQualification.getString("physical_science");

//                if (currentQualification.getString("physical_science").isEmpty()) {
//                    mPhysicalScience  = "N/A";
//                }else{
//                    mPhysicalScience  = currentQualification.getString("physical_science");
//                }

                Qualification qualification = new Qualification("Qualification Code: " + mQualificationCode,"Qualification Name: " + mQualificationName,"Faculty: " + mFacultyName,
                        "Level: " + mLevel,"Type: " + mType,"Campus: " + mCampus,"Careers: " +  mCareers,"Minimum APS: " + mMinimumAps,
                        "Duration: " + mDuration, "Additional Recognised Language: " + mAdditionalRecognisedLanguage,"mMathematics",
                         "mMathematicsLiteracy", "mLifeScience", "mEnglish", "mGeography",
                        "Afrikaans", "mPhysicalScience");


                qualifications.add(qualification);
            }

        } catch (JSONException e) {

            Log.e("QualificationQuery", "Problem parsing JSON results", e);
        }


        return qualifications;
    }

}
