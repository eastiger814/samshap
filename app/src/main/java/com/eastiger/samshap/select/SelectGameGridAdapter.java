package com.eastiger.samshap.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.eastiger.samshap.R;
import com.eastiger.samshap.game.ShapeGame;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class SelectGameGridAdapter extends BaseAdapter {

    private Context context;
    private final List<ShapeGame> shapeGameList;
    private PublishSubject<Integer> selectGameSubject;

    //Constructor to initialize values
    public SelectGameGridAdapter(Context context, List<ShapeGame> shapeGameList) {
        this.context = context;
        this.shapeGameList = shapeGameList;
        this.selectGameSubject = PublishSubject.create();
    }

    @Override
    public int getCount() {
        // Number of times getView method call depends upon shapeGameList.length
        return shapeGameList.size();
    }

    @Override
    public Object getItem(int position) {
        return shapeGameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Number of times getView method call depends upon shapeGameList.length
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.grid_item_select_game, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.buttonSelectGame.setText(String.format(Locale.getDefault(), "%d-%02d", shapeGameList.get(position).getShapeOrderList().size(), position));
        holder.buttonSelectGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectGameSubject.onNext(position);
            }
        });
        return convertView;
    }

    public Observable<Integer> getSelectGameObservable() {
        return selectGameSubject;
    }

    static class ViewHolder {
        @BindView(R.id.buttonSelectGame)
        Button buttonSelectGame;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}