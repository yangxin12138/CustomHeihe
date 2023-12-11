package com.twd.heihe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.twd.heihe.R;
import com.twd.heihe.bean.GameItemBeans;

import java.util.List;

public class FavoriteAdapter extends BaseAdapter {
    private Context context;

    private List<GameItemBeans> gameItemBeansList;

    public FavoriteAdapter(Context context, List<GameItemBeans> gameItemBeansList) {
        this.context = context;
        this.gameItemBeansList = gameItemBeansList;
    }

    @Override
    public int getCount() {
        return gameItemBeansList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameItemBeansList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_game_gird,null);
            viewHolder = new ViewHolder();
            viewHolder.game_image = convertView.findViewById(R.id.game_image);
            viewHolder.game_name = convertView.findViewById(R.id.game_name);
            viewHolder.game_price = convertView.findViewById(R.id.game_price);
            viewHolder.game_origin_price = convertView.findViewById(R.id.origin_price);
            viewHolder.game_percentage = convertView.findViewById(R.id.percentage);
            viewHolder.game_historical_low = convertView.findViewById(R.id.historical_low);
            viewHolder.game_description = convertView.findViewById(R.id.description);
            viewHolder.game_label = convertView.findViewById(R.id.label);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GameItemBeans gameItemBean = gameItemBeansList.get(position);
        viewHolder.game_image.setImageResource(gameItemBean.getGame_image());
        viewHolder.game_name.setText(gameItemBean.getGame_name());
        viewHolder.game_price.setText(gameItemBean.getPrice());
        viewHolder.game_origin_price.setText(gameItemBean.getOriginal_price());
        viewHolder.game_percentage.setText(gameItemBean.getPercentage());
        viewHolder.game_description.setText(gameItemBean.getDescription());
        viewHolder.game_label.setText(gameItemBean.getLabel());

        if (gameItemBean.isSale()){
            viewHolder.game_origin_price.setVisibility(View.VISIBLE);
            viewHolder.game_percentage.setVisibility(View.VISIBLE);
            if (gameItemBean.isHistorical_low()) {
                viewHolder.game_historical_low.setVisibility(View.VISIBLE);
            }else {
                viewHolder.game_historical_low.setVisibility(View.GONE);
            }
        }else {
            viewHolder.game_origin_price.setVisibility(View.GONE);
            viewHolder.game_percentage.setVisibility(View.GONE);
            viewHolder.game_historical_low.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class ViewHolder{
        private ImageView game_image;
        private TextView game_name;
        private TextView game_price;
        private TextView game_origin_price;
        private TextView game_percentage;
        private TextView game_historical_low;
        private TextView game_description;
        private TextView game_label;
    }
}
