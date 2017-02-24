package com.veer.music.module;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;

/**
 *
 */
public class MainActivity extends BaseActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    public void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(mThis, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return true;
//    }
    }
}
