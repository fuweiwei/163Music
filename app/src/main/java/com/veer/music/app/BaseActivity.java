package com.veer.music.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.veer.music.R;
import com.veer.music.config.Config;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.utils.StatusBarUtil;

import static com.veer.music.R.id.toolbar;

/**
 * 基类  所有activity多必须继承
 * Created by Veer
 * date 17/2/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements FragmentResultCallback {
    protected BaseActivity mThis = this;
    protected Toolbar mToolbar;
    protected int mThemeColor ;
    //底部播放bar
    protected RelativeLayout mMusicBar;
    protected View mMusicView;
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
        mToolbar = (Toolbar) findViewById(toolbar);
        mMusicBar = (RelativeLayout) findViewById(R.id.layout_container);
        mThemeColor = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        initToolBar();
        setStatusBar();
        initMusicBar();
    }

    protected void setStatusBar() {
        int color = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        mThemeColor = color;
        StatusBarUtil.setColorForSwipeBack(this, color,Config.BAR_TRANSPARENT);
        mToolbar.setBackgroundColor(color);
    }
    protected void initToolBar(Toolbar toolbar){
        if(toolbar==null)return;
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    protected  void initMusicBar(){
        if(mMusicBar==null)return;
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//addRule参数对应RelativeLayout XML布局的属性
        LayoutInflater  inflater = (LayoutInflater) mThis
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMusicView = inflater.inflate(R.layout.include_music_paybar,null,false);
        mMusicView.setLayoutParams(layoutParams);

    }
    protected void hideMusicBar(){
        if(mMusicBar==null)return;
        mMusicBar.removeAllViews();

    }
    protected void showMusicBar(){
        if(mMusicView==null)return;
        if(mMusicBar==null)return;
        mMusicBar.addView(mMusicView);
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
