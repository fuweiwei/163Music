package com.veer.music.module.fragment.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;

/**
 * 主播电台界面
 * Created by Veer
 * date 17/2/24.
 */

public class RadioFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_radio,container,false);
        return view;
    }
}
