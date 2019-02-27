package com.bashizip.bhlib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BusinessHoursWeekView extends LinearLayout {


    private List<BusinessHours> model;


    public BusinessHoursWeekView(Context context) {
        super(context);
        initViews(context, null);

    }

    public BusinessHoursWeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public BusinessHoursWeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {

        setOrientation(VERTICAL);

        model = new LinkedList<>();

    }

    private void update() {

        this.removeAllViews();
        invalidate();

        BusinessHourView businessHourView = null;

        for (int i = 0; i < model.size(); i++) {

            businessHourView = new BusinessHourView(this.getContext());

            businessHourView.setBusinessHours(model.get(i));

            int TODAY = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

            if (businessHourView.getBusinessHours().getDayIndex() == TODAY) {
                businessHourView.seBold(true);
            }

            this.addView(businessHourView, i);
        }

        invalidate();
    }

    void filter() {
        // put the current day on top of the model

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


    }

    public void setModel(List<BusinessHours> model) {

        if (model != null) {
            this.model = model;
            update();
        }

    }

}
