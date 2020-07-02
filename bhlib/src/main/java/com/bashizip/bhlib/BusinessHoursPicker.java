package com.bashizip.bhlib;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SwitchCompat;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BusinessHoursPicker extends LinearLayout {
    TextView tv_dayOfWeek, tv_to;
    SwitchCompat switch_open;
    AppCompatSpinner spin_bh_from;
    AppCompatSpinner spin_bh_to;

    View lyt_hours;

    private String dayOfWeek;
    private boolean isOpenDay;

    private String from;
    private String to;

    private BusinessHours businessHours;

    public BusinessHoursPicker(Context context) {
        super(context);
        initViews(context, null);
    }

    public BusinessHoursPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public BusinessHoursPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.business_hours_picker, this, true);

        tv_dayOfWeek = v.findViewById(R.id.tv_bh_dayofweek);
        switch_open = v.findViewById(R.id.switch_open);
        spin_bh_from = v.findViewById(R.id.spin_bh_from);
        spin_bh_to = v.findViewById(R.id.spin_bh_to);
        lyt_hours = v.findViewById(R.id.lyt_hours);
        tv_to = v.findViewById(R.id.tv_to);

        TypedArray array = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.BusinessHoursPicker, 0, 0);
        try {
            dayOfWeek = array.getString(R.styleable.BusinessHoursPicker_dayOfWeek);
            isOpenDay = array.getBoolean(R.styleable.BusinessHoursPicker_isOpenDay, false);

        } finally {
            array.recycle();
        }
        initModel();
        setupActions(dayOfWeek);
    }

    void initModel() {
        businessHours = new BusinessHours();
        businessHours.setDayIndex(0);
        businessHours.setOpenDay(false);
        businessHours.setFrom(getContext().getResources().getStringArray(R.array.busines_hours)[10]);
        businessHours.setTo(getContext().getResources().getStringArray(R.array.busines_hours)[20]);
    }

    private void update() {
        tv_dayOfWeek.setText(businessHours.getDayOfWeek());
        switch_open.setChecked(businessHours.isOpenDay());
        spin_bh_from.setSelection(getIndexOfTime(businessHours.getFrom()));
        spin_bh_to.setSelection(getIndexOfTime(businessHours.getTo()));
        invalidate();
    }

    int getIndexOfTime(String time) {
        String[] times = getContext().getResources().getStringArray(R.array.busines_hours);
        List<String> timesList = Arrays.asList(times);
        return timesList.indexOf(time);
    }

    public void setupActions(String day) {

        tv_dayOfWeek.setText(day);

        switch_open.setOnCheckedChangeListener((compoundButton, checked) ->
        {
            setOpenDay(checked);
            businessHours.setOpenDay(checked);

            if (checked) {
                lyt_hours.setVisibility(VISIBLE);
            } else {
                lyt_hours.setVisibility(GONE);
                from = "";
                to = "";
                spin_bh_from.setSelection(0);
                spin_bh_to.setSelection(0);
            }

        });

        spin_bh_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                from = adapterView.getItemAtPosition(position).toString();
                String allDay = BusinessHoursPicker.this.getContext().getString(R.string.all_day);
                if (from.equals(allDay)) {
                    spin_bh_to.setVisibility(INVISIBLE);
                    to = allDay;
                    tv_to.setVisibility(INVISIBLE);
                } else {
                    spin_bh_to.setVisibility(VISIBLE);
                    tv_to.setVisibility(VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spin_bh_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                to = adapterView.getItemAtPosition(position).toString();
                String allDay = BusinessHoursPicker.this.getContext().getString(R.string.all_day);

                if (to.equals(allDay)) {
                    spin_bh_from.setVisibility(INVISIBLE);
                    from = allDay;
                } else {
                    spin_bh_from.setVisibility(VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        businessHours = new BusinessHours(dayOfWeek, from, to);

        switch_open.setChecked(false);
        lyt_hours.setVisibility(GONE);

    }


    public boolean isOpenDay() {
        return isOpenDay;
    }

    public void setOpenDay(boolean openDay) {
        isOpenDay = openDay;
        switch_open.setChecked(isOpenDay);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        tv_dayOfWeek.setText(dayOfWeek);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BusinessHours getBusinessHours() throws ValdationException {

        businessHours.setDayOfWeek(dayOfWeek);
        businessHours.setFrom(from);
        businessHours.setTo(to);

        if (from.length() < 1) {
            if (to.length() < 1) {
                throw new ValdationException(getContext().getString(R.string.validation_exception_msg), dayOfWeek);
            }
        }


        if (dayOfWeek.equals(getContext().getString(R.string.bhv_sunday))) {
            businessHours.setDayIndex(1);
        }

        if (dayOfWeek.equals(getContext().getString(R.string.bhv_monday))) {
            businessHours.setDayIndex(2);
        }

        if (dayOfWeek.equals(getContext().getString(R.string.bhv_tuesday))) {
            businessHours.setDayIndex(3);
        }
        if (dayOfWeek.equals(getContext().getString(R.string.bhv_wednesday))) {
            businessHours.setDayIndex(4);
        }

        if (dayOfWeek.equals(getContext().getString(R.string.bhv_thursday))) {
            businessHours.setDayIndex(5);
        }

        if (dayOfWeek.equals(getContext().getString(R.string.bhv_friday))) {
            businessHours.setDayIndex(6);
        }
        if (dayOfWeek.equals(getContext().getString(R.string.bhv_saturday))) {
            businessHours.setDayIndex(7);
        }
        return businessHours;
    }

    public void setBusinessHours(BusinessHours bh) {
        businessHours = bh;
        update();
    }
}
