package com.example.myeongsic.howlgooglemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.myeongsic.howlgooglemap.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        supportMapFragment.getMapAsync(this);


    }


    //40.766306, -73.976948

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        final LatLng CentralPark = new LatLng(40.766306,-73.976948);

        googleMap.addMarker(new MarkerOptions().position(CentralPark).title("Central_Park"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CentralPark,10));

        Button button = (Button)findViewById(R.id.button_3d);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(CentralPark)      // Sets the center of the map to Mountain View
                        .zoom(17)                   // Sets the zoom
                        .bearing(90)                // Sets the orientation of the camera to east
                        .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            }
        });




    }
}
