package com.example.blackbird.myapplication.mainModule.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.blackbird.myapplication.R;
import com.example.blackbird.myapplication.api.WeatherApi;
import com.example.blackbird.myapplication.api.response.BaseResponse;
import com.example.blackbird.myapplication.api.retrofit.RetrofitCallback;
import com.example.blackbird.myapplication.mainModule.adapter.ContentFragmentAdapter;
import com.example.blackbird.myapplication.model.ApiError;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;
    private Activity activity;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.img_loader)
    ImageView imgLoader;

    @BindView(R.id.rlt_layout_loader)
    View rltLayoutLoader;

    @BindView(R.id.rlt_layout_error)
    RelativeLayout rltLayoutError;

    @BindView(R.id.viewPagerFragment)
    ViewPager viewPagerFragment;

    @BindView(R.id.sliderIndicator)
    public CirclePageIndicator sliderIndicator;

    private ArrayList<BaseResponse> baseResponses;
    private int currentPage = 0;

    private String[] cityArray;
    private String cityName = "Pune";
    private ContentFragmentAdapter contentFragmentAdapter;

    private ArrayList<String> cityNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        activity = this;
        rltLayoutLoader.setVisibility(View.GONE);
        baseResponses = new ArrayList<>();
        cityNames = new ArrayList<>();
        cityArray = getResources().getStringArray(R.array.city_list);
        setActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(cityName!= null && cityName.length() > 0) {
            loadWeatherData(cityName);
        }
    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void setLoaderVisibilty(boolean isVisible){

        if(isVisible) {
            rltLayoutLoader.setVisibility(View.VISIBLE);
        }
        else{
            rltLayoutLoader.setVisibility(View.GONE);
        }
    }

    private void startAnimation(){

        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f , Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(1000);
        imgLoader.setAnimation(anim);
        imgLoader.startAnimation(anim);

    }

    private void loadWeatherData(final String cityNameTemp){

        currentPage = 0;
        setLoaderVisibilty(true);
        startAnimation();
        WeatherApi.getInstance(activity).weatherApiCall(cityNameTemp, new RetrofitCallback() {
            @Override
            public void onSuccess(BaseResponse response) {

                setLoaderVisibilty(false);
                baseResponses.add(response);
                if(!baseResponses.isEmpty() && baseResponses.size() == 1){
                    initSlider();
                }
                contentFragmentAdapter.notifyDataSetChanged();
                cityNames.add(baseResponses.get(baseResponses.size()-1).getLocation().getLocationName());
                cityName = "";
//
            }

            @Override
            public void onError(ApiError error) {

                Animation RightSwipe = AnimationUtils.loadAnimation(activity, R.anim.left_slide);
                rltLayoutError.startAnimation(RightSwipe);
                rltLayoutError.setVisibility(View.VISIBLE);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);

    }

    @OnClick(R.id.ibtn_add_city)
    void onAddCLick(){

        Intent intent = new Intent(activity, AddressActivity.class);
        intent.putExtra("CityNames", cityNames);
        startActivityForResult(intent,1234);
    }

    @OnClick(R.id.btn_retry)
    void onRetryClick(){

        rltLayoutError.setVisibility(View.GONE);
        Animation RightSwipe = AnimationUtils.loadAnimation(activity, R.anim.right_slide);
        rltLayoutError.startAnimation(RightSwipe);

        loadWeatherData(cityName);
    }

    public void initSlider() {

        contentFragmentAdapter = new ContentFragmentAdapter(getSupportFragmentManager(), baseResponses);
        viewPagerFragment.setAdapter(contentFragmentAdapter);

        sliderIndicator.setViewPager(viewPagerFragment);

        // Pager listener over indicator
        sliderIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 1234){

            if(data.hasExtra("cityName")) {
                loadWeatherData(data.getStringExtra("cityName"));
            }
        }
    }
}
