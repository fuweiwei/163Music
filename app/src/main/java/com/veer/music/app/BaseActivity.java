package com.veer.music.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.veer.music.R;
import com.veer.music.config.Config;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.utils.StatusBarUtil;

/**
 * 基类  所有activity多必须继承
 * Created by Veer
 * date 17/2/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements FragmentResultCallback {
    protected BaseActivity mThis = this;
    protected Toolbar toolbar;
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar();
        setStatusBar();
    }

    protected void setStatusBar() {
        int color = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        StatusBarUtil.setColorForSwipeBack(this, color,Config.BAR_TRANSPARENT);
        toolbar.setBackgroundColor(color);
    }
    protected void initToolBar(Toolbar toolbar){
        if(toolbar==null)return;
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    /**
     * 增加了默认的返回finish事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    protected abstract void initToolBar();
}
