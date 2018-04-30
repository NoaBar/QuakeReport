package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * Time of earthquake
     */
    private long mTimeInMilliseconds;

    /**
     * Constructor
     * Create a new Earthquake object.
     * @param mag is the Magnitude of earthquake
     * @param location is the Loacation of earthquake
     * @param timeInMilliseconds Date of earthquake
     */
    public Earthquake(String mag, String location, long timeInMilliseconds){
        mMag= mag;
        mLoacation= location;
        mTimeInMilliseconds= timeInMilliseconds;
    }

    /**Getters
     */

    public String getMag(){
        return mMag;
    }

    public String getLoacation(){
        return mLoacation;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
    public String getDate(){
        Date dateOfEarthquake = new Date(mDate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, YYYY");
        String dateToDisplay = dateFormatter.format(dateOfEarthquake);

        return dateToDisplay;
    }
**/
}
