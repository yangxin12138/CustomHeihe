package com.twd.heihe;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twd.heihe.adapter.RecommendAdapter;
import com.twd.heihe.bean.RecommendItemBeans;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {

    private Context context;

    private RecyclerView mRecommendRecyclerView;

    private List<RecommendItemBeans> mRecommendListData;
    private RecommendAdapter mRecommendAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend,container,false);
        mRecommendRecyclerView = (RecyclerView) view.findViewById(R.id.recommend_recycler);
        mRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //初始化数据
        mRecommendListData = new ArrayList<>();
        RecommendItemBeans aRecommend = new RecommendItemBeans("春江潮水连海平，海上明月共潮生。","春天的江潮水势浩荡，与大海连成一片，一轮明月从海上升起，好像与潮水一起涌出来"
                        ,R.drawable.a,R.drawable.b,R.drawable.c);
        RecommendItemBeans bRecommend = new RecommendItemBeans("滟滟随波千万里，何处春江无月明！","月光照耀着春江，随着波浪闪耀千万里，所有地方的春江都有明亮的月光！"
                        ,R.drawable.d,R.drawable.e,R.drawable.f);
        RecommendItemBeans cRecommend = new RecommendItemBeans("江流宛转绕芳甸，月照花林皆似霰；","江水曲曲折折地绕着花草丛生的原野流淌，月光照射着开遍鲜花的树林好像细密的雪珠在闪烁。"
                        ,R.drawable.g,R.drawable.h,R.drawable.j);
        RecommendItemBeans dRecommend = new RecommendItemBeans("空里流霜不觉飞，汀上白沙看不见。","月色如霜，所以霜飞无从觉察，洲上的白沙和月色融合在一起，看不分明。"
                        ,R.drawable.k,R.drawable.l,R.drawable.m);
        RecommendItemBeans eRecommend = new RecommendItemBeans("江天一色无纤尘，皎皎空中孤月轮。","江水、天空成一色，没有一点微小灰尘，明亮的天空中只有一轮孤月高悬空中。"
                        ,R.drawable.n,R.drawable.v,R.drawable.a);

        mRecommendListData.add(aRecommend);
        mRecommendListData.add(bRecommend);
        mRecommendListData.add(cRecommend);
        mRecommendListData.add(dRecommend);
        mRecommendListData.add(eRecommend);

        //创建适配器
        mRecommendAdapter = new RecommendAdapter(mRecommendListData,true);
        //设置适配器
        mRecommendRecyclerView.setAdapter(mRecommendAdapter);
        return view;
    }
}