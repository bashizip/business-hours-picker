package com.bashizip.businesshourspicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.bashizip.bhlib.BusinessHours;
import com.bashizip.bhlib.BusinessHoursWeekPicker;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String BH_LIST = "bh_list";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BusinessHoursWeekPicker bh_picker = findViewById(R.id.bh_picker);
        Button btn_apply = findViewById(R.id.btn_apply);

        btn_apply.setOnClickListener(view -> {

            List<BusinessHours> bhs = bh_picker.getBusinessHoursList();

            Intent intent = new Intent(this, ViewerActivity.class);
            intent.putExtra(BH_LIST, (Serializable) bhs);
            startActivity(intent);

        });
    }
}
