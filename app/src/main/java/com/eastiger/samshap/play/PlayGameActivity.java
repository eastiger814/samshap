package com.eastiger.samshap.play;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.eastiger.samshap.R;
import com.eastiger.samshap.common.BaseActivity;
import com.eastiger.samshap.common.ObjectUtils;
import com.eastiger.samshap.game.ShapeGame;

import static com.eastiger.samshap.play.PlayGameFragment.ARG_SELECTED_SHAPE_GAME;

public class PlayGameActivity extends BaseActivity {

    private static final String EXTRA_SELECTED_SHAPE_GAME = "extra_selected_shape_game";

    public static Intent newIntent(Context context, ShapeGame shapeGame) {
        Intent intent = new Intent(context, PlayGameActivity.class);
        intent.putExtra(EXTRA_SELECTED_SHAPE_GAME, shapeGame);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        if (ObjectUtils.isEmpty(savedInstanceState)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ARG_SELECTED_SHAPE_GAME, getIntent().getParcelableExtra(EXTRA_SELECTED_SHAPE_GAME));

            PlayGameFragment playGameFragment = new PlayGameFragment();
            playGameFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutFragment, playGameFragment)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    protected void onInject() {
    }
}
