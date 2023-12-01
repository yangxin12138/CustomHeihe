package com.twd.heihe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twd.heihe.bean.InformationItemBean;
import com.twd.heihe.notification.InformationFragment;

public class NotificationFragment extends Fragment implements View.OnClickListener{


    FragmentTransaction transaction;

    private InformationFragment informationFragment;
    private Fragment currentFragment;//保存当前的子fragment

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        informationFragment = new InformationFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.notification_container,informationFragment)
                .commit();
        return view;
    }

    @Override
    public void onClick(View v) {

    }


    /*View view = inflater.inflate(R.layout.fragment_notification,container,false);
    informationFragment = new InformationFragment();
    getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,informationFragment);
        return view;*/
}