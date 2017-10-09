package com.example.blackbird.myapplication.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by blackbird on 7/10/17.
 */

public class CommonUtils {

    public String returnDate(long time){

        String dateText = "";

        Date date=new Date(time*1000);
        SimpleDateFormat df2 = new SimpleDateFormat(Constants.DATE_FORMAT);
        dateText = df2.format(date);

        return dateText;
    }

    public String returnDay(long time){

        String dateText = "";

        Date date=new Date(time*1000);
        SimpleDateFormat df2 = new SimpleDateFormat(Constants.DAY_FORMAT);
        dateText = df2.format(date);

        return dateText;
    }

    public String returnTime(long time){

        String dateText = "";

        Date date=new Date(time*1000);
        SimpleDateFormat df2 = new SimpleDateFormat(Constants.TIME_FORMAT);
        dateText = df2.format(date);

        return dateText;
    }
}
