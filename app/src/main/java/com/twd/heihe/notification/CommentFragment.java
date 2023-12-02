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
import com.twd.heihe.adapter.CommentAdapter;
import com.twd.heihe.bean.CommentItemBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentFragment extends Fragment {
    private Context context;
    private RecyclerView mCommentRecyclerView;
    private List<CommentItemBean> mCommentListData;
    private CommentAdapter commentAdapter;
    String myContent = "我的评论: 夹子音太难受了";
    String replyMe = "回复我:";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_comment,container,false);
       mCommentRecyclerView = (RecyclerView) view.findViewById(R.id.commentRecycler);
       mCommentRecyclerView.setLayoutManager(new LinearLayoutManager(context));
       //获取当前事件
        Date currentDate = new Date();
        //定义时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //将日期转化喂字符串
        String dateString = dateFormat.format(currentDate);
        //初始化数据
        mCommentListData = new ArrayList<>();
        CommentItemBean aCommentBean = new CommentItemBean(R.drawable.a,
                "A馨怀中猫",replyMe+"你是不是对《夹子》有什么误解",
                myContent,dateString);
        CommentItemBean bCommentBean = new CommentItemBean(R.drawable.b,
                "鲨鱼宝宝古拉",replyMe+"夹子是发不出高音的",
                myContent,dateString);
        CommentItemBean cCommentBean = new CommentItemBean(R.drawable.c,
                "怡少ooo",replyMe+"你没事吧你没事吧你没事吧",
                myContent,dateString);
        CommentItemBean dCommentBean = new CommentItemBean(R.drawable.d,
                "小瓒快跑",replyMe+"你没事吧，她18 19年就是这个声音，说话也是这个声音，怎么夹子这个词出来就你会用?",
                myContent,dateString);
        CommentItemBean eCommentBean = new CommentItemBean(R.drawable.e,
                "告白八月",replyMe+"给你一拳 我看你发不发得出夹子音",
                myContent,dateString);
        mCommentListData.add(aCommentBean);
        mCommentListData.add(bCommentBean);
        mCommentListData.add(cCommentBean);
        mCommentListData.add(dCommentBean);
        mCommentListData.add(eCommentBean);

        //创建适配器
        commentAdapter = new CommentAdapter(mCommentListData);
        //设置适配器
        mCommentRecyclerView.setAdapter(commentAdapter);
        return view;
    }
}