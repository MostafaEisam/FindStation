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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_fragment, container, false);
        ButterKnife.bind(this, view);

        setPreviousFilters();

        mCkGas91.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedGas91(true);
                    mIvGas91.setImageResource(R.drawable.fuel_91_on);

                } else {
                    filterStations.setCheckedGas91(false);
                    mIvGas91.setImageResource(R.drawable.fuel_91_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkGas95.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedGas95(true);
                    mIvGas95.setImageResource(R.drawable.fuel_95_on);
                } else {
                    filterStations.setCheckedGas95(false);
                    mIvGas95.setImageResource(R.drawable.fuel_95_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkDsl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedDsl(true);
                    mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
                } else {
                    filterStations.setCheckedDsl(false);
                    mIvDsl.setImageResource(R.drawable.fuel_diesel_off);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkRestaurant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedRestaurant(true);
                } else {
                    filterStations.setCheckedRestaurant(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkMosque.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedMosque(true);
                } else {
                    filterStations.setCheckedMosque(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkCoffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedCoffee(true);
                } else {
                    filterStations.setCheckedCoffee(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkWomenToilet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedWomenToilet(true);
                } else {
                    filterStations.setCheckedWomenToilet(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkMenToilet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedMenToilet(true);
                } else {
                    filterStations.setCheckedMenToilet(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkHotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedHotel(true);
                } else {
                    filterStations.setCheckedHotel(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        mCkATM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    filterStations.setCheckedATM(true);
                } else {
                    filterStations.setCheckedATM(false);
                }
                FindStation.setFilterStations(filterStations);

            }
        });

        return view;

    }

    private void setPreviousFilters() {

        if (FindStation.getFilterStations() != null) {
            filterStations = FindStation.getFilterStations();

             if (filterStations.isCheckedGas91()) {
                mCkGas91.setChecked(true);
                mIvGas91.setImageResource(R.drawable.fuel_91_on);
            }

            if (filterStations.isCheckedGas95()) {
                mCkGas95.setChecked(true);
                mIvGas95.setImageResource(R.drawable.fuel_95_on);
            }

            if (filterStations.isCheckedDsl()) {
                mCkDsl.setChecked(true);
                mIvDsl.setImageResource(R.drawable.fuel_diesel_on);
            }

            if (filterStations.isCheckedRestaurant()) {
                mCkRestaurant.setChecked(true);
            }

            if (filterStations.isCheckedMosque()) {
                mCkMosque.setChecked(true);
            }

            if(filterStations.isCheckedCoffee()) {
                mCkCoffee.setChecked(true);
            }

            if (filterStations.isCheckedWomenToilet()) {
                mCkWomenToilet.setChecked(true);
            }

            if (filterStations.isCheckedMenToilet()) {
                mCkMenToilet.setChecked(true);
            }

            if (filterStations.isCheckedHotel()) {
                mCkHotel.setChecked(true);
            }

            if (filterStations.isCheckedATM()) {
                mCkATM.setChecked(true);
            }
        }
    }
}
