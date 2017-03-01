package com.veer.music.module.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;
import com.veer.music.config.Config;
import com.veer.music.module.fragment.friends.GoodFriendsFragment;
import com.veer.music.module.fragment.friends.NearbyFragment;
import com.veer.music.module.fragment.friends.TrendsFragment;
import com.veer.music.support.adapter.TabFragmentAdapter;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.widget.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 朋友圈界面
 * Created by Veer
 * date 17/2/24.
 */

public class FriendsFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ChildViewPager viewPager;
    private TabFragmentAdapter mAdapter;
    private List<Fragment> mFragments ;
    private List<String> mTitles;

    private TrendsFragment mTrendsFragment;
    private GoodFriendsFragment mGoodFriendsFragment;
    private NearbyFragment mNearbyFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends,container,false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ChildViewPager) view.findViewById(R.id.viewPager);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        mTitles.add("动态");
        mTitles.add("附近");
        mTitles.add("好友");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for(String string:mTitles){
            tabLayout.addTab(tabLayout.newTab().setText(string));
        }
        mTrendsFragment = new TrendsFragment();
        mNearbyFragment = new NearbyFragment();
        mGoodFriendsFragment = new GoodFriendsFragment();
        mFragments.add(mTrendsFragment);
        mFragments.add(mNearbyFragment);
        mFragments.add(mGoodFriendsFragment);
        mAdapter = new TabFragmentAdapter(getChildFragmentManager(),mFragments,mTitles);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //主题
        int color = PreferenceUtils.getInstance(getActivity()).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(getActivity(),R.color.colorPrimary));
        tabLayout.setTabTextColors(ContextCompat.getColor(getActivity(),R.color.black),color);
        tabLayout.setSelectedTabIndicatorColor(color);
    }
    @Override
    public void updateTheme(int color) {
        super.updateTheme(color);
        if(tabLayout==null)return;
        tabLayout.setTabTextColors(ContextCompat.getColor(getActivity(),R.color.black),color);
        tabLayout.setSelectedTabIndicatorColor(color);

    }
}
