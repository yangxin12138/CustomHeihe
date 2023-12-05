package com.twd.heihe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;

import com.twd.heihe.adapter.UserCollectAlbumAdapter;
import com.twd.heihe.adapter.UserMyAlbumAdapter;
import com.twd.heihe.adapter.UserNameAdapter;
import com.twd.heihe.bean.UserCollectAlbumBeans;
import com.twd.heihe.bean.UserMenuBeans;
import com.twd.heihe.bean.UserMyAlbumBeans;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserFragment extends Fragment implements View.OnClickListener {

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
    private DrawerLayout drawerLayout;
    private ImageView user_menu;
    private TypedArray typedArray;
    private Switch themeSwitch;

    SharedPreferences themeSharedPreferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = getActivity();
        assert context != null;
        typedArray = context.obtainStyledAttributes(new int[]{
                R.attr.user_local_music,
                R.attr.user_cloud_music,
                R.attr.user_purchased_music,
                R.attr.user_played_music,
                R.attr.user_collect_music,
                R.attr.user_podcast_music,
                R.attr.user_radio_music,
                R.attr.user_sleep_music
        });
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user,container,false);
        context = getActivity();
        drawerLayout = view.findViewById(R.id.drawerLayout);
        user_menu = view.findViewById(R.id.user_menu);
        gridView = view.findViewById(R.id.gridview);
        myAlbumRecycler = view.findViewById(R.id.user_myalbum_list);
        myAlbumRecycler.setLayoutManager(new LinearLayoutManager(context));
        collectAlbumRecycler = view.findViewById(R.id.user_collectalbum_list);
        collectAlbumRecycler.setLayoutManager(new LinearLayoutManager(context));
        themeSwitch = view.findViewById(R.id.theme_switch);
        themeSwitch.setChecked(isChecked());
        themeSharedPreferences = getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor themeEditor= themeSharedPreferences.edit();
                if (isChecked){
                    //切换到深色主题
                    context.setTheme(R.style.AppTheme_Night);
                    themeEditor.putString("themeis","night");
                    themeEditor.putBoolean("switch",true);
                    themeEditor.apply();
                }else {
                    //切换回浅色主题
                    context.setTheme(R.style.AppTheme_Light);
                    themeEditor.putString("themeis","light");
                    themeEditor.putBoolean("switch",false);
                    themeEditor.apply();
                }
                restartActivity();
            }
        });
        onResume();

        user_menu.setOnClickListener(this::onClick);
        return view;
    }

    private boolean isChecked(){
        themeSharedPreferences = getActivity().getSharedPreferences("theme",Context.MODE_PRIVATE);
        return themeSharedPreferences.getBoolean("switch",false);
    }

    @Override
    @SuppressLint("ResourceType")
    public void onResume() {
        super.onResume();
        //menu初始化数据
        userMenuBeansList = new ArrayList<>();
        UserMenuBeans menuBeansLocal = new UserMenuBeans(typedArray.getDrawable(0),"本地音乐");
        UserMenuBeans menuBeansCloud = new UserMenuBeans(typedArray.getDrawable(1),"云盘");
        UserMenuBeans menuBeansPurchased = new UserMenuBeans(typedArray.getDrawable(2),"已购");
        UserMenuBeans menuBeansPlayed = new UserMenuBeans(typedArray.getDrawable(3),"最近播放");
        UserMenuBeans menuBeansCollected = new UserMenuBeans(typedArray.getDrawable(4),"收藏和赞");
        UserMenuBeans menuBeansPodcast = new UserMenuBeans(typedArray.getDrawable(5),"播客");
        UserMenuBeans menuBeansRadio = new UserMenuBeans(typedArray.getDrawable(6),"电台");
        UserMenuBeans menuBeansSleep = new UserMenuBeans(typedArray.getDrawable(7),"助眠放松");
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

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.END);
    }

    private void restartActivity(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        Intent restartIntent = packageManager.getLaunchIntentForPackage(packageName);
        if (restartIntent != null) {
            context.startActivity(restartIntent);
        }
    }
}