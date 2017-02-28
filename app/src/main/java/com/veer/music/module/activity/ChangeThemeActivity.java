package com.veer.music.module.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;
import com.veer.music.config.Config;
import com.veer.music.support.eventbus.ThemeChangeEvent;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.Random;

/**
 * 描述
 * Created by Veer
 * date 17/2/27.
 */

public class ChangeThemeActivity extends BaseActivity {
    private Button mBtnChangeColor;
    private int mColor = Color.RED;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);
        mBtnChangeColor = (Button) findViewById(R.id.btn_change);
        mBtnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mColor = 0xff000000 | random.nextInt(0xffffff);
                toolbar.setBackgroundColor(mColor);
                PreferenceUtils.getInstance(mThis).saveParam(Config.SP_BAR_COLOR,mColor);
                StatusBarUtil.setColorForSwipeBack(ChangeThemeActivity.this, mColor, Config.BAR_TRANSPARENT);
                EventBus.getDefault().post(new ThemeChangeEvent(mColor));
            }
        });
    }

    @Override
    protected void initToolBar() {
        super.initToolBar(toolbar);
        toolbar.setTitle("更换主题");
    }

}
