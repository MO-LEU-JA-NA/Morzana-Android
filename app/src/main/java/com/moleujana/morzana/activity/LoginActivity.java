package com.moleujana.morzana.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.moleujana.morzana.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TODO Login
        MainActivity.start(this);
        finish();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }
}
