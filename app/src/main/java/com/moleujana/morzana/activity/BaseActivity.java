package com.moleujana.morzana.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    //Auto Bind
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View v = getWindow().getDecorView();

            int flags = v.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;

            v.setSystemUiVisibility(flags);
        }
    }
}
