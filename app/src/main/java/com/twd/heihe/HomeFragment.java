package com.twd.heihe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    FragmentTransaction transaction;

    private NewsFragment newsFragment;
    private RecommendFragment recommendFragment;

    private Fragment currentFragment;//保存当前的子fragment

    TextView pageTitle_news;
    TextView pageTitle_recommend;

    private SharedPreferences homePageSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //初始化控件
        pageTitle_news = view.findViewById(R.id.home_title_news);
        pageTitle_recommend = view.findViewById(R.id.home_title_recommend);

        pageTitle_news.setOnClickListener(this::onClick);
        pageTitle_recommend.setOnClickListener(this::onClick);

        // 检查 savedInstanceState 是否为 null，如果是第一次打开则加载 NewsFragment
        if (savedInstanceState == null){
            newsFragment = new NewsFragment();
            recommendFragment = new RecommendFragment();
            currentFragment = newsFragment;

            getChildFragmentManager().beginTransaction()
                    .add(R.id.home_container, newsFragment)
                    .add(R.id.home_container, recommendFragment)
                    .hide(recommendFragment)
                    .commit();
        }else {
            newsFragment = (NewsFragment) getChildFragmentManager().findFragmentByTag("newsFragment");
            recommendFragment = (RecommendFragment) getChildFragmentManager().findFragmentByTag("recommendFragment");
            currentFragment = getChildFragmentManager().findFragmentById(R.id.home_container);
        }

        homePageSharedPreferences = getContext().getSharedPreferences("homePage",Context.MODE_PRIVATE);
        String pageis = homePageSharedPreferences.getString("pageis","");
        transaction = getChildFragmentManager().beginTransaction();
        if (pageis.equals("news")){
            transaction.show(newsFragment).hide(recommendFragment).addToBackStack(null).commit();
            selectedNews();
        } else if (pageis.equals("recommend")) {
            transaction.show(recommendFragment).hide(newsFragment).addToBackStack(null).commit();
            selectedRecommend();
        } else {
            transaction.show(newsFragment).hide(recommendFragment).addToBackStack(null).commit();
            selectedNews();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        transaction = getChildFragmentManager().beginTransaction();
        homePageSharedPreferences = getContext().getSharedPreferences("homePage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = homePageSharedPreferences.edit();
        if (v.getId() == R.id.home_title_news){
            transaction.show(newsFragment).hide(recommendFragment).addToBackStack(null).commit();
            selectedNews();
            currentFragment = newsFragment;
            editor.putString("pageis","news");
            editor.apply();
        } else if (v.getId() == R.id.home_title_recommend) {
            transaction.show(recommendFragment).hide(newsFragment).addToBackStack(null).commit();
            selectedRecommend();
            currentFragment = recommendFragment;
            editor.putString("pageis","recommend");
            editor.apply();
        }


    }

    private void selectedNews(){
        pageTitle_news.setSelected(true);
        pageTitle_news.setTextSize(18);
        pageTitle_recommend.setSelected(false);
        pageTitle_recommend.setTextSize(14);
    }

    private void selectedRecommend(){
        pageTitle_news.setSelected(false);
        pageTitle_news.setTextSize(14);
        pageTitle_recommend.setSelected(true);
        pageTitle_recommend.setTextSize(18);
    }
}