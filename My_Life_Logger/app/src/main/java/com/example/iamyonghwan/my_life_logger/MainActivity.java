package com.example.iamyonghwan.my_life_logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView_longWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_longWeather = (TextView)findViewById(R.id.longWeather);


    }



    public void onClickedButton1_1_1(View v){
        Intent myIntent = new Intent(getApplicationContext(),
                MapActivity.class);
        startActivity(myIntent);
    }

    public void onClickedButton1_1_2(View v){
        Intent myIntent = new Intent(getApplicationContext(),
                NoteActivity.class);
        startActivity(myIntent);
    }

    public void onClickedButton2_1(View v){
        Intent myIntent = new Intent(getApplicationContext(),
                HistoriesActivity.class);
        startActivity(myIntent);
    }

    public void onClickedButton2_2_1(View v){
        Intent myIntent = new Intent(getApplicationContext(),
                GraphActivity.class);
        startActivity(myIntent);
    }

    public void onClickedButton2_2_2(View v){
        Intent myIntent = new Intent(getApplicationContext(),
                ManagementActivity.class);
        startActivity(myIntent);
    }



}
