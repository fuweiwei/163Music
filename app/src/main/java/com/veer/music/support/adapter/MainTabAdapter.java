package com.veer.music.support.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.veer.music.app.BaseFragment;
import com.veer.music.module.fragment.DiscoverFragment;
import com.veer.music.module.fragment.FriendsFragment;
import com.veer.music.module.fragment.MusicFragment;

/**
 * 描述
 * Created by Veer
 * date 17/2/24.
 */

public class MainTabAdapter extends FragmentPagerAdapter {
    public MainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        switch (position){
            case 0:
                fragment = new DiscoverFragment();
                break;
            case 1:
                fragment = new MusicFragment();
                break;
            case 2:
                fragment = new FriendsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
