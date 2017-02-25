package com.eastiger.samshap.play;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eastiger.samshap.R;

public class PlayGameGridAdapter extends BaseAdapter {

    private Context context;
    private final String[] gridValues;

    //Constructor to initialize values
    public PlayGameGridAdapter(Context context, String[] gridValues) {
        this.context = context;
        this.gridValues = gridValues;
    }

    @Override
    public int getCount() {
        // Number of times getView method call depends upon gridValues.length
        return gridValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Number of times getView method call depends upon gridValues.length
    public View getView(int position, View convertView, ViewGroup parent) {
        // LayoutInflator to call external grid_item_game_game.xml file
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null) {
//            gridView = new View(context);
            // get layout from grid_item_play_game.xmle.xml ( Defined Below )
            gridView = inflater.inflate(R.layout.grid_item_play_game, null);
            // set value into textview
            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
            textView.setText(gridValues[position]);
            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);
            String arrLabel = gridValues[position];
//            if (arrLabel.equals("Windows")) {
//                imageView.setImageResource(R.drawable.windows_logo);
//            } else if (arrLabel.equals("iOS")) {
//                imageView.setImageResource(R.drawable.ios_logo);
//            } else if (arrLabel.equals("Blackberry")) {
//                imageView.setImageResource(R.drawable.blackberry_logo);
//            } else {
//                imageView.setImageResource(R.drawable.android_logo);
//            }
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}