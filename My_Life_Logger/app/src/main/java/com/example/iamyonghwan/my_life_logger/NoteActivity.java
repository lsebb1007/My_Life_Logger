package com.example.iamyonghwan.my_life_logger;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by iamyonghwan on 2016-11-24.
 */



public class NoteActivity extends AppCompatActivity {

    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_GALLERY = 2;
    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        imgview = (ImageView) findViewById(R.id.imageView);
        ImageButton buttonCamera = (ImageButton) findViewById(R.id.btn_take_camera);
        ImageButton buttonGallery = (ImageButton) findViewById(R.id.btn_select_gallery);
        Button buttonstart = (Button) findViewById(R.id.button9) ;
        Button buttonstop = (Button) findViewById(R.id.button10) ;
        final TextView textView1 = (TextView) findViewById(R.id.text3);
        final TextView textView2 = (TextView) findViewById(R.id.text4);


        buttonstart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(getDateString()) ;
            }
        }) ;
        buttonstop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText(getDateString()) ;
            }
        }) ;
        buttonCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // 카메라 호출
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());

                // 이미지 잘라내기 위한 크기
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(intent, PICK_FROM_CAMERA);
                } catch (ActivityNotFoundException e) {
                    // Do nothing for now
                }
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent();
                // Gallery 호출
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // 잘라내기 셋팅
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);
                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
                } catch (ActivityNotFoundException e) {
                    // Do nothing for now
                }
            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        try {
            if (requestCode == PICK_FROM_CAMERA) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    imgview.setImageBitmap(photo);
                }
            }
            if (requestCode == PICK_FROM_GALLERY) {
                Bundle extras2 = data.getExtras();
                if (extras2 != null) {
                    Bitmap photo = extras2.getParcelable("data");
                    imgview.setImageBitmap(photo);
                }
            }
        } catch(NullPointerException e) {
        }

    }

    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
        String str_date = df.format(new Date());

        return str_date;
    }

}

