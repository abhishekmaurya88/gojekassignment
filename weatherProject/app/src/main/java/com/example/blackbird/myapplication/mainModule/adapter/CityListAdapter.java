package com.example.blackbird.myapplication.mainModule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blackbird.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by blackbird on 8/10/17.
 */

public class CityListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> baseResponses;
    private Context context;
    private LayoutInflater inflater;

    public CityListAdapter(Context context, ArrayList<String> baseResponses) {

        this.baseResponses = baseResponses;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.autocomplete_list_item, parent, false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int listPosition) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.txtCityName.setText(baseResponses.get(listPosition));
    }

    @Override
    public int getItemCount() {
        return baseResponses.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_city_name)
        TextView txtCityName;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
