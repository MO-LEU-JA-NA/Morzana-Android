package com.moleujana.morzana.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.moleujana.morzana.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private TextView toolbarTitle;

    //Auto Bind
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mTitle = getSupportTitle();
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View v = getWindow().getDecorView();

            int flags = v.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;

            v.setSystemUiVisibility(flags);
        }
    }

    @Override
    public void setTitle(int titleId) {
        mTitle = getText(titleId);
        if (toolbarTitle != null) toolbarTitle.setText(titleId);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        if (toolbarTitle != null) toolbarTitle.setText(title);
    }

    public final CharSequence getSupportTitle() {
        if (mTitle == null) return getString(R.string.app_name_eng);
        return mTitle;
    }

    @Nullable
    public TextView getSupportActionBarTitle() {
        return toolbarTitle;
    }

    @Override
    public void setSupportActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar, null);
    }

    public void setSupportActionBar(Toolbar toolbar, TextView toolbarTitle) {
        super.setSupportActionBar(toolbar);
        this.toolbarTitle = toolbarTitle;
        if (mTitle != null) if (this.toolbarTitle != null) this.toolbarTitle.setText(mTitle);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
