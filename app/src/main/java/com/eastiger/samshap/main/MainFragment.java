package com.eastiger.samshap.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastiger.samshap.R;
import com.eastiger.samshap.select.SelectGameActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @OnClick(R.id.buttonStart)
    public void onClickStartButton() {
        getContext().startActivity(new Intent(getContext(), SelectGameActivity.class));
    }

    @OnClick(R.id.buttonOption)
    public void onClickOptionButton() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
