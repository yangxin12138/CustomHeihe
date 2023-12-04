package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqm.roundview.RoundImageView;
import com.twd.heihe.R;
import com.twd.heihe.bean.UserMyAlbumBeans;

import java.util.List;

public class UserMyAlbumAdapter extends RecyclerView.Adapter<UserMyAlbumAdapter.MyAlbumViewHolder> {

    private List<UserMyAlbumBeans> userMyAlbumBeans;

    public UserMyAlbumAdapter(List<UserMyAlbumBeans> userMyAlbumBeans) {
        this.userMyAlbumBeans = userMyAlbumBeans;
    }


    @NonNull
    @Override
    public MyAlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_myalbum_list,parent,false);
        return new MyAlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAlbumViewHolder holder, int position) {
        UserMyAlbumBeans userMyAlbumBean = userMyAlbumBeans.get(position);
        holder.bind(userMyAlbumBean);
    }


    @Override
    public int getItemCount() {
        return userMyAlbumBeans.size();
    }

    public class MyAlbumViewHolder extends RecyclerView.ViewHolder{
        private RoundImageView album_image;
        private TextView album_name;
        private TextView album_songs;


        public MyAlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            album_image = itemView.findViewById(R.id.album_image);
            album_name = itemView.findViewById(R.id.album_name);
            album_songs = itemView.findViewById(R.id.album_songs);
        }

        private void bind(UserMyAlbumBeans itemBeans){
            album_image.setImageResource(itemBeans.getAlbum_image());
            album_name.setText(itemBeans.getAlbum_name());
            album_songs.setText(itemBeans.getSongs());
        }
    }
}
