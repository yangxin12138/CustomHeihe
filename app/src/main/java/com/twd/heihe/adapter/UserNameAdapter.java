package com.twd.heihe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.twd.heihe.R;
import com.twd.heihe.bean.UserMenuBeans;

import java.util.List;

public class UserNameAdapter extends BaseAdapter {

    private Context context;
    private List<UserMenuBeans> menuBeans;
    public UserNameAdapter(List<UserMenuBeans> menuBeans,Context context){
        this.context = context;
        this.menuBeans = menuBeans;
    }

    @Override
    public int getCount() {
        return menuBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return menuBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_user_grid,null);
            viewHolder = new ViewHolder();
            viewHolder.menu_image = convertView.findViewById(R.id.menu_icon);
            viewHolder.menu_name = convertView.findViewById(R.id.menu_name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        UserMenuBeans menuBean = menuBeans.get(position);
        viewHolder.menu_image.setImageResource(menuBean.getMenu_image());
        viewHolder.menu_name.setText(menuBean.getMenu_name());
        return convertView;
    }

    private class ViewHolder{
        private ImageView menu_image;
        private TextView menu_name;
    }
}
