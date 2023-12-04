package com.twd.heihe;

import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.twd.heihe.adapter.UserCollectAlbumAdapter;
import com.twd.heihe.adapter.UserMyAlbumAdapter;
import com.twd.heihe.adapter.UserNameAdapter;
import com.twd.heihe.bean.UserCollectAlbumBeans;
import com.twd.heihe.bean.UserMenuBeans;
import com.twd.heihe.bean.UserMyAlbumBeans;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserFragment extends Fragment {

    private GridView gridView;
    private RecyclerView myAlbumRecycler;
    private RecyclerView collectAlbumRecycler;
    private List<UserMenuBeans> userMenuBeansList;
    private List<UserMyAlbumBeans> userMyAlbumBeansList;
    private List<UserCollectAlbumBeans> userCollectAlbumBeansList;
    private Context context;
    private UserNameAdapter userNameAdapter;
    private UserMyAlbumAdapter userMyAlbumAdapter;
    private UserCollectAlbumAdapter userCollectAlbumAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user,container,false);
        context = getActivity();
        gridView = view.findViewById(R.id.gridview);
        myAlbumRecycler = view.findViewById(R.id.user_myalbum_list);
        myAlbumRecycler.setLayoutManager(new LinearLayoutManager(context));
        collectAlbumRecycler = view.findViewById(R.id.user_collectalbum_list);
        collectAlbumRecycler.setLayoutManager(new LinearLayoutManager(context));
        onResume();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //menu初始化数据
        userMenuBeansList = new ArrayList<>();
        UserMenuBeans menuBeansLocal = new UserMenuBeans(R.drawable.local_music,"本地音乐");
        UserMenuBeans menuBeansCloud = new UserMenuBeans(R.drawable.cloud_music,"云盘");
        UserMenuBeans menuBeansPurchased = new UserMenuBeans(R.drawable.purchased_music,"已购");
        UserMenuBeans menuBeansPlayed = new UserMenuBeans(R.drawable.played_music,"最近播放");
        UserMenuBeans menuBeansCollected = new UserMenuBeans(R.drawable.collect_music,"收藏和赞");
        UserMenuBeans menuBeansPodcast = new UserMenuBeans(R.drawable.podcast_music,"播客");
        UserMenuBeans menuBeansRadio = new UserMenuBeans(R.drawable.radio_music,"电台");
        UserMenuBeans menuBeansSleep = new UserMenuBeans(R.drawable.sleep_music,"助眠放松");
        userMenuBeansList.add(menuBeansLocal);
        userMenuBeansList.add(menuBeansCloud);
        userMenuBeansList.add(menuBeansPurchased);
        userMenuBeansList.add(menuBeansPlayed);
        userMenuBeansList.add(menuBeansCollected);
        userMenuBeansList.add(menuBeansPodcast);
        userMenuBeansList.add(menuBeansRadio);
        userMenuBeansList.add(menuBeansSleep);


        //myalbum初始化数据
        userMyAlbumBeansList = new ArrayList<>();
        UserMyAlbumBeans myAlbumBeans1 = new UserMyAlbumBeans(R.drawable.myalbum1,"民谣",109);
        UserMyAlbumBeans myAlbumBeans2 = new UserMyAlbumBeans(R.drawable.myalbum2,"凯瑟喵",26);
        UserMyAlbumBeans myAlbumBeans3 = new UserMyAlbumBeans(R.drawable.myalbum3,"华语|古风《陌上人如玉，公子世无双》",68);
        UserMyAlbumBeans myAlbumBeans4 = new UserMyAlbumBeans(R.drawable.myalbum4,"霓虹",61);
        UserMyAlbumBeans myAlbumBeans5 = new UserMyAlbumBeans(R.drawable.myalbum5,"@Pink_4ever的十周年精选辑",17);
        userMyAlbumBeansList.add(myAlbumBeans1);
        userMyAlbumBeansList.add(myAlbumBeans2);
        userMyAlbumBeansList.add(myAlbumBeans3);
        userMyAlbumBeansList.add(myAlbumBeans4);
        userMyAlbumBeansList.add(myAlbumBeans5);

        //collectalbum初始化数据
        userCollectAlbumBeansList = new ArrayList<>();
        UserCollectAlbumBeans collect1 = new UserCollectAlbumBeans(R.drawable.collect1,"天气之子&你的名字&铃芽，新海诚音乐精选",30,"穿山甲有话说");
        UserCollectAlbumBeans collect2 = new UserCollectAlbumBeans(R.drawable.collect2,"经典老歌翻唱-->经典旋律",145,"硕硕的小朋友啊");
        UserCollectAlbumBeans collect3 = new UserCollectAlbumBeans(R.drawable.collect3,"[经典怀旧]70&80&90年代经典老歌",634,"想念送给晚风");
        UserCollectAlbumBeans collect4 = new UserCollectAlbumBeans(R.drawable.collect4,"抖音伤感歌曲//emo",313,"半颗番茄xi");
        userCollectAlbumBeansList.add(collect1);
        userCollectAlbumBeansList.add(collect2);
        userCollectAlbumBeansList.add(collect3);
        userCollectAlbumBeansList.add(collect4);

        newAdapter();
        setAdapter();
    }

    private void newAdapter(){
        userNameAdapter = new UserNameAdapter(userMenuBeansList,context);
        userMyAlbumAdapter = new UserMyAlbumAdapter(userMyAlbumBeansList);
        userCollectAlbumAdapter = new UserCollectAlbumAdapter(userCollectAlbumBeansList);
    }

    private void setAdapter(){
        gridView.setAdapter(userNameAdapter);
        myAlbumRecycler.setAdapter(userMyAlbumAdapter);
        collectAlbumRecycler.setAdapter(userCollectAlbumAdapter);
    }
}