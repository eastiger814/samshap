package com.eastiger.samshap.play;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.eastiger.samshap.R;
import com.eastiger.samshap.game.Shape;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayGameOrderGridAdapter extends BaseAdapter {

    private Context context;
    private final List<Shape> orderList;

    //Constructor to initialize values
    public PlayGameOrderGridAdapter(Context context, List<Shape> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @Override
    public int getCount() {
        // Number of times getView method call depends upon orderList.length
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Number of times getView method call depends upon orderList.length
    public View getView(final int position, View convertView, ViewGroup parent) {
        PlayGameShapesGridAdapter.ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView != null) {
            holder = (PlayGameShapesGridAdapter.ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.grid_item_play_game, parent, false);
            holder = new PlayGameShapesGridAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.imageViewShape.setImageResource(orderList.get(position).getRscId());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imageViewShape)
        ImageView imageViewShape;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}