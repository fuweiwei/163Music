package com.veer.music.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.veer.music.R;
import com.veer.music.utils.StatusBarUtil;

/**
 * 基类  所有activity多必须继承
 * Created by Veer
 * date 17/2/23.
 */

public class BaseActivity extends AppCompatActivity implements FragmentResultCallback {
    protected BaseActivity mThis = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(mThis,R.color.colorPrimary));
    }
}
