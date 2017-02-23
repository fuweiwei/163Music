package com.veer.music.app;

import android.content.Intent;

/**
 * Fragment 结果回调接口
 * Created by Veer
 * date 17/2/23.
 */

public interface FragmentResultCallback {

    /**
     * 结果反馈回调
     * @param requestCode 请求编码
     * @param resultCode  结果编码
     * @param data
     */
    void onFragmentResult(int requestCode, int resultCode, Intent data);
}
