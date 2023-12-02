package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twd.heihe.R;
import com.twd.heihe.bean.LikeItemBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.LikeViewHolder> {

    private List<LikeItemBean> likeItemBeans;

    public LikeAdapter(List<LikeItemBean> likeItemBeans){
        this.likeItemBeans = likeItemBeans;
    }


    @NonNull
    @Override
    public LikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_like,parent,false);
        return new LikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeViewHolder holder, int position) {
        LikeItemBean likeItemBean = likeItemBeans.get(position);
        holder.bind(likeItemBean);
    }

    @Override
    public int getItemCount() {
        return likeItemBeans.size();
    }

    public class LikeViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView avatar;
        private TextView name;
        private TextView action;
        private TextView object;
        private TextView time;

        public LikeViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.like_avatar);
            name = itemView.findViewById(R.id.like_name);
            action = itemView.findViewById(R.id.like_action);
            object = itemView.findViewById(R.id.like_object);
            time = itemView.findViewById(R.id.like_time);
        }

        public void bind(LikeItemBean itemBean){
            avatar.setImageResource(itemBean.getLike_avatar());
            name.setText(itemBean.getLike_name());
            action.setText(itemBean.getLike_action());
            object.setText(itemBean.getLike_object());
            time.setText(itemBean.getLike_time());
        }
    }
}
