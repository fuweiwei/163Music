package com.veer.music.support.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 描述
 * Created by Veer
 * date 17/3/1.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;                         //fragment列表
    private List<String> list_title;                              //tab名的列表
    public TabFragmentAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return list_title.get(position % list_title.size());
    }
}
