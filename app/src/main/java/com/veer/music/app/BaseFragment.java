package com.veer.music.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veer.music.R;
import com.veer.music.config.Config;
import com.veer.music.support.listener.ThemeStatusListener;
import com.veer.music.utils.PreferenceUtils;

/**
 * 基类 所有fragment都必须继承
 * Created by Veer
 * date 17/2/23.
 */

public class BaseFragment extends Fragment implements ThemeStatusListener {
    protected int mThemeColor ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mThemeColor = PreferenceUtils.getInstance(getActivity()).getIntParam(Config.SP_BAR_COLOR,
                ContextCompat.getColor(getActivity(),R.color.colorPrimary));
    }


    @Override
    public void updateTheme(int color) {
        mThemeColor = color;
    }
}
