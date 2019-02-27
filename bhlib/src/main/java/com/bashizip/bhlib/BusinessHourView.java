package com.bashizip.bhlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BusinessHourView extends LinearLayout {


    TextView textView;
    BusinessHours businessHours;
    private String bhText;
    private View v;

    public BusinessHourView(Context context) {
        super(context);
        initViews(context, null);

    }

    public BusinessHourView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public BusinessHourView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }


    void initViews(Context context, AttributeSet attrs) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.business_hours_view, this, true);

        textView = v.findViewById(R.id.bh_text);

        TypedArray array = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.BusinessHoursWeekView, 0, 0);

        try {

            bhText = array.getString(R.styleable.BusinessHoursWeekView_bhText);


        } finally {
            array.recycle();
        }
    }

    public String getBhText() {
        return bhText;
    }

    public void setBhText(String bhText) {
        this.bhText = bhText;
        textView.setText(bhText);
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHours businessHours) {

        if (businessHours != null) {
            this.businessHours = businessHours;

            textView.setText(businessHours.toString());
        }
    }

    public void removeIcons() {
        textView.setCompoundDrawables(null, null, null, null);
    }

    public void seBold(boolean b) {
        textView.setTextSize(18.0f);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.invalidate();
    }
}
