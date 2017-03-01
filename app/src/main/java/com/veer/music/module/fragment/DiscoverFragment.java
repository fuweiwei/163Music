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
import com.veer.music.module.fragment.discover.RadioFragment;
import com.veer.music.module.fragment.discover.RanklistFragment;
import com.veer.music.module.fragment.discover.RecommendFragment;
import com.veer.music.module.fragment.discover.SongFragment;
import com.veer.music.support.adapter.TabFragmentAdapter;
import com.veer.music.utils.PreferenceUtils;
import com.veer.music.widget.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现界面
 * Created by Veer
 * date 17/2/24.
 */

public class DiscoverFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ChildViewPager viewPager;
    private TabFragmentAdapter mAdapter;
    private List<Fragment> mFragments ;
    private List<String> mTitles;

    private RecommendFragment mRecommendFragment;
    private RadioFragment mRadioFragment;
    private RanklistFragment mRanklistFragment;
    private SongFragment mSongFragment;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        mTitles.add("个性推荐");
        mTitles.add("歌单");
        mTitles.add("主播电台");
        mTitles.add("牌行榜");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for(String string:mTitles){
            tabLayout.addTab(tabLayout.newTab().setText(string));
        }
        mRecommendFragment = new RecommendFragment();
        mRadioFragment = new RadioFragment();
        mRanklistFragment = new RanklistFragment();
        mSongFragment = new SongFragment();
        mFragments.add(mRecommendFragment);
        mFragments.add(mSongFragment);
        mFragments.add(mRadioFragment);
        mFragments.add(mRanklistFragment);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,container,false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ChildViewPager) view.findViewById(R.id.viewPager);
        return view;
    }

}
