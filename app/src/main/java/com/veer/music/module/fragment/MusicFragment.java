package com.veer.music.module.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;
import com.veer.music.utils.ToastUtils;

/**
 * 音乐界面
 * Created by Veer
 * date 17/2/24.
 */

public class MusicFragment extends BaseFragment {
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music,container,false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 停止刷新
                        swipeRefreshLayout.setRefreshing(false);
                        ToastUtils.showShort(getActivity(),"刷新成功");
                    }
                }, 3000); // 3秒后发送消息，停止刷新
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if(swipeRefreshLayout!=null)swipeRefreshLayout.setColorSchemeColors(mThemeColor);
    }
}
