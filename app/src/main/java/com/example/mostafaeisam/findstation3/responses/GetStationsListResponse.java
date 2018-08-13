package com.example.mostafaeisam.findstation3.responses;

import com.example.mostafaeisam.findstation3.classes.Station;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetStationsListResponse {
    @SerializedName("Stations")
    private ArrayList<Station> stationsList;

    public ArrayList<Station> getStationsList() {
        return stationsList;
    }

    public void setStationsList(ArrayList<Station> stationsList) {
        this.stationsList = stationsList;
    }
}
