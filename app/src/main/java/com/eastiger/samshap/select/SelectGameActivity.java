package com.eastiger.samshap.select;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.eastiger.samshap.R;
import com.eastiger.samshap.common.ObjectUtils;

public class SelectGameActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);

        if (ObjectUtils.isEmpty(savedInstanceState)) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutFragment, new SelectGameFragment())
                    .commitAllowingStateLoss();
        }
    }
}
