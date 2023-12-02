package com.twd.heihe.adapter;

import android.text.PrecomputedText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twd.heihe.R;
import com.twd.heihe.bean.CommentItemBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private List<CommentItemBean> commentItemBeans;
    public CommentAdapter(List<CommentItemBean> commentItemBeans){
        this.commentItemBeans = commentItemBeans;
    }
    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_comment,parent,false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
            CommentItemBean commentItemBean = commentItemBeans.get(position);
            holder.bind(commentItemBean);
    }

    @Override
    public int getItemCount() {
        return commentItemBeans.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView userAvatar;
        private TextView userName;
        private TextView content;
        private TextView myContent;
        private TextView time;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.comment_user_avatar);
            userName = itemView.findViewById(R.id.comment_user_name);
            content = itemView.findViewById(R.id.comment_content);
            myContent = itemView.findViewById(R.id.comment_my_content);
            time = itemView.findViewById(R.id.comment_time);

            userAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("yangxin", "onClick: 点击头像了");
                }
            });
        }

        public void bind(CommentItemBean itemBean){
            userAvatar.setImageResource(itemBean.getComment_userAvatar());
            userName.setText(itemBean.getComment_userName());
            content.setText(itemBean.getComment_content());
            myContent.setText(itemBean.getComment_myContent());
            time.setText(itemBean.getComment_time());
        }
    }
}
