package com.veer.music.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
}
