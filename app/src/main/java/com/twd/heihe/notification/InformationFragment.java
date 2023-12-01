package com.twd.heihe.notification;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twd.heihe.R;
import com.twd.heihe.adapter.InformationAdapter;
import com.twd.heihe.bean.InformationItemBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InformationFragment extends Fragment {
    private Context context;
    private RecyclerView mInformationRecyclerView;

    private List<InformationItemBean> mInformationListData;

    private InformationAdapter mInformationAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information,container,false);
        mInformationRecyclerView = (RecyclerView) view.findViewById(R.id.information_recycler);
        mInformationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //获取当前时间
        Date currentDate = new Date();
        //定义时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //将日期转化为字符串
        String dateString = dateFormat.format(currentDate);
        //初始化数据
        mInformationListData = new ArrayList<>();
        InformationItemBean aInformation = new InformationItemBean("10月份的会员赠礼已送达，请查看。",
                "黑椒会员官方",dateString);
        InformationItemBean bInformation = new InformationItemBean("既然都已经说了，下班后玩电脑感受不到欢愉，只是在打发时间，那游戏本事就只是形式，没必要把时间投入到没乐趣的事情上。",
                "知乎日报",dateString);
        InformationItemBean cInformation = new InformationItemBean("几千块钱一个月的工资，要抽出500来上网，上网也确实是一种消遣的方式，但相比之下，成本还是有点高了，而且没有乐趣，起不到什么有效的作用。",
                "Steam情报局",dateString);
        mInformationListData.add(aInformation);
        mInformationListData.add(bInformation);
        mInformationListData.add(cInformation);

        //创建适配器
        mInformationAdapter = new InformationAdapter(mInformationListData);
        Log.i("yangxin", "onCreateView: notification创建adaper");
        //设置适配器
        mInformationRecyclerView.setAdapter(mInformationAdapter);
        return view;
    }
}