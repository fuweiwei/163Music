package com.veer.music.module.fragment.friends;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;
import com.veer.music.utils.ToastUtils;

/**
 * 动态界面
 * Created by Veer
 * date 17/2/24.
 */

public class TrendsFragment extends BaseFragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends_trends,container,false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        textView = (TextView) view.findViewById(R.id.text);
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
        //主题
        swipeRefreshLayout.setColorSchemeColors(mThemeColor);
        textView.setTextColor(mThemeColor);
    }
}
