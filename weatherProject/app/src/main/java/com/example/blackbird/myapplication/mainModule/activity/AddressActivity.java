package com.example.blackbird.myapplication.mainModule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.blackbird.myapplication.R;
import com.example.blackbird.myapplication.mainModule.adapter.CityListAdapter;
import com.example.blackbird.myapplication.mainModule.adapter.PlaceAutocompleteAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by blackbird on 8/10/17.
 */

public class AddressActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    private Unbinder unbinder;
    private Activity activity;

    protected GoogleApiClient mGoogleApiClient;

    private PlaceAutocompleteAdapter mAdapter;

    private AutoCompleteTextView mAutocompleteView;

    @BindView(R.id.rv_city)
    RecyclerView rvCity;

    private ArrayList<String> cityNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_address);
        unbinder = ButterKnife.bind(this);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, 0 /* clientId */, this)
                .addApi(Places.GEO_DATA_API)
                .build();


        mAutocompleteView = (AutoCompleteTextView)
                findViewById(R.id.autocomplete_places);
        mAutocompleteView.setOnItemClickListener(mAutocompleteClickListener);
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                .build();

        mAdapter = new PlaceAutocompleteAdapter(this, mGoogleApiClient,
                typeFilter);
        mAutocompleteView.setAdapter(mAdapter);

        activity = this;

        getIntentData();

    }


    private void getIntentData(){

        if(getIntent().hasExtra("CityNames")){
            cityNames = getIntent().getStringArrayListExtra("CityNames");
            setCityAdapter();
        }
    }

    private void setCityAdapter(){

        CityListAdapter mAdapter = new CityListAdapter(activity, cityNames);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        rvCity.setLayoutManager(mLayoutManager);
        rvCity.setItemAnimator(new DefaultItemAnimator());
        rvCity.setAdapter(mAdapter);

    }

    private AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            final AutocompletePrediction item = mAdapter.getItem(position);
            final String placeId = item.getPlaceId();
            final CharSequence primaryText = item.getPrimaryText(null);

            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);

        }
    };

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {

                places.release();
                return;
            }
            final Place place = places.get(0);

            places.release();
        }
    };


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this,
                "Could not connect to Google API Client: Error " + connectionResult.getErrorCode(),
                Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_add)
    void onAddClick(){

        String[] names = mAutocompleteView.getText().toString().split(",");

        Intent intent = new Intent();
        intent.putExtra("cityName", names[0]);
        setResult(RESULT_OK, intent);
        finish();
    }

}
