package com.apacksscholar.android;

import android.text.TextUtils;
import android.util.Log;

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

public class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils(){
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
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);

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

    public static List<University> fetchUniversityData(String requestUrl) {
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


        List<University> universities = extractFeatureFromJson(jsonResponse);

        return universities;
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

    private static List<University> extractFeatureFromJson(String universityJSON) {

        if (TextUtils.isEmpty(universityJSON)) {
            return null;
        }
        List<University> universities = new ArrayList<>();
        try {

           // JSONObject baseResponse = new JSONObject(universityJSON);


            JSONArray universityArray = new JSONArray(universityJSON);



            //TODO: length is not correct
            for (int i = 0; i < universityArray.length(); i++) {

                JSONObject currentUniversity = universityArray.getJSONObject(i);


                String mUniversityName = currentUniversity.getString("name");
                String mUniversityWebsite = currentUniversity.getString("website");
                String mNationalRanking = currentUniversity.getString("national_ranking");
                String mInternationalRanking = currentUniversity.getString("international_ranking");
                String mProvince = currentUniversity.getString("province");
                String mLatLong = currentUniversity.getString("lat_long");
                String mPhysicalAddress = currentUniversity.getString("physical_address");
                //int mUniversityLogo = currentUniversity.getInt("logo_link");
                //int mInstitutionId  = currentUniversity.getInt("institution_id");
                //int mPhotosLink = currentUniversity.getInt("photos_link");

                University university = new University(mUniversityName, mUniversityWebsite, 1
                        , mNationalRanking, mInternationalRanking,mProvince,mPhysicalAddress,mLatLong
                        ,1,1);


                universities.add(university);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }


        return universities;
    }

    }
