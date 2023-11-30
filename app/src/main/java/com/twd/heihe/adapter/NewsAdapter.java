package com.twd.heihe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.twd.heihe.R;
import com.twd.heihe.bean.NewsItemBeans;


import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsItemBeans> {
    private Context mContext;
    private List<NewsItemBeans> mNewsListData;


    public NewsAdapter(@NonNull Context context, List<NewsItemBeans> newsItemBeans) {
        super(context, 0,newsItemBeans);
        mContext = context;
        mNewsListData = newsItemBeans;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.mNewsItemTitle = (TextView) convertView.findViewById(R.id.news_item_title);
            viewHolder.mNewsItemContent = (TextView) convertView.findViewById(R.id.news_item_content);
            viewHolder.mNewsItemPic = (ImageView) convertView.findViewById(R.id.news_item_pic);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NewsItemBeans news =getItem(position);
        viewHolder.mNewsItemTitle.setText(news.getNews_title());
        viewHolder.mNewsItemContent.setText(news.getNews_content());
        viewHolder.mNewsItemPic.setImageResource(news.getNews_imageId());

        return convertView;
    }

    private static class ViewHolder {
        TextView mNewsItemTitle;
        TextView mNewsItemContent;
        ImageView mNewsItemPic;
    }
}
