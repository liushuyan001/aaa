package com.bwie.liushuyan20181008;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bwie.liushuyan20181008.fragment.FirstFragment;
import com.bwie.liushuyan20181008.fragment.MyFragment;
import com.bwie.liushuyan20181008.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private ViewPager vpShow;
    private TabLayout tlTitle;
    private List<Fragment> fragments;
    private FirstFragment firstFragment;
    private SortFragment sortFragment;
    private MyFragment myFragment;
    private String[] titles = {"首页","分类","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLogo = findViewById(R.id.img_logo);
        vpShow = findViewById(R.id.vp_show);
        tlTitle = findViewById(R.id.tl_title);
        fragments = new ArrayList<>();
        firstFragment = new FirstFragment();
        sortFragment = new SortFragment();
        myFragment = new MyFragment();
        fragments.add(firstFragment);
        fragments.add(sortFragment);
        fragments.add(myFragment);
        vpShow.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        tlTitle.setupWithViewPager(vpShow);

    }
}
