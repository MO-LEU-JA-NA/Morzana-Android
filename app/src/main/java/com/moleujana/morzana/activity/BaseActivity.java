package com.moleujana.morzana.activity;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    //Auto Bind
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
