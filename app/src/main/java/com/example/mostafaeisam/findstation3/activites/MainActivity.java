package com.example.mostafaeisam.findstation3.activites;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mostafaeisam.findstation3.FindStation;
import com.example.mostafaeisam.findstation3.adapters.stationsRecyclerViewAapter;
import com.example.mostafaeisam.findstation3.classes.FilterStations;
import com.example.mostafaeisam.findstation3.classes.SortStations;
import com.example.mostafaeisam.findstation3.classes.Station;
import com.example.mostafaeisam.findstation3.responses.GetStationsListResponse;
import com.example.mostafaeisam.findstation3.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    String JsonData = "{\"Stations\":" + "[\n" +
            "    {\n" +
            "        \"title\": \"Misr Petroleum\",\n" +
            "        \"address\": \"Gameat Al Dewal Al Arabeya, Gazirat Mit Oqbah, Al Agouzah, Giza Governorate\",\n" +
            "        \"position\": {\n" +
            "            \"lat\": 30.055844,\n" +
            "            \"lng\": 31.203254\n" +
            "        },\n" +
            "        \"rating\": 3,\n" +
            "        \"isActive\": true,\n" +
            "        \"createdOn\": \"2018-04-05T09:14:45.212Z\",\n" +
            "        \"hasMasjid\": true,\n" +
            "        \"hasRadio\": true,\n" +
            "        \"hasATM\": true,\n" +
            "        \"hasRest\": false,\n" +
            "        \"hasCafe\": false,\n" +
            "        \"hasMarket\": true,\n" +
            "        \"hasRestaurant\": false,\n" +
            "        \"hasHotel\": true,\n" +
            "        \"hasLadiesWC\": true,\n" +
            "        \"hasMensWC\": true,\n" +
            "        \"isGas91Available\": false,\n" +
            "        \"isGas95Available\": true,\n" +
            "        \"gas91Price\": 4.37,\n" +
            "        \"gas95Price\": 6.04,\n" +
            "        \"dieselPrice\": 3.47,\n" +
            "        \"isDieselAvailable\": true,\n" +
            "        \"id\": \"5ac5e905b7330d003ffcf57e\",\n" +
            "        \"gasCompanyId\": \"5ac5e6c8b7330d003ffcf57d\",\n" +
            "        \"currencyId\": \"5a6b42ac5eebec001074c701\",\n" +
            "        \"iid\": 1,\n" +
            "        \"title_ar\": \"مصر للبترول\",\n" +
            "        \"address_ar\": \"جامعة الدول العربية، جزيرة ميت عقبة، العجوزة، الجيزة\",\n" +
            "        \"company\": {\n" +
            "            \"name\": \"Misr Petroleum\",\n" +
            "            \"id\": \"5ac5e6c8b7330d003ffcf57d\",\n" +
            "            \"_image\": {\n" +
            "                \"url\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdmYVUwcztCSqYZtpWR_2oYz7u41cV5yEIcRneSC-uksqLycWX\",\n" +
            "                \"createdOn\": \"2018-04-05T09:03:53.000Z\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"currency\": {\n" +
            "            \"enCurrencyCode\": \"EG\",\n" +
            "            \"enCurrency\": \"EGY\",\n" +
            "            \"currentUSDValue\": 0.27,\n" +
            "            \"id\": \"5a6b42ac5eebec001074c701\",\n" +
            "            \"iid\": 1\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"Total Gas Station\",\n" +
            "        \"address\": \"7 Gazirat Mit Oqbah, Al Agouzah, Giza Governorate\",\n" +
            "        \"position\": {\n" +
            "            \"lat\": 30.057135,\n" +
            "            \"lng\": 31.201607\n" +
            "        },\n" +
            "        \"rating\": 5,\n" +
            "        \"isActive\": true,\n" +
            "        \"createdOn\": \"2018-04-14T16:03:40.084Z\",\n" +
            "        \"hasMasjid\": true,\n" +
            "        \"hasRadio\": false,\n" +
            "        \"hasATM\": true,\n" +
            "        \"hasRest\": true,\n" +
            "        \"hasCafe\": false,\n" +
            "        \"hasMarket\": true,\n" +
            "        \"hasRestaurant\": true,\n" +
            "        \"hasHotel\": true,\n" +
            "        \"hasLadiesWC\": false,\n" +
            "        \"hasMensWC\": true,\n" +
            "        \"isGas91Available\": true,\n" +
            "        \"isGas95Available\": true,\n" +
            "        \"gas91Price\": 6.00,\n" +
            "        \"gas95Price\": 4.12,\n" +
            "        \"dieselPrice\": 2.47,\n" +
            "        \"isDieselAvailable\": false,\n" +
            "        \"id\": \"5ad2265c7874bc003c58911b\",\n" +
            "        \"gasCompanyId\": \"5ad22443772b3e003a782a2d\",\n" +
            "        \"currencyId\": \"5a6b42ac5eebec001074c701\",\n" +
            "        \"iid\": 2,\n" +
            "        \"title_ar\": \"توتال شارع سودان\",\n" +
            "        \"address_ar\": \"7 شارع السودان، جزيرة ميت عقبة، العجوزة، الجيزة\",\n" +
            "        \"company\": {\n" +
            "            \"name\": \"Total Gas Station\",\n" +
            "            \"id\": \"5ad22443772b3e003a782a2d\",\n" +
            "            \"_image\": {\n" +
            "                \"url\": \"https://s3-media4.fl.yelpcdn.com/bphoto/qZ9KVCQJm4_GNgOmJDbzow/l.jpg\",\n" +
            "                \"createdOn\": \"2018-04-14T15:53:05.000Z\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"currency\": {\n" +
            "            \"enCurrencyCode\": \"EG\",\n" +
            "            \"enCurrency\": \"EGY\",\n" +
            "            \"currentUSDValue\": 0.27,\n" +
            "            \"id\": \"5a6b42ac5eebec001074c701\",\n" +
            "            \"iid\": 1\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"Mobil Gas Station\",\n" +
            "        \"address\": \"365 Al Huwaiteyah, Al Agouzah, Giza Governorate\",\n" +
            "        \"position\": {\n" +
            "            \"lat\": 30.057798,\n" +
            "            \"lng\": 31.206085\n" +
            "        },\n" +
            "        \"rating\": 2,\n" +
            "        \"isActive\": true,\n" +
            "        \"createdOn\": \"2018-04-14T16:07:44.922Z\",\n" +
            "        \"hasMasjid\": true,\n" +
            "        \"hasRadio\": true,\n" +
            "        \"hasATM\": true,\n" +
            "        \"hasRest\": true,\n" +
            "        \"hasCafe\": true,\n" +
            "        \"hasMarket\": true,\n" +
            "        \"hasRestaurant\": true,\n" +
            "        \"hasHotel\": true,\n" +
            "        \"hasLadiesWC\": false,\n" +
            "        \"hasMensWC\": false,\n" +
            "        \"isGas91Available\": false,\n" +
            "        \"isGas95Available\": true,\n" +
            "        \"gas91Price\": 7.00,\n" +
            "        \"gas95Price\": 6.12,\n" +
            "        \"dieselPrice\": 2.20,\n" +
            "        \"isDieselAvailable\": true,\n" +
            "        \"id\": \"5ad22750772b3e003a782a33\",\n" +
            "        \"gasCompanyId\": \"5ad22443772b3e003a782a2d\",\n" +
            "        \"currencyId\": \"5a6b42ac5eebec001074c701\",\n" +
            "        \"iid\": 3,\n" +
            "        \"title_ar\": \"محطة موبيل\",\n" +
            "        \"address_ar\": \"365 شارع السودان، الحويتية، العجوزة، الجيزة\",\n" +
            "        \"company\": {\n" +
            "            \"name\": \"Mobil\",\n" +
            "            \"id\": \"5ad22443772b3e003a782a2d\",\n" +
            "            \"_image\": {\n" +
            "                \"url\": \"https://s3-media3.fl.yelpcdn.com/bphoto/GWACgAZKaUydGPkfq5jvPg/ls.jpg\",\n" +
            "                \"createdOn\": \"2018-04-14T15:53:05.000Z\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"currency\": {\n" +
            "            \"enCurrencyCode\": \"EG\",\n" +
            "            \"enCurrency\": \"EGY\",\n" +
            "            \"currentUSDValue\": 0.27,\n" +
            "            \"id\": \"5a6b42ac5eebec001074c701\",\n" +
            "            \"iid\": 1\n" +
            "        }\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"Co-op\",\n" +
            "        \"address\": \"Madinet Al Eelam, Al Agouzah, Giza Governorate\",\n" +
            "        \"position\": {\n" +
            "            \"lat\": 30.061360,\n" +
            "            \"lng\": 31.211399\n" +
            "        },\n" +
            "        \"rating\": 1,\n" +
            "        \"isActive\": true,\n" +
            "        \"createdOn\": \"2018-04-14T16:15:30.448Z\",\n" +
            "        \"hasMasjid\": true,\n" +
            "        \"hasRadio\": false,\n" +
            "        \"hasATM\": true,\n" +
            "        \"hasRest\": false,\n" +
            "        \"hasCafe\": false,\n" +
            "        \"hasMarket\": false,\n" +
            "        \"hasRestaurant\": true,\n" +
            "        \"hasHotel\": true,\n" +
            "        \"hasLadiesWC\": true,\n" +
            "        \"hasMensWC\": true,\n" +
            "        \"isGas91Available\": true,\n" +
            "        \"isGas95Available\": true,\n" +
            "        \"gas91Price\": 6.17,\n" +
            "        \"gas95Price\": 5.01,\n" +
            "        \"dieselPrice\": 2.27,\n" +
            "        \"isDieselAvailable\": true,\n" +
            "        \"id\": \"5ad22922772b3e003a782a39\",\n" +
            "        \"gasCompanyId\": \"5ad228407874bc003c58911e\",\n" +
            "        \"currencyId\": \"5a6b42ac5eebec001074c701\",\n" +
            "        \"iid\": 4,\n" +
            "        \"title_ar\": \"التعاون\",\n" +
            "        \"address_ar\": \"مدينة الأعلام، العجوزة، الجيزة\",\n" +
            "        \"company\": {\n" +
            "            \"name\": \"Co-op\",\n" +
            "            \"id\": \"5ad228407874bc003c58911e\",\n" +
            "            \"_image\": {\n" +
            "                \"url\": \"http://www.southernalberta.com/business/datapics/TaberCoOp.jpg\",\n" +
            "                \"createdOn\": \"2018-04-14T16:11:19.000Z\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"currency\": {\n" +
            "            \"enCurrencyCode\": \"EG\",\n" +
            "            \"enCurrency\": \"EGY\",\n" +
            "            \"currentUSDValue\": 0.27,\n" +
            "            \"id\": \"5a6b42ac5eebec001074c701\",\n" +
            "            \"iid\": 1\n" +
            "        }\n" +
            "    }\n" +
            "]}";

    private GoogleMap mGoogleMap;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    @BindView(R.id.appBar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.rv_stationsInfo)
    RecyclerView mRvStationsInfo;
    @BindView(R.id.ib_imageButton)
    ImageButton mIbImageButton;
    @BindView(R.id.nested)
    NestedScrollView mNestedScrollView;
    private Menu menu;
    stationsRecyclerViewAapter mRvAdapter;
    List<Station> mStationsList;
    List<Station> mFilterStationList;
    private boolean isFirstTimeClickedResizeMap = true;
    private boolean mSwipeIsFirstTime = true;
    private boolean isFirstTimeClickedFilter = true;
    private double stationLocationLatitude;
    private double stationLocationLongitude;
    private double currentLocationLatitude;
    private double currentLocationLongitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        showBackArrow();
        statusCheck();
        handleMapScrolling(mAppBarLayout);
        new MyAsyncTask().execute();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    }

    private void initView() {
        mStationsList = new ArrayList<>();
        mFilterStationList = new ArrayList<>();
    }

    private void showBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void handleMapScrolling(AppBarLayout appBarLayout) {
        if (appBarLayout.getLayoutParams() != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
            AppBarLayout.Behavior appBarLayoutBehaviour = new AppBarLayout.Behavior();
            appBarLayoutBehaviour.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                @Override
                public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                    return false;
                }
            });
            layoutParams.setBehavior(appBarLayoutBehaviour);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //to convert XML to java code
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                Intent filterActivity = new Intent(MainActivity.this, FilterActivity.class);
                startActivityForResult(filterActivity, 2);
                setFirstTimeClickedFilter(false);

                break;
            case R.id.swipe:
                if (mSwipeIsFirstTime) {
                    //make RecyclerView Horizontal
                    mRvStationsInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
                    mRvAdapter = new stationsRecyclerViewAapter(MainActivity.this, mStationsList);
                    mRvStationsInfo.setAdapter(mRvAdapter);
                    mNestedScrollView.setVerticalScrollBarEnabled(false);
                    mNestedScrollView.setNestedScrollingEnabled(false);
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_swipe_ver));
                    setmSwipeIsFirstTime(false);
                } else {
                    mRvStationsInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRvAdapter = new stationsRecyclerViewAapter(MainActivity.this, mStationsList);
                    mRvStationsInfo.setAdapter(mRvAdapter);
                    mNestedScrollView.setVerticalScrollBarEnabled(true);
                    mNestedScrollView.setNestedScrollingEnabled(true);
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_action_swipe));
                    setmSwipeIsFirstTime(true);
                }
                break;
        }
        mRvAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                currentLocationLatitude = location.getLatitude();
                currentLocationLongitude = location.getLongitude();
                //LatLng latLng = new LatLng(locationLatitude, locationLongitude);
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                //googleMap.addMarker(new MarkerOptions().position(latLng).title(""));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                CameraPosition camPos = new CameraPosition.Builder()
                        .target(new LatLng(currentLocationLatitude, currentLocationLongitude))
                        .zoom(14)
                        .build();
                CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
                googleMap.animateCamera(camUpd3);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(currentLocationLatitude, currentLocationLongitude)).title(""));
            }
        }
    }

    public void setMapFullScreen(View view) {

        if (isFirstTimeClickedResizeMap == true) {
            ViewGroup.LayoutParams params = mAppBarLayout.getLayoutParams();
            params.height = 850;
            params.width = AppBarLayout.LayoutParams.MATCH_PARENT;
            mAppBarLayout.setLayoutParams(params);
            mIbImageButton.setImageResource(R.drawable.ic_action_full_screen_exit);
            setFirstTimeClickedResizeMap(false);
        } else {
            ViewGroup.LayoutParams params = mAppBarLayout.getLayoutParams();
            params.height = 600;
            params.width = AppBarLayout.LayoutParams.MATCH_PARENT;
            mAppBarLayout.setLayoutParams(params);
            mIbImageButton.setImageResource(R.drawable.ic_action_full_screen);
            setFirstTimeClickedResizeMap(true);
        }

    }

    public class MyAsyncTask extends AsyncTask<JsonArray, Void, GetStationsListResponse> {

        @Override
        protected GetStationsListResponse doInBackground(JsonArray... jsonArrays) {

            GetStationsListResponse mAllStationsListResponse = new Gson().fromJson(JsonData, GetStationsListResponse.class);

            return mAllStationsListResponse;
        }

        @Override
        protected void onPostExecute(final GetStationsListResponse stationsListResponse) {
            for (int x = 0; x < stationsListResponse.getStationsList().size(); x++) {
                final Station station = stationsListResponse.getStationsList().get(x);
                stationLocationLatitude = station.getPosition().getLat();
                stationLocationLongitude = station.getPosition().getLng();
                //LatLng latLng = new LatLng(locationLatitude, locationLongitude);
                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(stationLocationLatitude, stationLocationLongitude)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_station_marker)).title(station.getTitle()));
                mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        String title = marker.getTitle();
                        for (int i = 0; i < stationsListResponse.getStationsList().size(); i++) {
                            Station station = stationsListResponse.getStationsList().get(i);
                            if (station.getTitle().equals(title)) {
                                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                                intent.putExtra("intentCode", 1);
                                intent.putExtra("markerTitle", station.getTitle());
                                intent.putExtra("markerAddress", station.getAddress());
                                intent.putExtra("markerLatPosition", station.getPosition().getLat());
                                intent.putExtra("markerLngPosition", station.getPosition().getLng());
                                intent.putExtra("markerImageUrl", station.getCompany().get_image().getUrl());
                                startActivity(intent);
                            }
                        }
                    }
                });
            }
            mStationsList.addAll(stationsListResponse.getStationsList());
            mRvStationsInfo.setHasFixedSize(true);
            mRvStationsInfo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            mRvAdapter = new stationsRecyclerViewAapter(MainActivity.this, mStationsList);
            mRvStationsInfo.setAdapter(mRvAdapter);
            mRvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FindStation findStation = new FindStation();
        FilterStations filterStations = findStation.getFilterStations();
        SortStations sortStations = findStation.getSortStations();

        if (requestCode == 2 && resultCode == RESULT_OK) {
            //mFilterStationList.clear();
            if (!mFilterStationList.isEmpty()) {
                mFilterStationList.clear();
            }

            if (filterStations != null) {
                for (int x = 0; x < mStationsList.size(); x++) {
                    Station station = mStationsList.get(x);

                    if (filterStations.isCheckedGas91() && station.isGas91Available()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }

                    }

                    if (filterStations.isCheckedGas95() && station.isGas95Available()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedDsl() && station.isDieselAvailable()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedRestaurant() && station.isHasRestaurant()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }
                    if (filterStations.isCheckedMosque() && station.isHasMasjid()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedCoffee() && station.isHasCafe()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedWomenToilet() && station.isHasLadiesWC()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedMenToilet() && station.isHasMensWC()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedHotel() && station.isHasHotel()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }

                    if (filterStations.isCheckedATM() && station.isHasATM()) {
                        if (!mFilterStationList.contains(station)){
                            mFilterStationList.add(station);
                        }
                    }
                }
            }


            if (sortStations != null ) {
                if (sortStations.isByPriceHighest()) {
                    if (!mFilterStationList.isEmpty()) {
                        //descending تنازلى
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o2.getGas91Price(), o1.getGas91Price());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        //descending تنازلى
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o2.getGas91Price(), o1.getGas91Price());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByPriceLoweset()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o1.getGas91Price(), o2.getGas91Price());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o1.getGas91Price(), o2.getGas91Price());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByStarsHighest()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o2.getRating(), o1.getRating());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o2.getRating(), o1.getRating());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByStarsLowest()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o1.getRating(), o2.getRating());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return Double.compare(o1.getRating(), o2.getRating());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByNamesfromAtoZ()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByNamesfromZtoA()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return o2.getTitle().compareToIgnoreCase(o1.getTitle());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                //double Compare
                                return o2.getTitle().compareToIgnoreCase(o1.getTitle());
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }

                } else if (sortStations.isByNearest()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                double lat1 = o1.getPosition().getLat();
                                double lon1 = o1.getPosition().getLng();
                                double lat2 = o2.getPosition().getLat();
                                double lon2 = o2.getPosition().getLng();

                                double distanceToPlace1 = distance(currentLocationLatitude, currentLocationLongitude, lat1, lon1);
                                double distanceToPlace2 = distance(currentLocationLatitude, currentLocationLongitude, lat2, lon2);
                                return (int) (distanceToPlace1 - distanceToPlace2);
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                double lat1 = o1.getPosition().getLat();
                                double lon1 = o1.getPosition().getLng();
                                double lat2 = o2.getPosition().getLat();
                                double lon2 = o2.getPosition().getLng();

                                double distanceToPlace1 = distance(currentLocationLatitude, currentLocationLongitude, lat1, lon1);
                                double distanceToPlace2 = distance(currentLocationLatitude, currentLocationLongitude, lat2, lon2);
                                return (int) (distanceToPlace1 - distanceToPlace2);
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }
                } else if (sortStations.isByFarthest()) {
                    if (!mFilterStationList.isEmpty()) {
                        Collections.sort(mFilterStationList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                double lat1 = o1.getPosition().getLat();
                                double lon1 = o1.getPosition().getLng();
                                double lat2 = o2.getPosition().getLat();
                                double lon2 = o2.getPosition().getLng();

                                double distanceToPlace1 = distance(currentLocationLatitude, currentLocationLongitude, lat1, lon1);
                                double distanceToPlace2 = distance(currentLocationLatitude, currentLocationLongitude, lat2, lon2);
                                return (int) (distanceToPlace2 - distanceToPlace1);
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    } else {
                        Collections.sort(mStationsList, new Comparator<Station>() {
                            @Override
                            public int compare(Station o1, Station o2) {
                                double lat1 = o1.getPosition().getLat();
                                double lon1 = o1.getPosition().getLng();
                                double lat2 = o2.getPosition().getLat();
                                double lon2 = o2.getPosition().getLng();

                                double distanceToPlace1 = distance(currentLocationLatitude, currentLocationLongitude, lat1, lon1);
                                double distanceToPlace2 = distance(currentLocationLatitude, currentLocationLongitude, lat2, lon2);
                                return (int) (distanceToPlace2 - distanceToPlace1);
                            }
                        });
                        mRvAdapter.notifyDataSetChanged();
                    }
                }
            }

            if (!mFilterStationList.isEmpty()) {
                mRvAdapter = new stationsRecyclerViewAapter(MainActivity.this, mFilterStationList);
                mRvStationsInfo.setAdapter(mRvAdapter);
            } else {
                mRvAdapter = new stationsRecyclerViewAapter(MainActivity.this, mStationsList);
                mRvStationsInfo.setAdapter(mRvAdapter);
            }
        }

    }

    public double distance(double fromLat, double fromLon, double toLat, double toLon) {
        double radius = 6378137;   // approximate Earth radius, *in meters*
        double deltaLat = toLat - fromLat;
        double deltaLon = toLon - fromLon;
        double angle = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(deltaLat / 2), 2) +
                        Math.cos(fromLat) * Math.cos(toLat) *
                                Math.pow(Math.sin(deltaLon / 2), 2)));
        return radius * angle;
    }


    public void setmSwipeIsFirstTime(boolean mSwipeIsFirstTime) {
        this.mSwipeIsFirstTime = mSwipeIsFirstTime;
    }

    public boolean isFirstTimeClickedResizeMap() {
        return isFirstTimeClickedResizeMap;
    }

    public void setFirstTimeClickedResizeMap(boolean firstTimeClickedResizeMap) {
        isFirstTimeClickedResizeMap = firstTimeClickedResizeMap;
    }

    public boolean isFirstTimeClickedFilter() {
        return isFirstTimeClickedFilter;
    }

    public void setFirstTimeClickedFilter(boolean firstTimeClickedFilter) {
        isFirstTimeClickedFilter = firstTimeClickedFilter;
    }
/*
    @Override
    protected void onRestart() {
        super.onRestart();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        onMapReady(mGoogleMap);
    }
*/

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean ismSwipeIsFirstTime() {
        return mSwipeIsFirstTime;
    }

}