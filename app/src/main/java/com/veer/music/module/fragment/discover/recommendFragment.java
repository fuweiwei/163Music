package com.veer.music.module.fragment.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;

/**
 * 个性推荐界面
 * Created by Veer
 * date 17/2/24.
 */

public class RecommendFragment extends BaseFragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_recommend,container,false);
        textView = (TextView) view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.setTextColor(mThemeColor);
    }

    @Override
    public void updateTheme(int color) {
        super.updateTheme(color);
        textView.setTextColor(mThemeColor);
    }
}
