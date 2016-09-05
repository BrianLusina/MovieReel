package com.moviereel.moviereel.views;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.moviereel.moviereel.R;

public class SplashActivity extends AppCompatActivity {
    /*FIELDS*/
    private static final String SPLASH_SCREEN_TAG = SplashActivity.class.getSimpleName();
    private TextView appName;
    private ImageView appIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_activity_layout);

        initializeUICtrls();

        //set the timer
        Thread timer = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    Intent openMain = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(openMain);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                    Log.d(SPLASH_SCREEN_TAG, ie.toString());
                }
            }
        };
        //start timer
        timer.start();
    }

    /**Initializes the User Interface controls
     * obtains the appName, appTag and appIcon variables and finds their ids in the layout*/
    private void initializeUICtrls() {
        appIcon = (ImageView)findViewById(R.id.appicon_splash);
        appName = (TextView)findViewById(R.id.appname_splash);

        //set the fonts
        String fontPath = "fonts/Roboto-Black.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        appName.setTypeface(typeface);
    }

    /*kill this splash screen to save memory*/
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}/*END*/
