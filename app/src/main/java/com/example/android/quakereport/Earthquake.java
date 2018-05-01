package com.example.android.quakereport;


public class Earthquake {

    /**
     * Magnitude of earthquake
     */
    private double mMag;

    /**
     * Loacation of earthquake
     */
    private String mLocation;

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
    public Earthquake(double mag, String location, long timeInMilliseconds){
        mMag= mag;
        mLocation= location;
        mTimeInMilliseconds= timeInMilliseconds;
    }

    /**Getters
     */

    public double getMag(){
        return mMag;
    }

    public String getLocation(){
        return mLocation;
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
