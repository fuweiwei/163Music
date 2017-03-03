package com.veer.music.module.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;

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
        super.initToolBar(mToolbar);
        mToolbar.setTitle("设置");

    }

}
