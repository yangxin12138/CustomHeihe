package com.twd.heihe;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.twd.heihe.adapter.FavoriteAdapter;
import com.twd.heihe.bean.GameItemBeans;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment implements View.OnClickListener {
    private GridView gameGridView;
    private List<GameItemBeans> gameItemBeansList;
    private Context context;

    private FavoriteAdapter favoriteAdapter;
    private CardView cardAll;//全部
    private CardView cardRpg;//角色扮演
    private CardView cardMMO;//多人在线
    private CardView cardIndie;//独立游戏
    private CardView cardFps;//射击游戏
    private CardView cardTactics;//策略游戏
    private List<GameItemBeans> allBeansList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        context = getActivity();
        cardAll = view.findViewById(R.id.favorite_card_all);  cardAll.setOnClickListener(this::onClick);
        cardRpg = view.findViewById(R.id.favorite_card_RPG);  cardRpg.setOnClickListener(this::onClick);
        cardMMO = view.findViewById(R.id.favorite_card_MMO);  cardMMO.setOnClickListener(this::onClick);
        cardIndie = view.findViewById(R.id.favorite_card_indie); cardIndie.setOnClickListener(this::onClick);
        cardFps = view.findViewById(R.id.favorite_card_FPS);  cardFps.setOnClickListener(this::onClick);
        cardTactics = view.findViewById(R.id.favorite_card_tactics);  cardTactics.setOnClickListener(this::onClick);
        gameGridView = view.findViewById(R.id.favorite_list);
        //初始化数据
        gameItemBeansList = new ArrayList<>(); allBeansList = new ArrayList<>();
        GameItemBeans item_r6 = new GameItemBeans(R.drawable.r6,"彩虹六号",
                36,88,true,false,4,
                "好友中热门","第一人称射击 | 玩家对战");
        GameItemBeans item_it_takes_two = new GameItemBeans(R.drawable.it_takes_two,"双人成行",
                60,198,true,true,3,
                "steam促销中","合作 | 分屏 | 多人");
        GameItemBeans item_horizontal = new GameItemBeans(R.drawable.horizontal,"地平线：零之曙光",
                87,345,true,true,1,
                "玩过相似","开放世界 | 角色扮演 | 女性主角");
        GameItemBeans item_frost_punk = new GameItemBeans(R.drawable.frostpunk,"冰气时代",
                22,108,true,true,5,
                "我的关注","模拟 | 策略 | 后末日 | 城市建造");
        GameItemBeans item_raft = new GameItemBeans(R.drawable.raft,"木筏",
                68,68,false,false,3,
                "好友中热门","冒险 | 独立 | 生存");
        GameItemBeans item_battlefield = new GameItemBeans(R.drawable.battle,"战地风云2042",
                248,248,false,false,2,
                "好友最近在玩","多人联网 | 射击 | 军事");

        gameItemBeansList.add(item_r6); allBeansList.add(item_r6);
        gameItemBeansList.add(item_battlefield); allBeansList.add(item_battlefield);
        gameItemBeansList.add(item_horizontal); allBeansList.add(item_horizontal);
        gameItemBeansList.add(item_raft); allBeansList.add(item_raft);
        gameItemBeansList.add(item_frost_punk); allBeansList.add(item_frost_punk);
        gameItemBeansList.add(item_it_takes_two); allBeansList.add(item_it_takes_two);

        favoriteAdapter = new FavoriteAdapter(context,gameItemBeansList);
        gameGridView.setAdapter(favoriteAdapter);
        return view;
    }


    private void updateGameGirdView(){
        FavoriteAdapter gameAdapter = new FavoriteAdapter(context,gameItemBeansList);
        gameGridView.setAdapter(gameAdapter);
    }


    @Override
    public void onClick(View v) {
        //清空gameItemBeansList
        gameItemBeansList.clear();
        if (v.getId() == R.id.favorite_card_all){
            //将所有的beans添加到gameItemsBeansList中
            gameItemBeansList.addAll(allBeansList);
        } else if (v.getId() == R.id.favorite_card_RPG) {
            //根据category的属性值过滤并添加符合条件的beans到gameItemsBeansList中
            for (GameItemBeans beans : allBeansList){
                if (beans.getCategory() == 1){
                    gameItemBeansList.add(beans);
                }
            }
        } else if (v.getId() == R.id.favorite_card_MMO) {
            for (GameItemBeans beans : allBeansList){
                if (beans.getCategory() == 2){
                    gameItemBeansList.add(beans);
                }
            }
        } else if (v.getId() == R.id.favorite_card_indie) {
            for (GameItemBeans beans : allBeansList){
                if (beans.getCategory() == 3){
                    gameItemBeansList.add(beans);
                }
            }
        } else if (v.getId() == R.id.favorite_card_FPS) {
            for (GameItemBeans beans : allBeansList){
                if (beans.getCategory() == 4){
                    gameItemBeansList.add(beans);
                }
            }
        } else if (v.getId() == R.id.favorite_card_tactics) {
            for (GameItemBeans beans : allBeansList){
                if (beans.getCategory() == 5){
                    gameItemBeansList.add(beans);
                }
            }
        }
        showLoading();
    }

    private void showLoading(){
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setMessage("加载中...");
        dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                // 更新显示
                updateGameGirdView();
            }
        }, 1000);
    }
}