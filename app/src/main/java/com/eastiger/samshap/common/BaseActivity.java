package com.eastiger.samshap.common;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(parent, name, context, attrs);
        onInject();
        return view;
    }

    protected abstract void onInject();
}