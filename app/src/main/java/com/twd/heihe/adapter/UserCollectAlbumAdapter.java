package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqm.roundview.RoundImageView;
import com.twd.heihe.R;
import com.twd.heihe.bean.UserCollectAlbumBeans;

import java.util.List;

public class UserCollectAlbumAdapter extends RecyclerView.Adapter<UserCollectAlbumAdapter.CollectAlbumViewHolder> {
    List<UserCollectAlbumBeans> userCollectAlbumBeansList;

    public UserCollectAlbumAdapter(List<UserCollectAlbumBeans> userCollectAlbumBeansList) {
      this.userCollectAlbumBeansList = userCollectAlbumBeansList;
    }

    @NonNull
    @Override
    public CollectAlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_collcetalbum_list,parent,false);
        return new CollectAlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectAlbumViewHolder holder, int position) {
        UserCollectAlbumBeans collectAlbumBean = userCollectAlbumBeansList.get(position);
        holder.bind(collectAlbumBean);
    }

    @Override
    public int getItemCount() {
        return userCollectAlbumBeansList.size();
    }

    public class CollectAlbumViewHolder extends RecyclerView.ViewHolder{
        private RoundImageView album_image;
        private TextView album_name;
        private TextView album_subtitle;
        public CollectAlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            album_image = itemView.findViewById(R.id.album_image);
            album_name = itemView.findViewById(R.id.album_name);
            album_subtitle = itemView.findViewById(R.id.album_subtitle);
        }
        public void bind(UserCollectAlbumBeans itemBeans){
            album_image.setImageResource(itemBeans.getAlbum_image());
            album_name.setText(itemBeans.getAlbum_name());
            album_subtitle.setText(itemBeans.getSubtitle());
        }
    }
}
