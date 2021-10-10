package com.akayush1108.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String url1 = "https://raw.githubusercontent.com/akayush1108/Data_Structures_codes/master/20210630_111845_0000.png";
    String url2 = "https://raw.githubusercontent.com/akayush1108/Data_Structures_codes/master/InShot_20211009_040554227.jpg";
    String url3 = "https://raw.githubusercontent.com/akayush1108/Data_Structures_codes/master/20211009_035611_0001.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();


        //Button button1 = findViewById(R.id.btn);
        button1 = (Button) findViewById(R.id.btn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PdfActivity1.class);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.btn2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PdfActivity2.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.btn3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PdfActivity3.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.btn4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PdfActivity4.class);
                startActivity(intent);
            }
        });



    }
}