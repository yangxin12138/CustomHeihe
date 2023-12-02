package com.twd.heihe.notification;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twd.heihe.R;
import com.twd.heihe.adapter.LikeAdapter;
import com.twd.heihe.bean.LikeItemBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LikeFragment extends Fragment {
    private Context context;

    private RecyclerView mLikeRecyclerView;
    private List<LikeItemBean> mLikeListData;
    private LikeAdapter likeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like,container,false);
        mLikeRecyclerView = (RecyclerView) view.findViewById(R.id.likeRecycler);
        mLikeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        //获取当前时间
        Date currentDate = new Date();
        //定义时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //将日期转化为字符串
        String dateString = dateFormat.format(currentDate);
        //初始化数据
        mLikeListData = new ArrayList<>();
        LikeItemBean aLikeBean = new LikeItemBean(R.drawable.a,
                "不爱吃饭的蔷谙",ActionEnum.LIKE_YOUR_COMMENT,
                "夹子音太难受了",dateString);
        LikeItemBean bLikeBean = new LikeItemBean(R.drawable.b,
                "星海围蝴蝶",ActionEnum.LIKE_YOUR_COMMENT,
                "夹子音太难受了",dateString);
        LikeItemBean cLikeBean = new LikeItemBean(R.drawable.c,
                "iii-ISLAND",ActionEnum.LIKE_YOUR_COMMENT,
                "回复@Bettie_yyy: 杨花大桥？",dateString);
        LikeItemBean dLikeBean = new LikeItemBean(R.drawable.d,
                "奋斗的蜜缇",ActionEnum.COLLECT_YOUR_ALBUM,
                "[民谣]",dateString);
        LikeItemBean eLikeBean = new LikeItemBean(R.drawable.e,
                "奋斗的蜜提",ActionEnum.COLLECT_YOUR_ALBUM,
                "你赠送的黑胶会员7天",dateString);
        LikeItemBean fLikeBean = new LikeItemBean(R.drawable.f,
                "你丫儿的a",ActionEnum.LIKE_YOUR_VLOG,
                "[迎新晚会的宣美]",dateString);
        mLikeListData.add(aLikeBean);
        mLikeListData.add(bLikeBean);
        mLikeListData.add(cLikeBean);
        mLikeListData.add(dLikeBean);
        mLikeListData.add(eLikeBean);
        mLikeListData.add(fLikeBean);
        //创建适配器
        likeAdapter = new LikeAdapter(mLikeListData);
        //设置适配器
        mLikeRecyclerView.setAdapter(likeAdapter);
        return view;
    }
}