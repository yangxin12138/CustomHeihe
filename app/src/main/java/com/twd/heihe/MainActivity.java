package com.twd.heihe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment currentFragment;
    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private FavoriteFragment favoriteFragment;
    private UserFragment userFragment;
    private SharedPreferences mainPageSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        if (savedInstanceState == null){
            homeFragment = new HomeFragment();
            notificationFragment = new NotificationFragment();
            favoriteFragment = new FavoriteFragment();
            userFragment = new UserFragment();
            currentFragment = homeFragment;
            transaction.add(R.id.fragment_container,homeFragment);
            transaction.add(R.id.fragment_container,notificationFragment);
            transaction.add(R.id.fragment_container,favoriteFragment);
            transaction.add(R.id.fragment_container,userFragment);
            transaction.hide(notificationFragment);
            transaction.hide(favoriteFragment);
            transaction.hide(userFragment);
            transaction.commit();
        }else {
            homeFragment = (HomeFragment) fragmentManager.findFragmentByTag("homeFragment");
            notificationFragment = (NotificationFragment) fragmentManager.findFragmentByTag("notificationFragment");
            favoriteFragment = (FavoriteFragment) fragmentManager.findFragmentByTag("favoriteFragment");
            userFragment = (UserFragment) fragmentManager.findFragmentByTag("userFragment");
            currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        }

        mainPageSharedPreferences = getSharedPreferences("mainPage",MODE_PRIVATE);
        String pageis = mainPageSharedPreferences.getString("pageis","");
        transaction = fragmentManager.beginTransaction();
        if (pageis.equals("home")){
            selectedHome();
        } else if (pageis.equals("notification")) {
            selectedNotification();
        } else if (pageis.equals("favorite")) {
            selectedFavorite();
        } else if (pageis.equals("user")) {
            selectedUser();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPageSharedPreferences = getSharedPreferences("mainPage",MODE_PRIVATE);
        SharedPreferences.Editor editor = mainPageSharedPreferences.edit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    selectedHome();
                    currentFragment = homeFragment;
                    return true;
                } else if (item.getItemId() == R.id.menu_notification) {
                    selectedNotification();
                    currentFragment = notificationFragment;
                    return true;
                } else if (item.getItemId() == R.id.menu_favorite) {
                    selectedFavorite();
                    currentFragment = favoriteFragment;
                    return true;
                } else if (item.getItemId() == R.id.menu_user) {
                    selectedUser();
                    currentFragment = userFragment;
                    return true;
                } else if (item.getItemId() == R.id.menu_new) {
                    showNewAlertDialog();
                }
                return false;
            }
        });
    }

    private void showNewAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("发布新帖子");

        final EditText editText = new EditText(MainActivity.this);
        builder.setView(editText);

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String enteredText = editText.getText().toString();
                //处理输入的文本
                Toast.makeText(MainActivity.this, "Entered Text : " + enteredText, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void selectedHome(){
        transaction = fragmentManager.beginTransaction();
        transaction.show(homeFragment)
                .hide(notificationFragment)
                .hide(favoriteFragment)
                .hide(userFragment)
                .addToBackStack(null)
                .commit();
    }

    private void selectedNotification(){
        transaction = fragmentManager.beginTransaction();
        transaction.show(notificationFragment)
                .hide(homeFragment)
                .hide(favoriteFragment)
                .hide(userFragment)
                .addToBackStack(null)
                .commit();
    }

    private void selectedFavorite(){
        transaction = fragmentManager.beginTransaction();
        transaction.show(favoriteFragment)
                .hide(homeFragment)
                .hide(notificationFragment)
                .hide(userFragment)
                .addToBackStack(null)
                .commit();
    }

    private void selectedUser(){
        transaction = fragmentManager.beginTransaction();
        transaction.show(userFragment)
                .hide(homeFragment)
                .hide(notificationFragment)
                .hide(favoriteFragment)
                .addToBackStack(null)
                .commit();
    }
}