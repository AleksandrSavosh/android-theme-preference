package com.aleksandr.settings.theme;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public class ThemedActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        ThemeHelper.configureTheme(this);
        super.setContentView(layoutResID);
    }
}
