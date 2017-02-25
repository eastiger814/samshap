package com.eastiger.samshap.play;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eastiger.samshap.R;
import com.eastiger.samshap.common.BaseFragment;
import com.eastiger.samshap.play.di.DaggerPlayGameComponent;
import com.eastiger.samshap.play.di.PlayGameModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class PlayGameFragment extends BaseFragment implements PlayGameView {
    @Inject
    PlayGamePresenter presenter;

    @BindView(R.id.linearLayoutFullscreenContentControls)
    LinearLayout linearLayoutFullscreenContentControls;

    @BindView(R.id.gridViewContent)
    GridView gridViewContent;

    @OnClick(R.id.buttonShowTitleBar)
    public void onClickShowTitleBarButton() {

    }

    @Override
    protected void onInject() {
        ((DaggerPlayGameComponent) DaggerPlayGameComponent.builder()
                .playGameModule(new PlayGameModule(this))
                .build()).
                inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        makeGrid(3, 3);
    }

    private void makeGrid(int column, int row) {
        // This Data show in grid ( Used by adapter )
        String[] GRID_DATA = new String[]{
                "Windows",
                "iOS",
                "Android",
                "Blackberry",
                "Java",
                "JQuery",
                "Phonegap",
                "SQLite",
                "Thread",
                "Video"
        };

        // Set custom adapter (GridAdapter) to gridview
        //gridView.setColumnWidth(3);
        gridViewContent.setNumColumns(3);
        gridViewContent.setAdapter(new PlayGameGridAdapter(getContext(), GRID_DATA));
        gridViewContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getContext(), ((TextView) v.findViewById(R.id.grid_item_label)).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateDataList() {

    }
}
