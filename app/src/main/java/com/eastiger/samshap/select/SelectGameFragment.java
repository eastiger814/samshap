package com.eastiger.samshap.select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastiger.samshap.R;
import com.eastiger.samshap.application.SamShapApplication;
import com.eastiger.samshap.common.BaseFragment;
import com.eastiger.samshap.select.di.DaggerSelectGameComponent;
import com.eastiger.samshap.select.di.SelectGameModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SelectGameFragment extends BaseFragment implements SelectGameView {

    @Inject
    SelectGamePresenter presenter;

    @Override
    protected void onInject() {
        ((DaggerSelectGameComponent) DaggerSelectGameComponent.builder()
                .applicationComponent(((SamShapApplication)getActivity().getApplication()).getComponent())
                .selectGameModule(new SelectGameModule(this))
                .build()).
                inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_select_game, container, false);

        ButterKnife.bind(view);

        if (presenter == null) {
            Log.d("wanna", "onCreateView: presenter null");
        } else {
            Log.d("wanna", "onCreateView: presenter exist");
        }


        return view;
    }

    @Override
    public void updateDataList() {

    }
}
