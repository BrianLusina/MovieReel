package com.moviereel.moviereel.introduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.main.MainActivity;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel.introduction
 * Created by lusinabrian on 05/09/16 at 15:24
 * Description: Simple app introduction class
 */
public class AppIntroduction extends AppIntro2 {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: change app introduction
        /*1st Fragment*/
        addSlide(AppIntroFragment.newInstance(getString(R.string.app_name), "Reeling in the shows", R.mipmap.ic_launcher, ContextCompat.getColor(this,R.color.dark_slate_blue)));

        /*2nd Fragment*/
        addSlide(AppIntroFragment.newInstance(getString(R.string.app_name), "desc", R.mipmap.ic_launcher, ContextCompat.getColor(this,R.color.indigo_600)));

        /*3rd Fragment*/
        addSlide(AppIntroFragment.newInstance(getString(R.string.app_name), "desc", R.mipmap.ic_launcher, ContextCompat.getColor(this,R.color.indigo_500)));

        /*4th Fragment*/
        addSlide(AppIntroFragment.newInstance(getString(R.string.app_name), "GET STARTED", R.mipmap.ic_launcher,ContextCompat.getColor(this,R.color.md_indigo_400)));
        setProgressButtonEnabled(true);

        /*animation*/
        setDepthAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        openMain();
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        openMain();
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }

    /**open main activity*/
    public void openMain(){
        Intent openMain = new Intent(AppIntroduction.this, MainActivity.class);
        startActivity(openMain);
    }
}