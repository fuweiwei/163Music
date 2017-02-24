package com.veer.music.module;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.veer.music.R;
import com.veer.music.app.BaseActivity;

/**
 *
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
//        toolbar.setNavigationIcon(R.drawable.actionbar_menu);
//        toolbar.setOnMenuItemClickListener(onMenuItemClick);

    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_discover:
                    msg += "Click action_discover";
                    break;
                case R.id.action_music:
                    msg += "Click action_music";
                    break;
                case R.id.action_friends:
                    msg += "Click action_friends";
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        return true;
//    }
}
