package com.veer.music.module.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;
import com.veer.music.config.Config;
import com.veer.music.utils.StatusBarUtil;

/**
 * 描述
 * Created by Veer
 * date 17/2/27.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    }

    @Override
    protected void initToolBar() {
        super.initToolBar(toolbar);
        toolbar.setTitle("设置");

    }


}
