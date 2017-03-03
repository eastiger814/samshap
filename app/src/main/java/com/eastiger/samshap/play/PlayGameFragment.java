package com.eastiger.samshap.play;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.eastiger.samshap.R;
import com.eastiger.samshap.application.SamShapApplication;
import com.eastiger.samshap.common.BaseFragment;
import com.eastiger.samshap.game.ShapeGame;
import com.eastiger.samshap.play.di.DaggerPlayGameComponent;
import com.eastiger.samshap.play.di.PlayGameModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayGameFragment extends BaseFragment implements PlayGameView {
    public static final String ARG_SELECTED_SHAPE_GAME = "arg_selected_shape_game";

    PlayGameShapesGridAdapter playGameShapesGridAdapter;

    @Inject
    PlayGamePresenter presenter;

    @BindView(R.id.gridViewOrder)
    GridView gridViewOrder;

    @BindView(R.id.gridViewShapes)
    GridView gridViewShapes;

    @Override
    protected void onInject() {
        ((DaggerPlayGameComponent) DaggerPlayGameComponent.builder()
                .applicationComponent(((SamShapApplication) getActivity().getApplication()).getComponent())
                .playGameModule(new PlayGameModule(this))
                .build()).
                inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_play_game, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setShapeGame((ShapeGame) getArguments().getParcelable(ARG_SELECTED_SHAPE_GAME));
        gridViewShapes.setNumColumns(presenter.getNumColumns());
        playGameShapesGridAdapter = new PlayGameShapesGridAdapter(getContext(), presenter);
        gridViewShapes.setAdapter(playGameShapesGridAdapter);
        gridViewShapes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.clickShape(position);
            }
        });

        gridViewOrder.setNumColumns(presenter.getShapeOrderList().size());
        gridViewOrder.setAdapter(new PlayGameOrderGridAdapter(getContext(), presenter.getShapeOrderList()));
    }

    @Override
    public void updateDataList() {
        playGameShapesGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCompleteGame() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setMessage(R.string.complete_game);
        alert.show();
    }
}
