package com.moleujana.morzana.activity;

import android.os.Bundle;
import android.os.Handler;

import com.moleujana.morzana.Constants;
import com.moleujana.morzana.R;
import com.moleujana.morzana.tools.Settings;

public class SplashActivity extends BaseActivity {

    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        settings = Settings.getInstance(this);

        new Handler().postDelayed(() -> {
            if (settings.contains(Constants.PREF_ID) && settings.contains(Constants.PREF_PW) && settings.contains(Constants.PREF_AUTO_LOGIN)) {
                //Auto Login
            } else {
                LoginActivity.start(this);
            }

            finish();
        }, 2000);
    }
}
