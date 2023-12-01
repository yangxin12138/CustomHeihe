package com.twd.heihe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twd.heihe.R;
import com.twd.heihe.bean.InformationItemBean;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    private List<InformationItemBean> informationItemBeans;
    public InformationAdapter(List<InformationItemBean> informationItemBeans){
        this.informationItemBeans = informationItemBeans;
    }
    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_information,parent,false);
        return new InformationViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return informationItemBeans.size();
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
        InformationItemBean itemBean = informationItemBeans.get(position);
        holder.bind(itemBean);
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder{
        private TextView contentText;
        private TextView authorText;
        private TextView timeText;
        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);
            contentText = itemView.findViewById(R.id.information_content_txt);
            authorText = itemView.findViewById(R.id.information_author_txt);
            timeText = itemView.findViewById(R.id.information_time_txt);
        }

        public void bind(InformationItemBean itemBean){
            contentText.setText(itemBean.getInformation_content());
            authorText.setText(itemBean.getInformation_author());
            timeText.setText(itemBean.getInformation_time());
        }
    }
}
