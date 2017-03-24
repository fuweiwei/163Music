package com.veer.music.module.fragment.friends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veer.music.R;
import com.veer.music.app.BaseFragment;

/**
 * 附近界面
 * Created by Veer
 * date 17/2/24.
 */

public class NearbyFragment extends BaseFragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends_nearby,container,false);
        textView = (TextView) view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //主题
        textView.setTextColor(mThemeColor);
    }
}
