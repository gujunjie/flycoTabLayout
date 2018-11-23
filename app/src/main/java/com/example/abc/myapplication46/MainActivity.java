package com.example.abc.myapplication46;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.slidingTabLayout)
    SlidingTabLayout slidingTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.slidingTabLayout2)
    SlidingTabLayout slidingTabLayout2;
    @BindView(R.id.slidingTabLayout3)
    SlidingTabLayout slidingTabLayout3;
    @BindView(R.id.slidingTabLayout4)
    SlidingTabLayout slidingTabLayout4;
    @BindView(R.id.slidingTabLayout5)
    SlidingTabLayout slidingTabLayout5;
    @BindView(R.id.slidingTabLayout6)
    SlidingTabLayout slidingTabLayout6;
    @BindView(R.id.slidingTabLayout7)
    SlidingTabLayout slidingTabLayout7;
    @BindView(R.id.commonTabLayout)
    CommonTabLayout commonTabLayout;
    @BindView(R.id.segmentTabLayout)
    SegmentTabLayout segmentTabLayout;

    private String[] title = {"游戏", "音乐", "电影", "棋牌", "休闲", "棋牌", "休闲"};

    private int[] iconUnSelect = {R.drawable.home, R.drawable.ear, R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home};

    private int[] iconSelect = {R.drawable.home_pressed, R.drawable.ear_pressed, R.drawable.home_pressed, R.drawable.home_pressed, R.drawable.home_pressed, R.drawable.home_pressed, R.drawable.home_pressed,};

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        fragments.add(new MyFragment());
        viewpager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(), fragments));

        slidingTabLayout.setViewPager(viewpager, title);

        slidingTabLayout2.setViewPager(viewpager, title);
        slidingTabLayout3.setViewPager(viewpager, title);
        slidingTabLayout4.setViewPager(viewpager, title);
        slidingTabLayout5.setViewPager(viewpager, title);
        slidingTabLayout6.setViewPager(viewpager, title);
        slidingTabLayout7.setViewPager(viewpager, title);

        ArrayList<CustomTabEntity> customTabEntityArrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            final int temp = i;
            customTabEntityArrayList.add(new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return title[temp];
                }

                @Override
                public int getTabSelectedIcon() {
                    return iconSelect[temp];
                }

                @Override
                public int getTabUnselectedIcon() {
                    return iconUnSelect[temp];
                }
            });

        }

        commonTabLayout.setTabData(customTabEntityArrayList);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        commonTabLayout.showMsg(1, 99);


        segmentTabLayout.setTabData(title);

        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


    }
}
