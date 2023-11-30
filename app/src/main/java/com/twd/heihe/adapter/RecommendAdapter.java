package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twd.heihe.R;
import com.twd.heihe.bean.RecommendItemBeans;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private List<RecommendItemBeans> recommendList;

    public RecommendAdapter(List<RecommendItemBeans> recommendList){
        this.recommendList = recommendList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText;
        private TextView contentText;
        private ImageView imageView1;
        private ImageView imageView2;
        private ImageView imageView3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.recommend_item_title);
            contentText = itemView.findViewById(R.id.recommend_item_content);
            imageView1 = itemView.findViewById(R.id.recommend_image1);
            imageView2 = itemView.findViewById(R.id.recommend_image2);
            imageView3 = itemView.findViewById(R.id.recommend_image3);
        }
        public void bind(RecommendItemBeans itemBeans){
            titleText.setText(itemBeans.getRecommend_title());
            contentText.setText(itemBeans.getRecommend_content());
            imageView1.setImageResource(itemBeans.getRecommend_image1());
            imageView2.setImageResource(itemBeans.getRecommend_image2());
            imageView3.setImageResource(itemBeans.getRecommend_image3());
        }
    }
}
