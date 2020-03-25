package com.apacksscholar.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String API_KEY = "4ypcmvmBYk2siQMkjcGB0aLXRLFTisexaeW9fTSL";

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
                String mUniversityLogo = currentUniversity.getString("logo_link");
                //int mInstitutionId  = currentUniversity.getInt("institution_id");
                //int mPhotosLink = currentUniversity.getInt("photos_link");

                /////////////////////////////////////////////////////////////////////////////////////
                URL imageURL = null;
                Bitmap bitmap = null;

                try {
                    imageURL = new URL(mUniversityLogo);
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection connection = (HttpURLConnection) imageURL
                            .openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (IOException e){
                    e.printStackTrace();
                }




                /////////////////////////////////////////////////////////////////////////////////////

                University university = new University(mUniversityName, mUniversityWebsite, bitmap
                        , mNationalRanking, mInternationalRanking,mProvince,mPhysicalAddress,mLatLong
                        ,1,1);


                universities.add(university);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing JSON results", e);
        }


        return universities;
    }
//    public Bitmap loadImage(String ut12){
//        Log.v("ut12--", ut12);
//        URL imageURL = null;
//        Bitmap bitmap = null;
//
//        try {
//            imageURL = new URL(ut12);
//        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            HttpURLConnection connection = (HttpURLConnection) imageURL
//                    .openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            bitmap = BitmapFactory.decodeStream(inputStream);
//        } catch (IOException e){
//         e.printStackTrace();
//        }
//        return  bitmap;
//    }
    }
