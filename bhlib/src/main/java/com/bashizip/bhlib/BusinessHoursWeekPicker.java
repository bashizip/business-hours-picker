package com.bashizip.bhlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BusinessHoursWeekPicker extends LinearLayout {

    List<BusinessHoursPicker> businessHoursPickerList;

    private List<BusinessHours> businessHoursList;

    public BusinessHoursWeekPicker(Context context) {
        super(context);
        initViews(context, null);
    }

    public BusinessHoursWeekPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public BusinessHoursWeekPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.business_hours_week_picker, this, true);

        businessHoursPickerList = new LinkedList<>();

        this.setOrientation(VERTICAL);

        BusinessHoursPicker monday = new BusinessHoursPicker(this.getContext());
        monday.setDayOfWeek(context.getString(R.string.bhv_monday));
        businessHoursPickerList.add(monday);
        this.addView(monday, 1);

        BusinessHoursPicker tuesday = new BusinessHoursPicker(this.getContext());
        tuesday.setDayOfWeek(context.getString(R.string.bhv_tuesday));
        businessHoursPickerList.add(tuesday);
        this.addView(tuesday, 2);

        BusinessHoursPicker wednesday = new BusinessHoursPicker(this.getContext());
        wednesday.setDayOfWeek(context.getString(R.string.bhv_wednesday));
        businessHoursPickerList.add(wednesday);
        this.addView(wednesday, 3);

        BusinessHoursPicker thursday = new BusinessHoursPicker(this.getContext());
        thursday.setDayOfWeek(context.getString(R.string.bhv_thursday));
        businessHoursPickerList.add(thursday);
        this.addView(thursday, 4);

        BusinessHoursPicker friday = new BusinessHoursPicker(this.getContext());
        friday.setDayOfWeek(context.getString(R.string.bhv_friday));
        businessHoursPickerList.add(friday);
        this.addView(friday, 5);

        BusinessHoursPicker saturday = new BusinessHoursPicker(this.getContext());
        saturday.setDayOfWeek(context.getString(R.string.bhv_saturday));
        businessHoursPickerList.add(saturday);
        this.addView(saturday, 6);

        BusinessHoursPicker sunday = new BusinessHoursPicker(this.getContext());
        sunday.setDayOfWeek(context.getString(R.string.bhv_sunday));
        businessHoursPickerList.add(sunday);
        this.addView(sunday, 7);


    }

    public List<BusinessHours> getBusinessHoursList() throws ValdationException {
        businessHoursList = new ArrayList<>();
        for (BusinessHoursPicker view : businessHoursPickerList) {
            if (view.isOpenDay()) {
                businessHoursList.add(view.getBusinessHours());
            }
        }
        return businessHoursList;
    }


}
