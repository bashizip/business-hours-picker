package com.bashizip.bhlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class BusinessHoursWeekView extends LinearLayout {


    private int bhTextColor;
    private int bhTextSize;
    private Drawable bhIcon;
    private int bhIconPadding;
    private int bhTextStyle;
    private Drawable bhTodayIcon;
    private int bhTodayColor;
    private int bhTodayStyle;
    private int bhTodaySize;

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
        setMinimumHeight(50);

        TypedArray array = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.BusinessHoursWeekView, 0, 0);

        try {

            bhTextColor = array.getColor(R.styleable.BusinessHoursWeekView_bhTextColor, ContextCompat.getColor(getContext(), R.color.text_default_color));
            bhIcon = array.getDrawable(R.styleable.BusinessHoursWeekView_bhIcon);
            bhTodayIcon = array.getDrawable(R.styleable.BusinessHoursWeekView_bhTodayIcon);
            bhIconPadding = array.getInt(R.styleable.BusinessHoursWeekView_bhIconPadding, 16);
            bhTextSize = array.getInt(R.styleable.BusinessHoursWeekView_bhTextSize, 14);
            bhTextStyle = array.getInt(R.styleable.BusinessHoursWeekView_bhTextStyle, Typeface.NORMAL);
            bhTodayColor = array.getColor(R.styleable.BusinessHoursWeekView_bhTodayColor, ContextCompat.getColor(getContext(), R.color.text_default_color));
            bhTodaySize = array.getInt(R.styleable.BusinessHoursWeekView_bhTodayTextSize, 14);
            bhTodayStyle = array.getInt(R.styleable.BusinessHoursWeekView_bhTodayStyle, Typeface.BOLD);

        } finally {
            array.recycle();
        }

        model = new ArrayList<>();
        initModel();
        update();
    }

    private void initModel() {

        BusinessHours bh1 = new BusinessHours(getContext().getString(R.string.bhv_sunday), "08:00 am", "17:00 pm");
        BusinessHours bh2 = new BusinessHours(getContext().getString(R.string.bhv_monday), "08:00 am", "17:00 pm");
        BusinessHours bh3 = new BusinessHours(getContext().getString(R.string.bhv_tuesday), "08:00 am", "17:00 pm");
        BusinessHours bh4 = new BusinessHours(getContext().getString(R.string.bhv_wednesday), "08:00 am", "17:00 pm");
        BusinessHours bh5 = new BusinessHours(getContext().getString(R.string.bhv_thursday), "08:00 am", "17:00 pm");
        BusinessHours bh6 = new BusinessHours(getContext().getString(R.string.bhv_friday), "08:00 am", "17:00 pm");
        BusinessHours bh7 = new BusinessHours(getContext().getString(R.string.bhv_saturday), "08:00 am", "17:00 pm");

        model.add(bh1);
        model.add(bh2);
        model.add(bh3);
        model.add(bh4);
        model.add(bh5);
        model.add(bh6);
        model.add(bh7);
    }

    private void update() {

        if (this.getChildCount() > 0) {
            this.removeAllViews();
        }
        invalidate();
        TextView tv;
        for (int i = 0; i < model.size(); i++) {

            tv = new TextView(this.getContext());
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(layoutParams);

            BusinessHours bhv = model.get(i);
            tv.setText(bhv.toString());
            tv.setTextColor(bhTextColor);
            tv.setTextSize(bhTextSize);
            tv.setTypeface(Typeface.defaultFromStyle(bhTextStyle));

            tv.setCompoundDrawablesWithIntrinsicBounds(bhIcon, null, null, null);
            tv.setCompoundDrawablePadding(bhIconPadding);

            int TODAY = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

            if (bhv.getDayIndex() == TODAY) {
                tv.setTextSize(bhTodaySize);
              //  tv.setTypeface(Typeface.defaultFromStyle(bhTodayStyle), Typeface.BOLD);
                tv.setTextColor(bhTodayColor);
                tv.setCompoundDrawablesWithIntrinsicBounds(bhTodayIcon, null, null, null);

            }
            this.addView(tv, i);
        }
        invalidate();
    }

    public void setModel(List<BusinessHours> model) {
        if (model != null) {
            this.model = model;
            update();
        }
    }
}
