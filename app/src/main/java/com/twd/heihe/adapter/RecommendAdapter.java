package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.twd.heihe.R;
import com.twd.heihe.bean.RecommendItemBeans;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_BANNER = 0;
    private static final int TYPE_ITEM = 1;
    private List<RecommendItemBeans> recommendList;
    private boolean showBanner;
    BannerAdapter bannerAdapter;
    public RecommendAdapter(List<RecommendItemBeans> recommendList,boolean showBanner){
        this.recommendList = recommendList;
        this.showBanner = showBanner;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_BANNER){
            View bannerView = inflater.inflate(R.layout.item_banner,parent,false);
            return new BannerViewHolder(bannerView);
        }else {
            View view = inflater.inflate(R.layout.item_recommend,parent,false);
            return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ViewHolder itemHolder = (ViewHolder) holder;
            RecommendItemBeans itemBeans = recommendList.get(getItemPosition(position));
            itemHolder.bind(itemBeans);
        }
    }



    @Override
    public int getItemCount() {
        return recommendList.size() + (showBanner ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (showBanner && position == 0 ){
            return TYPE_BANNER;
        }else {
            return TYPE_ITEM;
        }
    }

    private int getItemPosition(int position){
        return showBanner ? position -1 : position;
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{
        ImageView bannerImage;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            //初始化Banner视图
            ViewPager viewPager = itemView.findViewById(R.id.banner_image);
            List<Integer> imageList = new ArrayList<>();
            imageList.add(R.drawable.battle);
            imageList.add(R.drawable.caodong);
            imageList.add(R.drawable.a);
            bannerAdapter = new BannerAdapter(imageList);
            viewPager.setAdapter(bannerAdapter);
        }
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
