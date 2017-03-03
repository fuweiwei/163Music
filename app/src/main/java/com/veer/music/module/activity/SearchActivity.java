package com.veer.music.module.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;

/**
 * 搜索页面
 * Created by Veer
 * date 17/3/3.
 */

public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        showMusicBar();

    }

    @Override
    protected void initToolBar() {
        super.initToolBar(mToolbar);
        mToolbar.setTitle("搜索");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("请输入搜索内容");

        return true;
    }

}
