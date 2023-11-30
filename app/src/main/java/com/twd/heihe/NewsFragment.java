package com.twd.heihe;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twd.heihe.adapter.NewsAdapter;
import com.twd.heihe.bean.NewsItemBeans;

import java.util.ArrayList;
import java.util.List;
public class NewsFragment extends Fragment {
    private Context context ;
    private ListView mNewsList;
    private List<NewsItemBeans> mNewsListData;
    private NewsAdapter mNewsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        mNewsList = (ListView) view.findViewById(R.id.news_list);
        //初始化数据
        mNewsListData = new ArrayList<>();
        NewsItemBeans appleNews = new NewsItemBeans("我是苹果大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.apple);
        NewsItemBeans bananaNews = new NewsItemBeans("我是香蕉大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.banana);
        NewsItemBeans cherryNews = new NewsItemBeans("我是樱桃大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.cherry);
        NewsItemBeans grapeNews = new NewsItemBeans("我是葡萄大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.grape);
        NewsItemBeans mangoNews = new NewsItemBeans("我是芒果大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.mango);
        NewsItemBeans appleNews2 = new NewsItemBeans("我是苹果大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.apple);
        NewsItemBeans bananaNews2 = new NewsItemBeans("我是香蕉大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.banana);
        NewsItemBeans cherryNews2 = new NewsItemBeans("我是樱桃大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.cherry);
        NewsItemBeans grapeNews2 = new NewsItemBeans("我是葡萄大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.grape);
        NewsItemBeans mangoNews2 = new NewsItemBeans("我是芒果大王","这里是内容fahsdlfkahsdjkflhakjshfakjhslkfjhalkjsdhflkajsdhfjlaksdhfljkahlsjkdfhla",R.drawable.mango);
        mNewsListData.add(appleNews);
        mNewsListData.add(bananaNews);
        mNewsListData.add(cherryNews);
        mNewsListData.add(grapeNews);
        mNewsListData.add(mangoNews);
        mNewsListData.add(appleNews2);
        mNewsListData.add(bananaNews2);
        mNewsListData.add(cherryNews2);
        mNewsListData.add(grapeNews2);
        mNewsListData.add(mangoNews2);
        //创建适配器
        mNewsAdapter = new NewsAdapter(context,mNewsListData);
        Log.i("yangxin", "onCreateView: 重新配置list");
        //设置适配器
        mNewsList.setAdapter(mNewsAdapter);
        return view;
    }
}