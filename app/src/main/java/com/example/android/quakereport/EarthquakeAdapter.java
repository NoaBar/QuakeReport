package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.DecimalFormat;

import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";
    Activity activity;

    public EarthquakeAdapter(Activity activity, ArrayList<Earthquake> earthquakes) {
        super(activity, 0, earthquakes);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        //Displaying the magnitude as a Decimal Value
        TextView mag = (TextView) listItemView.findViewById(R.id.mag);

        DecimalFormat formatMagnitude = new DecimalFormat("0.0");
        String magStringFormatted = formatMagnitude.format(currentEarthquake.getMag());
        mag.setText(magStringFormatted);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMag());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //splitting the location variable to 2 text parts using the separator "of"
        TextView location_offset = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primary_location = (TextView) listItemView.findViewById(R.id.primary_location);

        String originalLocation = currentEarthquake.getLocation();

        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        location_offset.setText(locationOffset);
        primary_location.setText(primaryLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        date.setText(formattedDate);

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        time.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        //According to the documentation, the switch statement cannot accept a double value,
        // so we should convert our decimal magnitude value into an integer.
        //We can use the Math class to do some handy mathematical calculations.
        // In this case, we can take the “floor” of the decimal magnitude value.
        // This means finding the closest integer less than the decimal value.
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        //You can call ContextCompat getColor() to convert the color resource ID into an actual integer color value,
        // and return the result as the return value of the getMagnitudeColor() helper method.
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
