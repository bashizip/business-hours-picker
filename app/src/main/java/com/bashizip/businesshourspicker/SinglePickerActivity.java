package com.bashizip.businesshourspicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bashizip.bhlib.BusinessHours;
import com.bashizip.bhlib.BusinessHoursPicker;

public class SinglePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_picker);
        BusinessHoursPicker picker = findViewById(R.id.single_picker);
        BusinessHours model = new BusinessHours();
        model.setOpenDay(true);
        model.setDayOfWeek("Friday");
        model.setFrom(getResources().getStringArray(com.bashizip.bhlib.R.array.busines_hours)[1]);
        model.setTo(getResources().getStringArray(com.bashizip.bhlib.R.array.busines_hours)[20]);
        picker.setBusinessHours(model);
    }
}