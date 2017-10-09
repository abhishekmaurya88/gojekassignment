package com.example.blackbird.myapplication.mainModule.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.blackbird.myapplication.api.response.BaseResponse;
import com.example.blackbird.myapplication.mainModule.fragment.ContentFragment;

import java.util.ArrayList;

/**
 * Created by Abhishek.s on 8/28/2017.
 */

public class ContentFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<BaseResponse> baseResponses = new ArrayList<>();
    public ContentFragmentAdapter(FragmentManager fm, ArrayList<BaseResponse> baseResponses) {
        super(fm);
        this.baseResponses=baseResponses;
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(baseResponses.get(position));
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return baseResponses.size();
    }
}
