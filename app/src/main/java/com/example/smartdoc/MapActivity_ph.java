package com.example.smartdoc;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class MapActivity_ph extends AppCompatActivity {
    Spinner S_type;
    Button btn_find;
    SupportMapFragment supportMapFragment;
    GoogleMap map;
    FusedLocationProviderClient fusedLocationProviderClient;
    double CurrentLat = 0, CurrentLong = 0;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_ph);
        S_type = findViewById(R.id.Spinner);
        btn_find = findViewById(R.id.bit_find);
        Object supportMapFragment1 = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);


        String[] placeTypeList = {"hospitals", "pharmacy"};

        String[] placeNameList = {"Hospital", "Pharmacy"};

        S_type.setAdapter(new ArrayAdapter<>(MapActivity_ph.this, android.R.layout.simple_spinner_dropdown_item, placeNameList));


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            getCurrentLocation();
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
            ActivityCompat.requestPermissions(MapActivity_ph.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION},44);
            }
            btn_find.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = S_type.getSelectedItemPosition();
                    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json "
                            + "?location=" +
                            CurrentLat + "," +
                            CurrentLong +
                            "&radius=5000" +
                            "&type=" +
                            placeTypeList[i] +
                            "&sensor=true" +
                            "&key=" + getResources().getString(R.string.google_maps_key);
                    new PlaceTask().execute(url);
                }
            });



    }






    private void getCurrentLocation() {

        @SuppressLint("MissingPermission") Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                CurrentLat = location.getLatitude();
                CurrentLong = location.getLongitude();

                supportMapFragment.getMapAsync(googleMap -> {
                    map = googleMap;
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            new LatLng( CurrentLat,CurrentLong),10
                    ));
                });
            }
        });
    }

    private class PlaceTask extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... strings) {
            String data = null;

            try {
                data = downloadurl(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(java.lang.String s) {
            new ParserTask().execute(s);
        }
    }

    private java.lang.String downloadurl(String string) throws IOException {
        URL url = new URL(string);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        StringBuilder builder = new StringBuilder();

        String line = " ";

        while((line = reader.readLine())!=null){
            builder.append(line);
        }
        String data = builder.toString();
        reader.close();
        return data;
    }

    private class ParserTask extends AsyncTask<String,Integer, List<HashMap<String,String>>> {
        @Override
        protected List<HashMap<java.lang.String, java.lang.String>> doInBackground(java.lang.String... strings) {
            Jsonparser Jsonparser = new Jsonparser();
            List<HashMap<String,String>> mapList = null;
            JSONObject object = null;
            try {
                object = new JSONObject(strings[0]);
                mapList  = Jsonparser.parseResult(object);
            }
            catch(JSONException e){

            }
            return mapList;
        }

        @Override
        protected void onPostExecute(List<HashMap<java.lang.String, java.lang.String>> hashMaps) {
            map.clear();
            for (int i =0;i<hashMaps.size();i++){
                HashMap<String,String> hashMapList = hashMaps.get(i);
                double lat = Double.parseDouble(hashMapList.get("Lat"));
                double lng = Double.parseDouble(hashMapList.get("lng"));
                String name = hashMapList.get("name");
                LatLng latLng = new LatLng(lat,lng);
                MarkerOptions options = new MarkerOptions();
                options.title(name);
                map.addMarker(options);

            }
        }
    }
}
