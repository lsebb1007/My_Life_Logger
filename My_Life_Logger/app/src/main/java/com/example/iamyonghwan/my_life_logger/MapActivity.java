package com.example.iamyonghwan.my_life_logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {
    private GpsInfo gps;
    double latitude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Button button01 = (Button) findViewById(R.id.button01);



        button01.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                gps = new GpsInfo(MapActivity.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {

                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();

                    Toast.makeText(
                            getApplicationContext(),
                            "당신의 위치 - \n위도: " + latitude + "\n경도: " + longitude,
                            Toast.LENGTH_LONG).show();

                } else {
                    // GPS 를 사용할수 없으므로
                    gps.showSettingsAlert();
                }
            }
        });
    }
}