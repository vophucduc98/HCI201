package namdp.demo.urent;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMaps extends Fragment{
    public static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;
    MapView mMapView;
    private GoogleMap googleMap;

    public FragmentMaps() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_maps, container, false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(10.84122222, 106.80916667);
                LatLng car1 = new LatLng(10.84924390, 106.80116666);
                LatLng car2 = new LatLng(10.84522223, 106.80216668);
                LatLng car3 = new LatLng(10.84622224, 106.80616669);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
                googleMap.addMarker(new MarkerOptions().position(car1).title("LAMBORGHINI").snippet("900.000VNĐ")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.icon_car));
                googleMap.addMarker(new MarkerOptions().position(car2).title("BATMOBILE").snippet("90.000VNĐ")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.icon_car));
                googleMap.addMarker(new MarkerOptions().position(car3).title("FORD FOCUS 2019").snippet("900.000VNĐ")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.icon_car));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return rootView;

    }



}
