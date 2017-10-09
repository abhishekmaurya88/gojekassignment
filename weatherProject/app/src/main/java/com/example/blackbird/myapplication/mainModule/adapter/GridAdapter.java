package com.example.blackbird.myapplication.mainModule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blackbird.myapplication.R;
import com.example.blackbird.myapplication.api.response.BaseResponse;
import com.example.blackbird.myapplication.model.AstroModel;
import com.example.blackbird.myapplication.model.CurrentModel;
import com.example.blackbird.myapplication.model.DayModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by blackbird on 7/10/17.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private BaseResponse baseResponse;
    private Context context;
    private LayoutInflater inflater;
    private String[] categoryHeadings;

    public GridAdapter(Context context,BaseResponse data) {

        this.baseResponse = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        categoryHeadings = context.getResources().getStringArray(R.array.category_list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        View view = inflater.from(parent.getContext()).inflate(R.layout.item_weather_grid, parent, false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.categoryText.setText(categoryHeadings[listPosition]);

        CurrentModel currentModel = baseResponse.getCurrent();
        DayModel dayModel = baseResponse.getForecastModel().getForecastDayModels().get(0).getDayModel();
        AstroModel astroModel = baseResponse.getForecastModel().getForecastDayModels().get(0).getAstroModel();

        switch (listPosition){
            case 0:
                myViewHolder.categoryTextValue.setText("" + astroModel.getSunrise());
                break;
            case 1:
                myViewHolder.categoryTextValue.setText("" + astroModel.getSunset());
                break;
            case 2:
                myViewHolder.categoryTextValue.setText("" + currentModel.getCloud() + "%");
                break;
            case 3:
                myViewHolder.categoryTextValue.setText("" + currentModel.getHumidity() + "%");
                break;
            case 4:
                myViewHolder.categoryTextValue.setText("" + currentModel.getWindDirection() + " " + currentModel.getWindSpeed() + " km/h");
                break;
            case 5:
                myViewHolder.categoryTextValue.setText("" + currentModel.getFeelLikeTemp() + (char) 0x00B0);
                break;
            case 6:
                myViewHolder.categoryTextValue.setText("" + currentModel.getPrecipitation() + " in");
                break;
            case 7:
                myViewHolder.categoryTextValue.setText("" + currentModel.getPressure() + " inHg");
                break;
            case 8:
                myViewHolder.categoryTextValue.setText("" + currentModel.getVisibilty() + " km");
                break;
            case 9:
                myViewHolder.categoryTextValue.setText("" + dayModel.getUvIndex());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_category)
        TextView categoryText;
        @BindView(R.id.txt_category_value)
        TextView categoryTextValue;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

}
