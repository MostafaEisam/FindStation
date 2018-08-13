package com.example.mostafaeisam.findstation3.activites;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.mostafaeisam.findstation3.FindStation;
import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.classes.FilterStations;
import com.example.mostafaeisam.findstation3.fragments.FilterFragment;
import com.example.mostafaeisam.findstation3.fragments.SortFragment;
import com.example.mostafaeisam.findstation3.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        ButterKnife.bind(this);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new SortFragment(),"SORT");
        adapter.AddFragment(new FilterFragment(),"FILTER");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    public void update(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",2);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
