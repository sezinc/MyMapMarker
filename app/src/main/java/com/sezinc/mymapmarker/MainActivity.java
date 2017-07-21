package com.sezinc.mymapmarker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    boolean mapReady=false;
    static final CameraPosition GEDIK = CameraPosition.builder()
            .target( new LatLng(40.901647, 29.219328))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    MarkerOptions migros;
    MarkerOptions bim;
    MarkerOptions ayuzbir;
    MarkerOptions neval;

    @Override
    public Resources getResources() {
        return super.getResources();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
// mMap.getUiSettings().setMyLocationButtonEnabled(true);
        migros= new MarkerOptions()
                .title("Migros")
                .position(new LatLng(40.914470, 29.209623));
              //  .icon(BitmapDescriptorFactory.fromResource(R.drawable.migros));

        neval= new MarkerOptions()
                .title("Nevallll")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .position(new LatLng(40.901647, 29.219328))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.neval));

        bim= new MarkerOptions()
                .title("BİM")
                .position(new LatLng(40.901340, 29.226065));
              //  .icon(BitmapDescriptorFactory.fromResource(R.drawable.bim));
        ayuzbir= new MarkerOptions()
                .title("A101")
                .position(new LatLng(40.902700, 29.228968));
              //  .icon(BitmapDescriptorFactory.fromResource(R.drawable.ayuzbir));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;
        mMap.addMarker(neval);
        mMap.addMarker(migros);
        mMap.addMarker(bim);
        mMap.addMarker(ayuzbir);

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(GEDIK), 1000, null);
    }


}
