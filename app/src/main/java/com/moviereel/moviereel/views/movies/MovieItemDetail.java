package com.moviereel.moviereel.views.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.moviereel.moviereel.R;

/**
 * Movie Item details. This will be default view for Movie Item details*/
public class MovieItemDetail extends AppCompatActivity {
    private MaterialViewPager materialViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_item_details);
        materialViewPager = (MaterialViewPager)findViewById(R.id.movieitem_materialViewPager);
    }


}
