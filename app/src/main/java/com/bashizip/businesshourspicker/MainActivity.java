package com.bashizip.businesshourspicker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;


import com.bashizip.bhlib.BusinessHours;
import com.bashizip.bhlib.BusinessHoursWeekPicker;
import com.bashizip.bhlib.ValdationException;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String BH_LIST = "bh_list";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAndroidId();

        BusinessHoursWeekPicker bh_picker = findViewById(R.id.bh_picker);
        Button btn_apply = findViewById(R.id.btn_apply);
        Button btn_view = findViewById(R.id.btn_view);

        List<BusinessHours> savedList = (List<BusinessHours>) getIntent().getSerializableExtra(BH_LIST);
        if (savedList != null) {
            bh_picker.setBusinessHoursList(savedList);
        }

        btn_apply.setOnClickListener(view -> {
            List<BusinessHours> bhs = null;
            try {
                bhs = bh_picker.getBusinessHoursList();

            } catch (ValdationException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(BH_LIST, (Serializable) bhs);
            startActivity(intent);

        });

        btn_view.setOnClickListener(view -> {
            List<BusinessHours> bhs = null;
            try {
                bhs = bh_picker.getBusinessHoursList();
            } catch (ValdationException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, ViewerActivity.class);
            intent.putExtra(BH_LIST, (Serializable) bhs);
            startActivity(intent);
        });
    }

    void checkAndroidId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            @SuppressLint("HardwareIds")
            String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
            Log.d("DeviceId", deviceId);
        }
    }
}
