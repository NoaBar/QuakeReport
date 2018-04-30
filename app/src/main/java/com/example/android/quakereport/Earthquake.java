package com.example.android.quakereport;

public class Earthquake {

    /**
     * Magnitude of earthquake
     */
    private String mMag;

    /**
     * Loacation of earthquake
     */
    private String mLoacation;

    /**
     * Date of earthquake
     */
    private String mDate;

    /**
     * Constructor
     * Create a new Earthquake object.
     * @param mag is the Magnitude of earthquake
     * @param location is the Loacation of earthquake
     * @param date Date of earthquake
     */
    public Earthquake(String mag, String location, String date){
        mMag= mag;
        mLoacation= location;
        mDate= date;

    }

    /**Getters
     */

    public String getMag(){
        return mMag;
    }

    public String getLoacation(){
        return mLoacation;
    }

    public String getDate(){
        return mDate;
    }

}
