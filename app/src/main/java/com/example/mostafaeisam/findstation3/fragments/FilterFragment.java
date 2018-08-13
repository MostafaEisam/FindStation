package com.example.mostafaeisam.findstation3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mostafaeisam.findstation3.FindStation;
import com.example.mostafaeisam.findstation3.classes.FilterStations;
import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.classes.SortStations;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterFragment extends Fragment {
    @BindView(R.id.ck_restaurant)
    AppCompatCheckBox mCkRestaurant;
    @BindView(R.id.ck_mosque)
    AppCompatCheckBox mCkMosque;
    @BindView(R.id.ck_coffee)
    AppCompatCheckBox mCkCoffee;
    @BindView(R.id.ck_womenToilet)
    AppCompatCheckBox mCkWomenToilet;
    @BindView(R.id.ck_menToilet)
    AppCompatCheckBox mCkMenToilet;
    @BindView(R.id.ck_hotel)
    AppCompatCheckBox mCkHotel;
    @BindView(R.id.ck_atm)
    AppCompatCheckBox mCkATM;
    @BindView(R.id.ck_gas91)
    AppCompatCheckBox mCkGas91;
    @BindView(R.id.ck_gas95)
    AppCompatCheckBox mCkGas95;
    @BindView(R.id.ck_dsl)
    AppCompatCheckBox mCkDsl;
    @BindView(R.id.iv_gas91)
    ImageView mIvGas91;
    @BindView(R.id.iv_gas95)
    ImageView mIvGas95;
    @BindView(R.id.iv_dsl)
    ImageView mIvDsl;

    private FilterStations filterStations = new FilterStations();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.filter_fragment,container,false);
        ButterKnife.bind(this,view);

        setPreviousFilters();

        mCkGas91.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedGas91(true);
                    mIvGas91.setImageResource(R.drawable.fuel_91_on);

                }else{
                    filterStations.setCheckedGas91(false);
                    mIvGas91.setImageResource(R.drawable.fuel_91_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkGas95.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedGas95(true);
                    mIvGas95.setImageResource(R.drawable.fuel_95_on);
                }else{
                    filterStations.setCheckedGas95(false);
                    mIvGas95.setImageResource(R.drawable.fuel_95_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkDsl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedDsl(true);
                    mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                }else{
                    filterStations.setCheckedDsl(false);
                    mIvDsl.setImageResource(R.drawable.fuel_diesel_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkRestaurant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedRestaurant(true);
                }else{
                    filterStations.setCheckedRestaurant(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkMosque.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedMosque(true);
                }else{
                    filterStations.setCheckedMosque(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkCoffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedCoffee(true);
                }else{
                    filterStations.setCheckedCoffee(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkWomenToilet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedWomenToilet(true);
                }else{
                    filterStations.setCheckedWomenToilet(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkMenToilet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedMenToilet(true);
                }else{
                    filterStations.setCheckedMenToilet(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkHotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedHotel(true);
                }else{
                    filterStations.setCheckedHotel(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkATM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    filterStations.setCheckedATM(true);
                }else{
                    filterStations.setCheckedATM(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        //FindStation.setFilterStations(filterStations);

        return view;

    }

    private void setPreviousFilters() {

        if (FindStation.getFilterStations()!=null)
        {
            FilterStations filterStationsPrev = FindStation.getFilterStations();
            if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedHotel() && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
                mCkHotel.setChecked(true);
                mCkATM.setChecked(true);

            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if(filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
            }
            // Three Filter Choose
            // Gas91
            else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedDsl()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);

            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedRestaurant() ){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedRestaurant()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkRestaurant.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMosque.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMosque.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMosque.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMosque.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkCoffee.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkCoffee.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkCoffee.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedMenToilet() ){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkWomenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkWomenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkMenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedHotel()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkHotel.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedRestaurant()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
            }
            // Gas95
            else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMosque()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedCoffee()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedWomenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedCoffee()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedMenToilet()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkWomenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedWomenToilet()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkWomenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedHotel()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMenToilet()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedHotel()
                    && filterStationsPrev.isCheckedATM()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkHotel.setChecked(true);
                mCkATM.setChecked(true);
            }
            // Two Filter Choose
            else if (filterStationsPrev.isCheckedGas91() && filterStationsPrev.isCheckedGas95()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedDsl()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedRestaurant()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkRestaurant.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedMosque()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedCoffee()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedWomenToilet()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedHotel()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedGas95() && filterStationsPrev.isCheckedATM()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedRestaurant()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkRestaurant.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedMosque()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedCoffee()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedWomenToilet()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedMenToilet()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedHotel()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedDsl() && filterStationsPrev.isCheckedATM()) {
                mCkDsl.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_diesel_on);
                mCkATM.setChecked(true);
            }
            else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedMosque()) {
                mCkRestaurant.setChecked(true);
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedCoffee()) {
                mCkRestaurant.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedWomenToilet()) {
                mCkRestaurant.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedMenToilet()) {
                mCkRestaurant.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedHotel()) {
                mCkRestaurant.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedRestaurant() && filterStationsPrev.isCheckedATM()) {
                mCkRestaurant.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedCoffee()) {
                mCkMosque.setChecked(true);
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedWomenToilet()) {
                mCkMosque.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedMenToilet()) {
                mCkMosque.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedHotel()) {
                mCkMosque.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque() && filterStationsPrev.isCheckedATM()) {
                mCkMosque.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedCoffee() && filterStationsPrev.isCheckedWomenToilet()) {
                mCkCoffee.setChecked(true);
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedCoffee() && filterStationsPrev.isCheckedMenToilet()) {
                mCkCoffee.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedCoffee() && filterStationsPrev.isCheckedHotel()) {
                mCkCoffee.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedCoffee() && filterStationsPrev.isCheckedATM()) {
                mCkCoffee.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedMenToilet()) {
                mCkWomenToilet.setChecked(true);
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedHotel()) {
                mCkWomenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedWomenToilet() && filterStationsPrev.isCheckedATM()) {
                mCkWomenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedMenToilet() && filterStationsPrev.isCheckedHotel()) {
                mCkMenToilet.setChecked(true);
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedMenToilet() && filterStationsPrev.isCheckedATM()) {
                mCkMenToilet.setChecked(true);
                mCkATM.setChecked(true);
            }else if (filterStationsPrev.isCheckedHotel() && filterStationsPrev.isCheckedATM()){
                mCkHotel.setChecked(true);
                mCkATM.setChecked(true);
            }
            
            // One Filter Choose
            else if (filterStationsPrev.isCheckedGas91()){
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
            }else if (filterStationsPrev.isCheckedGas95()){
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
            }else if (filterStationsPrev.isCheckedDsl()){
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
            }else if (filterStationsPrev.isCheckedRestaurant()){
                mCkRestaurant.setChecked(true);
            }else if (filterStationsPrev.isCheckedMosque()){
                mCkMosque.setChecked(true);
            }else if (filterStationsPrev.isCheckedCoffee()){
                mCkCoffee.setChecked(true);
            }else if (filterStationsPrev.isCheckedWomenToilet()){
                mCkWomenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedMenToilet()){
                mCkMenToilet.setChecked(true);
            }else if (filterStationsPrev.isCheckedHotel()){
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedHotel()){
                mCkHotel.setChecked(true);
            }else if (filterStationsPrev.isCheckedATM()){
                mCkATM.setChecked(true);
            }
        }
    }
}
