package com.example.mostafaeisam.findstation3.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mostafaeisam.findstation3.FindStation;
import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.classes.SortStations;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

public class SortFragment extends Fragment {
    @BindView(R.id.rg_sort)
    RadioGroup mRgSort;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sort_fragment,container,false);
        ButterKnife.bind(this,view);
        FindStation findStation = new FindStation();
        final SortStations sortStations = new SortStations();
        mRgSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton nearest = group.findViewById(R.id.rb_nearest);
                RadioButton farthest = group.findViewById(R.id.rb_farthest);
                RadioButton priceHighest = group.findViewById(R.id.rb_priceHighest);
                RadioButton priceLowest = group.findViewById(R.id.rb_priceLowest);
                RadioButton starsHighest = group.findViewById(R.id.rb_starsHighest);
                RadioButton starsLowest = group.findViewById(R.id.rb_starsLowest);
                RadioButton namesFromAtoZ = group.findViewById(R.id.rb_namesFromAtoZ);
                RadioButton namesfromZtoA = group.findViewById(R.id.rb_namesFromZtoA);

                if (nearest.isChecked()){
                    sortStations.setByNearest(true);
                }else {
                    sortStations.setByNearest(false);
                }

                if (farthest.isChecked()){
                    sortStations.setByFarthest(true);
                }else {
                    sortStations.setByFarthest(false);
                }

                if (priceHighest.isChecked()){
                    sortStations.setByPriceHighest(true);
                }else {
                    sortStations.setByPriceHighest(false);
                }

                if (priceLowest.isChecked()){
                    sortStations.setByPriceLoweset(true);
                }else {
                    sortStations.setByPriceLoweset(false);
                }

                if (starsHighest.isChecked()){
                    sortStations.setByStarsHighest(true);
                }else {
                    sortStations.setByStarsHighest(false);
                }

                if (starsLowest.isChecked()){
                    sortStations.setByStarsLowest(true);
                }else {
                    sortStations.setByStarsLowest(false);
                }

                if (namesFromAtoZ.isChecked()){
                    sortStations.setByNamesfromAtoZ(true);
                }else {
                    sortStations.setByNamesfromAtoZ(false);
                }

                if (namesfromZtoA.isChecked()){
                    sortStations.setByNamesfromZtoA(true);
                }else {
                    sortStations.setByNamesfromZtoA(false);
                }
            }



        });

        findStation.setSortStations(sortStations);
        return view;
    }
}
