package com.bashizip.businesshourspicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bashizip.bhlib.BusinessHours;
import com.bashizip.bhlib.BusinessHoursWeekView;

import java.util.List;

public class ViewerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

        BusinessHoursWeekView businessHoursWeekView = findViewById(R.id.bh_view);

        Intent intent = getIntent();
        List<BusinessHours> businessHoursList = (List<BusinessHours>) intent.getSerializableExtra(MainActivity.BH_LIST);

        businessHoursWeekView.setModel(businessHoursList);
    }
}
