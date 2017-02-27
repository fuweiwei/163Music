package com.veer.music.module;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;
import com.veer.music.support.adapter.MainTabAdapter;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView imageView_menu;
    private LinearLayout linearLayout_discover,linearLayout_music,linearLayout_friends;
    private ImageView imageView_discover,imageView_music,imageView_friends;
    private ViewPager viewPager;
    private MainTabAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    public void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout_discover = (LinearLayout) findViewById(R.id.lin_discover);
        imageView_menu = (ImageView) findViewById(R.id.iv_menu);
        linearLayout_music = (LinearLayout) findViewById(R.id.lin_music);
        linearLayout_friends = (LinearLayout) findViewById(R.id.lin_friends);
        imageView_discover = (ImageView) findViewById(R.id.iv_discover);
        imageView_music = (ImageView) findViewById(R.id.iv_music);
        imageView_friends = (ImageView) findViewById(R.id.iv_friends);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        linearLayout_discover.setOnClickListener(this);
        linearLayout_friends.setOnClickListener(this);
        linearLayout_music.setOnClickListener(this);
        imageView_menu.setOnClickListener(this);
        mAdapter = new MainTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setTabSelected(0);
    }


    private void setTabSelected(int id){
        viewPager.setCurrentItem(id);
        imageView_friends.setImageResource(R.drawable.actionbar_friends_normal);
        imageView_music.setImageResource(R.drawable.actionbar_music_normal);
        imageView_discover.setImageResource(R.drawable.actionbar_discover_normal);
        switch (id){
            case 0:
                imageView_discover.setImageResource(R.drawable.actionbar_discover_selected);
                break;
            case 1:
                imageView_music.setImageResource(R.drawable.actionbar_music_selected);
                break;
            case 2:
                imageView_friends.setImageResource(R.drawable.actionbar_friends_selected);
                break;
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lin_discover:
                setTabSelected(0);
                break;
            case R.id.lin_music:
                setTabSelected(1);
                break;
            case R.id.lin_friends:
                setTabSelected(2);
                break;
            case R.id.iv_menu:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            default:
                break;
        }

    }
}
