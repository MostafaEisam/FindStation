package com.example.mostafaeisam.findstation3;

import android.app.Application;

import com.example.mostafaeisam.findstation3.classes.FilterStations;
import com.example.mostafaeisam.findstation3.classes.SortStations;

public class FindStation extends Application {

    public static FilterStations filterStations;
    public static SortStations sortStations;


    public static FilterStations getFilterStations() {
        return filterStations;
    }

    public static void setFilterStations(FilterStations filterStations) {
        FindStation.filterStations = filterStations;
    }

    public static SortStations getSortStations() {
        return sortStations;
    }

    public static void setSortStations(SortStations sortStations) {
        FindStation.sortStations = sortStations;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
