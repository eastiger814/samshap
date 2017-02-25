package com.eastiger.samshap.play;

import android.os.Bundle;

import com.eastiger.samshap.R;
import com.eastiger.samshap.common.BaseActivity;

public class PlayGameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
    }

    @Override
    protected void onInject() {
    }
}
