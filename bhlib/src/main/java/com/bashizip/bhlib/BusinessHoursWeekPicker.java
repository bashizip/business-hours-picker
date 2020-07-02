package com.bashizip.bhlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BusinessHoursWeekPicker extends LinearLayout {

    List<BusinessHoursPicker> businessHoursPickerList = new LinkedList<>();

    private List<BusinessHours> businessHoursList = new ArrayList<>();

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
        setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        this.setOrientation(VERTICAL);
        init(context);
    }

    private void init(Context context) {

        BusinessHoursPicker monday = new BusinessHoursPicker(this.getContext());
        monday.setDayOfWeek(context.getString(R.string.bhv_monday));
        businessHoursPickerList.add(monday);
        this.addView(monday, 0);

        BusinessHoursPicker tuesday = new BusinessHoursPicker(this.getContext());
        tuesday.setDayOfWeek(context.getString(R.string.bhv_tuesday));
        businessHoursPickerList.add(tuesday);
        this.addView(tuesday, 1);

        BusinessHoursPicker wednesday = new BusinessHoursPicker(this.getContext());
        wednesday.setDayOfWeek(context.getString(R.string.bhv_wednesday));
        businessHoursPickerList.add(wednesday);
        this.addView(wednesday, 2);

        BusinessHoursPicker thursday = new BusinessHoursPicker(this.getContext());
        thursday.setDayOfWeek(context.getString(R.string.bhv_thursday));
        businessHoursPickerList.add(thursday);
        this.addView(thursday, 3);

        BusinessHoursPicker friday = new BusinessHoursPicker(this.getContext());
        friday.setDayOfWeek(context.getString(R.string.bhv_friday));
        businessHoursPickerList.add(friday);
        this.addView(friday, 4);

        BusinessHoursPicker saturday = new BusinessHoursPicker(this.getContext());
        saturday.setDayOfWeek(context.getString(R.string.bhv_saturday));
        businessHoursPickerList.add(saturday);
        this.addView(saturday, 5);

        BusinessHoursPicker sunday = new BusinessHoursPicker(this.getContext());
        sunday.setDayOfWeek(context.getString(R.string.bhv_sunday));
        businessHoursPickerList.add(sunday);
        this.addView(sunday, 6);
    }

    private void update() {
        for (BusinessHours bh : businessHoursList) {
            for(BusinessHoursPicker picker: businessHoursPickerList){
                if(bh.getDayOfWeek().equals(picker.getDayOfWeek())){
                    picker.setBusinessHours(bh);
                    picker.invalidate();
                }
            }
        }
        invalidate();
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

    public void setBusinessHoursList(List<BusinessHours> businessHoursList) {
        this.businessHoursList = businessHoursList;
        update();
    }


}
