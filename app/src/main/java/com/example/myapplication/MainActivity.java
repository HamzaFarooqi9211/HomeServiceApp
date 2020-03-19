package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;
    TextView textView;
    TextView textViewHeader;

    int[] sampleImages = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    String[] textImagesHeading = {"Electrition", "Plumber", "Maasi"};

    String[] textImages = {"Electrition is very nice", "Plumber is very nice", "Maasi is very nice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        textView = findViewById(R.id.imageText);
        textViewHeader=findViewById(R.id.imageTextHeading);

        carouselView.addOnPageChangeListener(onPageChangeListener);
        carouselView.setImageListener(imageListener);


    }

    ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            textView.setText(textImages[position]);
            textViewHeader.setText(textImagesHeading[position]);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }};
    ImageListener imageListener=new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            imageView.setImageResource(sampleImages[position]);


        }
    };
}
