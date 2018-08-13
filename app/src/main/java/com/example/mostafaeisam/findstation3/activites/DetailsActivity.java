package com.example.mostafaeisam.findstation3.activites;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.classes.Station;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mostafaeisam.findstation3.activites.MainActivity.REQUEST_LOCATION;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.adView)
    AdView mAdView;
    @BindView(R.id.toolbar_station_image)
    ImageView mToolbarStationImage;
    @BindView(R.id.tv_toolbar_station_address)
    TextView mTvToolbarStationAddress;
    private int intentCode;
    private GoogleMap mGoogleMap;
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        showBackArrow();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.details_map_view);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        intentCode = getIntent().getIntExtra("intentCode",100);
        if (intentCode == 1){
            //intent From Clicking markerTitle
            String markerAddress =  getIntent().getStringExtra("markerAddress");
            mTvToolbarStationAddress.setText(markerAddress);

            String markerImageUrl = getIntent().getStringExtra("markerImageUrl");
            Picasso.get()
                    .load(markerImageUrl)
                    .placeholder(R.drawable.avatar_icon)
                    .fit()
                    .into(mToolbarStationImage);

            //LatLng latLng = new LatLng(locationLatitude, locationLongitude);
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    double locationLatitude = getIntent().getDoubleExtra("markerLatPosition",99999);
                    double locationLongitude = getIntent().getDoubleExtra("markerLngPosition",99999);
                    String markerTitle =  getIntent().getStringExtra("markerTitle");
                    mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(locationLatitude, locationLongitude))
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_station_marker))
                            .title(markerTitle));
                }
            });


        }else if (intentCode == 2){
            //intent From Clicking navigationButton
            String stationAddress = getIntent().getStringExtra("stationAddress");
            mTvToolbarStationAddress.setText(stationAddress);

            String stationImageURl = getIntent().getStringExtra("stationImageUrl");
            Picasso.get()
                    .load(stationImageURl)
                    .placeholder(R.drawable.avatar_icon)
                    .fit()
                    .into(mToolbarStationImage);

            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    double locationLatitude = getIntent().getDoubleExtra("stationLatPosition",99999);
                    double locationLongitude = getIntent().getDoubleExtra("stationLngPosition",99999);
                    String markerTitle =  getIntent().getStringExtra("stationTitle");
                    mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(locationLatitude, locationLongitude))
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_station_marker))
                            .title(markerTitle));
                }
            });

        }

    }


    private void showBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
                double locationLatitude = location.getLatitude();
                double locationLongitude = location.getLongitude();
                //LatLng latLng = new LatLng(locationLatitude, locationLongitude);
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                //googleMap.addMarker(new MarkerOptions().position(latLng).title(""));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                CameraPosition camPos = new CameraPosition.Builder()
                        .target(new LatLng(locationLatitude, locationLongitude))
                        .zoom(14)
                        .build();
                CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
                googleMap.animateCamera(camUpd3);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(locationLatitude, locationLongitude)).title(""));
            }
        }
    }
}
