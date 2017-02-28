package com.veer.music.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;
import com.veer.music.config.Config;
import com.veer.music.module.activity.ChangeThemeActivity;
import com.veer.music.module.activity.SettingActivity;
import com.veer.music.support.adapter.MainTabAdapter;
import com.veer.music.support.eventbus.ThemeChangeEvent;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;
    private ImageView imageView_menu;
    private LinearLayout linearLayout_discover,linearLayout_music,linearLayout_friends;
    private ImageView imageView_discover,imageView_music,imageView_friends;
    private ViewPager viewPager;
    private MainTabAdapter mAdapter;
    //menu
    private RelativeLayout menu_skin,menu_header;
    private TextView textView_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        EventBus.getDefault().register(mThis);

    }

    public void initViews() {
        menu_skin = (RelativeLayout) findViewById(R.id.menu_skin);
        menu_header = (RelativeLayout) findViewById(R.id.menu_header);
        textView_setting = (TextView) findViewById(R.id.menu_setting);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout_discover = (LinearLayout) findViewById(R.id.lin_discover);
        imageView_menu = (ImageView) findViewById(R.id.iv_menu);
        linearLayout_music = (LinearLayout) findViewById(R.id.lin_music);
        linearLayout_friends = (LinearLayout) findViewById(R.id.lin_friends);
        imageView_discover = (ImageView) findViewById(R.id.iv_discover);
        imageView_music = (ImageView) findViewById(R.id.iv_music);
        imageView_friends = (ImageView) findViewById(R.id.iv_friends);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        linearLayout_discover.setOnClickListener(this);
        linearLayout_friends.setOnClickListener(this);
        linearLayout_music.setOnClickListener(this);
        imageView_menu.setOnClickListener(this);
        menu_skin.setOnClickListener(this);
        textView_setting.setOnClickListener(this);
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
        int color = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        menu_header.setBackgroundColor(color);
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
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(ThemeChangeEvent event) {
        int color = event.getColor();
        StatusBarUtil.setColorForDrawerLayout(this, drawerLayout,
               color, Config.BAR_TRANSPARENT);
        toolbar.setBackgroundColor(color);
        menu_header.setBackgroundColor(color);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(mThis);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
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
            case R.id.menu_setting:
                intent = new Intent(mThis, SettingActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_skin:
                intent = new Intent(mThis, ChangeThemeActivity.class);
                startActivity(intent);
//                int mColor = Color.GRAY;
//                Random random = new Random();
//                mColor = 0xff000000 | random.nextInt(0xffffff);
//                toolbar.setBackgroundColor(mColor);
//                StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, mColor, 33);
//                menu_header.setBackgroundColor(mColor);
                break;
            default:
                break;
        }

    }

    @Override
    protected void setStatusBar() {
        int color = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawerLayout),
                color, Config.BAR_TRANSPARENT);
    }

    @Override
    protected void initToolBar() {
        setSupportActionBar(toolbar);
        int color = PreferenceUtils.getInstance(mThis).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(mThis,R.color.colorPrimary));
        toolbar.setBackgroundColor(color);
    }


}
