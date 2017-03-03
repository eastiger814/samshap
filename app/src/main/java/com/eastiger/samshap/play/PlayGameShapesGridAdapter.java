package com.eastiger.samshap.play;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.eastiger.samshap.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayGameShapesGridAdapter extends BaseAdapter {

    private Context context;
    private PlayGamePresenter presenter;

    public PlayGameShapesGridAdapter(Context context, PlayGamePresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public int getCount() {
        return presenter.getShapeList().size();
    }

    @Override
    public Object getItem(int position) {
        return presenter.getShapeList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.grid_item_play_game, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.imageViewShape.setImageResource(presenter.getShapeList().get(position).getRscId());
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