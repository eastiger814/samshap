package com.eastiger.samshap.select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.eastiger.samshap.R;
import com.eastiger.samshap.application.SamShapApplication;
import com.eastiger.samshap.common.BaseFragment;
import com.eastiger.samshap.play.PlayGameActivity;
import com.eastiger.samshap.select.di.DaggerSelectGameComponent;
import com.eastiger.samshap.select.di.SelectGameModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class SelectGameFragment extends BaseFragment implements SelectGameView {

    @Inject
    SelectGamePresenter presenter;

    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @BindView(R.id.gridViewGames)
    GridView gridViewGames;

    private SelectGameGridAdapter selectGameGridAdapter;

    @Override
    protected void onInject() {
        ((DaggerSelectGameComponent) DaggerSelectGameComponent.builder()
                .applicationComponent(((SamShapApplication) getActivity().getApplication()).getComponent())
                .selectGameModule(new SelectGameModule(this))
                .build()).
                inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_select_game, container, false);
        ButterKnife.bind(this, view);

        if (presenter == null) {
            Log.d("wanna", "onCreateView: presenter null");
        } else {
            Log.d("wanna", "onCreateView: presenter exist");
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set custom adapter (GridAdapter) to gridview
        presenter.makeGames();
        gridViewGames.setNumColumns(10);
        selectGameGridAdapter = new SelectGameGridAdapter(getContext(), presenter.getShapeGameList());
        gridViewGames.setAdapter(selectGameGridAdapter);
        gridViewGames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //TODO
                //Toast.makeText(getContext(), ((TextView) v.findViewById(R.id.grid_item_label)).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        selectGameGridAdapter.getSelectGameObservable()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer position) throws Exception {
                        startActivity(PlayGameActivity.newIntent(getContext(), presenter.getShapeGame(position)));
                    }
                });
    }

    @Override
    public void updateDataList() {
        selectGameGridAdapter.notifyDataSetChanged();
    }
}
