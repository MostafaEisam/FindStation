package com.example.mostafaeisam.findstation3.activites;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.maps.model.PolylineOptions;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private double markerlocationLatitude;
    private double markerLocationLongitude;

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
                    markerlocationLatitude = getIntent().getDoubleExtra("markerLatPosition",99999);
                    markerLocationLongitude = getIntent().getDoubleExtra("markerLngPosition",99999);
                    String markerTitle =  getIntent().getStringExtra("markerTitle");
                    mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(markerlocationLatitude, markerLocationLongitude))
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
                LatLng latLng = new LatLng(locationLatitude, locationLongitude);
                if (intentCode==1){
                    LatLng markerLatLng = new LatLng(getIntent().getDoubleExtra("markerLatPosition",99999), getIntent().getDoubleExtra("markerLngPosition",99999));
                    String url = getMapsApiDirectionsUrl(latLng, markerLatLng);
                    ReadTask downloadTask = new ReadTask();
                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                }else {
                    LatLng markerLatLng = new LatLng(getIntent().getDoubleExtra("stationLatPosition",99999), getIntent().getDoubleExtra("stationLngPosition",99999));
                    String url = getMapsApiDirectionsUrl(latLng, markerLatLng);
                    ReadTask downloadTask = new ReadTask();
                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                }

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

    private String  getMapsApiDirectionsUrl(LatLng origin,LatLng dest) {
        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;


        return url;

    }

    private class ReadTask extends AsyncTask<String, Void , String> {

        @Override
        protected String doInBackground(String... url) {
            // TODO Auto-generated method stub
            String data = "";
            try {
                MapHttpConnection http = new MapHttpConnection();
                data = http.readUr(url[0]);


            } catch (Exception e) {
                // TODO: handle exception
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }

    }

    public class MapHttpConnection {
        @SuppressLint("LongLogTag")
        public String readUr(String mapsApiDirectionsUrl) throws IOException {
            String data = "";
            InputStream istream = null;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(mapsApiDirectionsUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                istream = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(istream));
                StringBuffer sb = new StringBuffer();
                String line ="";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                data = sb.toString();
                br.close();


            }
            catch (Exception e) {
                Log.d("Exception while reading url", e.toString());
            } finally {
                istream.close();
                urlConnection.disconnect();
            }
            return data;

        }
    }

    public class PathJSONParser {

        public List<List<HashMap<String, String>>> parse(JSONObject jObject) {
            List<List<HashMap<String, String>>> routes = new ArrayList<List<HashMap<String,String>>>();
            JSONArray jRoutes = null;
            JSONArray jLegs = null;
            JSONArray jSteps = null;
            try {
                jRoutes = jObject.getJSONArray("routes");
                for (int i=0 ; i < jRoutes.length() ; i ++) {
                    jLegs = ((JSONObject) jRoutes.get(i)).getJSONArray("legs");
                    List<HashMap<String, String>> path = new ArrayList<HashMap<String,String>>();
                    for(int j = 0 ; j < jLegs.length() ; j++) {
                        jSteps = ((JSONObject) jLegs.get(j)).getJSONArray("steps");
                        for(int k = 0 ; k < jSteps.length() ; k ++) {
                            String polyline = "";
                            polyline = (String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points");
                            List<LatLng> list = decodePoly(polyline);
                            for(int l = 0 ; l < list.size() ; l ++){
                                HashMap<String, String> hm = new HashMap<String, String>();
                                hm.put("lat",
                                        Double.toString(((LatLng) list.get(l)).latitude));
                                hm.put("lng",
                                        Double.toString(((LatLng) list.get(l)).longitude));
                                path.add(hm);
                            }
                        }
                        routes.add(path);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;

        }

        private List<LatLng> decodePoly(String encoded) {
            List<LatLng> poly = new ArrayList<LatLng>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)),
                        (((double) lng / 1E5)));
                poly.add(p);
            }
            return poly;
        }}

    private class ParserTask extends AsyncTask<String,Integer, List<List<HashMap<String , String >>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {
            // TODO Auto-generated method stub
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                PathJSONParser parser = new PathJSONParser();
                routes = parser.parse(jObject);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points = null;
            PolylineOptions polyLineOptions = null;

            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<LatLng>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
                polyLineOptions.width(4);
                polyLineOptions.color(Color.BLUE);
            }

            mGoogleMap.addPolyline(polyLineOptions);

        }}
}
