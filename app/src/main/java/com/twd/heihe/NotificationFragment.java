package com.twd.heihe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.twd.heihe.bean.InformationItemBean;
import com.twd.heihe.notification.CommentFragment;
import com.twd.heihe.notification.InformationFragment;
import com.twd.heihe.notification.LikeFragment;

public class NotificationFragment extends Fragment implements View.OnClickListener{


    FragmentTransaction transaction;

    private InformationFragment informationFragment;
    private CommentFragment commentFragment;
    private LikeFragment likeFragment;
    private Fragment currentFragment;//保存当前的子fragment

    ImageView noti_image_information;
    ImageView noti_image_comment;
    ImageView noti_image_like;

    private SharedPreferences notificationPageSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        //初始化控件
        noti_image_information = view.findViewById(R.id.noti_icon_information);
        noti_image_comment = view.findViewById(R.id.noti_icon_comment);
        noti_image_like = view.findViewById(R.id.noti_icon_like);

        noti_image_information.setOnClickListener(this::onClick);
        noti_image_comment.setOnClickListener(this::onClick);
        noti_image_like.setOnClickListener(this::onClick);

        //检查savedInstanceState是否是null
        if (savedInstanceState == null){
            informationFragment = new InformationFragment();
            commentFragment = new CommentFragment();
            likeFragment = new LikeFragment();

            getChildFragmentManager().beginTransaction()
                    .add(R.id.notification_container,informationFragment)
                    .add(R.id.notification_container,commentFragment)
                    .add(R.id.notification_container,likeFragment)
                    .hide(commentFragment).hide(likeFragment)
                    .commit();
        }else {
            informationFragment = (InformationFragment) getChildFragmentManager().findFragmentByTag("informationFragment");
            commentFragment = (CommentFragment) getChildFragmentManager().findFragmentByTag("commentFragment");
            likeFragment = (LikeFragment) getChildFragmentManager().findFragmentByTag("likeFragment");
            currentFragment = getChildFragmentManager().findFragmentById(R.id.notification_container);
        }

        notificationPageSharedPreferences = getContext().getSharedPreferences("notificationPage", Context.MODE_PRIVATE);
        String pageis = notificationPageSharedPreferences.getString("pageis","");
        transaction = getChildFragmentManager().beginTransaction();
        if (pageis.equals("information")){
            transaction.show(informationFragment).hide(commentFragment).hide(likeFragment).addToBackStack(null).commit();
            //TODO:点击切换时改变图标
            selectedInformation();
        } else if (pageis.equals("comment")) {
            transaction.show(commentFragment).hide(informationFragment).hide(likeFragment).addToBackStack(null).commit();
            selectedComment();
        } else if (pageis.equals("like")) {
            transaction.show(likeFragment).hide(informationFragment).hide(commentFragment).addToBackStack(null).commit();
            selectedLike();
        }else {
            transaction.show(informationFragment).hide(commentFragment).hide(likeFragment).addToBackStack(null).commit();
            selectedInformation();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        transaction = getChildFragmentManager().beginTransaction();
        notificationPageSharedPreferences = getContext().getSharedPreferences("notificationPage",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = notificationPageSharedPreferences.edit();
        if (v.getId() == R.id.noti_icon_information){
            transaction.show(informationFragment).hide(commentFragment).hide(likeFragment).addToBackStack(null).commit();
            currentFragment = informationFragment;
            selectedInformation();
            editor.putString("pageis","information");
            editor.apply();
        } else if (v.getId() == R.id.noti_icon_comment) {
            transaction.show(commentFragment).hide(informationFragment).hide(likeFragment).addToBackStack(null).commit();
            currentFragment = commentFragment;
            selectedComment();
            editor.putString("pageis","comment");
            editor.apply();
        }else {
            transaction.show(likeFragment).hide(informationFragment).hide(commentFragment).addToBackStack(null).commit();
            currentFragment = likeFragment;
            selectedLike();
            editor.putString("pageis","like");
            editor.apply();
        }
    }

    private void selectedInformation(){
        noti_image_information.setSelected(true);
        noti_image_comment.setSelected(false);
        noti_image_like.setSelected(false);
        noti_image_information.setImageResource(R.drawable.information);
        noti_image_comment.setImageResource(R.drawable.comment_line);
        noti_image_like.setImageResource(R.drawable.like_line);
    }

    private void selectedComment(){
        noti_image_information.setSelected(false);
        noti_image_comment.setSelected(true);
        noti_image_like.setSelected(false);
        noti_image_information.setImageResource(R.drawable.information_line);
        noti_image_comment.setImageResource(R.drawable.comment);
        noti_image_like.setImageResource(R.drawable.like_line);
    }

    private void selectedLike(){
        noti_image_information.setSelected(false);
        noti_image_comment.setSelected(false);
        noti_image_like.setSelected(true);
        noti_image_information.setImageResource(R.drawable.information_line);
        noti_image_comment.setImageResource(R.drawable.comment_line);
        noti_image_like.setImageResource(R.drawable.like);
    }
}