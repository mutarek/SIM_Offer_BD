package com.bdsoftwaresolution.simofferbd.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.bdsoftwaresolution.simofferbd.HotelListModel;
import com.bdsoftwaresolution.simofferbd.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import barikoi.barikoilocation.BarikoiAPI;
import barikoi.barikoilocation.PlaceModels.ReverseGeoPlace;
import barikoi.barikoilocation.ReverseGeo.ReverseGeoAPI;
import barikoi.barikoilocation.ReverseGeo.ReverseGeoAPIListener;

public class TestingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<HotelListModel> hotelListModels;
    private Context context;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference hotelRef = db.collection("Hotels");
    private EditText name, id;
    private TextView latitv, longitv;
    private DocumentReference userDoc = db.collection("Users").document("First_User");

    // private CollectionReference singleref = db.collection("Users");
    int PERMISSION_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
    Double lat, longti;
    String currentPostCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        recyclerView = findViewById(R.id.recyller_view);
        hotelListModels = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        /*name = findViewById(R.id.nameET);
        id = findViewById(R.id.idET);
        nameTV = findViewById(R.id.nameTV);*/
        BarikoiAPI.getINSTANCE(getApplicationContext(), "MTU4NjpYUTQ1VlFEUEJY");
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    }


    /*public void saveBTN(View view) {
        String sname = name.getText().toString();
        String sid = id.getText().toString();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Name", sname);
        hashMap.put("ID", sid);

        Map<String, Object> docData = new HashMap<>();
        docData.put("stringExample", "Hello world!");
        docData.put("booleanExample", true);
        docData.put("numberExample", 3.14159265);
        docData.put("listExample", Arrays.asList(1, 2, 3));
        docData.put("nullExample", null);

        Map<String, Object> nestedData = new HashMap<>();
        nestedData.put("a", 5);
        nestedData.put("b", true);

        docData.put("objectExample", nestedData);

        *//*db.collection("Users").document("First_User").set(hashMap);
        singleref.document().set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(context, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });*//*

    }*/

    /*private void initRecyller() {
        hotelRef.orderBy("PostCode").startAt(currentPostCode).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    HotelListModel hotelListModel = documentSnapshot.toObject(HotelListModel.class);
                    hotelListModels.add(hotelListModel);
                }

                hotelsListAdapter = new HotelsListAdapter(new EachHotelClick() {
                    @Override
                    public void OnVideoClick(View videoView, int videoPosition) {

                    }
                }, hotelListModels, context);


                recyclerView.setAdapter(hotelsListAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(linearLayoutManager);

            }
        });
    }*/

    /*public void loadBTN(View view) {
        userDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String name = documentSnapshot.getString("Name");
                    String id = documentSnapshot.getString("ID");
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }*/


    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {
                                    lat = Double.valueOf(location.getLatitude());
                                    longti = Double.valueOf(location.getLongitude());
                                    getFullAddress();
                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }

    private void getFullAddress() {
        ReverseGeoAPI.builder(getApplicationContext())
                .setLatLng(lat,longti)
                .build()
                .getAddress(new ReverseGeoAPIListener() {
                    @Override
                    public void reversedAddress(ReverseGeoPlace place) {
                        Toast.makeText(TestingActivity.this, ""+place.getAddress(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(TestingActivity.this, "Error Message"+message, Toast.LENGTH_SHORT).show();
                    }
                });




        /*Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List < Address > addressList = geocoder.getFromLocation(lat, longti, 1);
            if (addressList != null && addressList.size() > 0) {
                 currentPostCode = addressList.get(0).getPostalCode();
            }
        } catch (IOException e) {
            Log.e("Location Address Loader", "Unable connect to Geocoder", e);
        }*/

    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            lat = Double.valueOf(mLastLocation.getLatitude());
            longti = Double.valueOf(mLastLocation.getLongitude());
            getFullAddress();
        }
    };

    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        getLastLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hotelListModels.clear();
    }
}
