package com.example.mostafaeisam.findstation3.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mostafaeisam.findstation3.FindStation;
import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.classes.SortStations;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortFragment extends Fragment {
    @BindView(R.id.rg_sort)
    RadioGroup mRgSort;
    private SortStations sortStations = new SortStations();
    private FindStation findStation = new FindStation();
    @BindView(R.id.rb_nearest)
    RadioButton nearest;
    @BindView(R.id.rb_farthest)
    RadioButton farthest;
    @BindView(R.id.rb_priceHighest)
    RadioButton priceHighest;
    @BindView(R.id.rb_priceLowest)
    RadioButton priceLowest;
    @BindView(R.id.rb_starsHighest)
    RadioButton starsHighest;
    @BindView(R.id.rb_starsLowest)
    RadioButton starsLowest;
    @BindView(R.id.rb_namesFromAtoZ)
    RadioButton namesFromAtoZ;
    @BindView(R.id.rb_namesFromZtoA)
    RadioButton namesfromZtoA;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sort_fragment,container,false);
        ButterKnife.bind(this,view);

        setPreviousSort();

        mRgSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (nearest.isChecked()){
                    sortStations.setByNearest(true);
                }else {
                    sortStations.setByNearest(false);
                }
                findStation.setSortStations(sortStations);

                if (farthest.isChecked()){
                    sortStations.setByFarthest(true);
                }else {
                    sortStations.setByFarthest(false);
                }
                findStation.setSortStations(sortStations);

                if (priceHighest.isChecked()){
                    sortStations.setByPriceHighest(true);
                }else {
                    sortStations.setByPriceHighest(false);
                }
                findStation.setSortStations(sortStations);

                if (priceLowest.isChecked()){
                    sortStations.setByPriceLoweset(true);
                }else {
                    sortStations.setByPriceLoweset(false);
                }
                findStation.setSortStations(sortStations);

                if (starsHighest.isChecked()){
                    sortStations.setByStarsHighest(true);
                }else {
                    sortStations.setByStarsHighest(false);
                }
                findStation.setSortStations(sortStations);

                if (starsLowest.isChecked()){
                    sortStations.setByStarsLowest(true);
                }else {
                    sortStations.setByStarsLowest(false);
                }
                findStation.setSortStations(sortStations);

                if (namesFromAtoZ.isChecked()){
                    sortStations.setByNamesfromAtoZ(true);
                }else {
                    sortStations.setByNamesfromAtoZ(false);
                }
                findStation.setSortStations(sortStations);

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

    private void setPreviousSort() {
        if (findStation.getSortStations()!= null){
            SortStations sortPreviousStations = findStation.getSortStations();
            if (sortPreviousStations.isByNearest()){
                nearest.setChecked(true);
            }else if (sortPreviousStations.isByFarthest()){
                farthest.setChecked(true);
            }else if (sortPreviousStations.isByPriceHighest()){
                priceHighest.setChecked(true);
            }else if (sortPreviousStations.isByPriceLoweset()){
                priceLowest.setChecked(true);
            }else if (sortPreviousStations.isByStarsHighest()){
                starsHighest.setChecked(true);
            }else if (sortPreviousStations.isByStarsLowest()){
                starsLowest.setChecked(true);
            }else if (sortPreviousStations.isByNamesfromAtoZ()){
                namesFromAtoZ.setChecked(true);
            }else if (sortPreviousStations.isByNamesfromZtoA()){
                namesfromZtoA.setChecked(true);
            }
        }
    }
}
