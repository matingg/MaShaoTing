package com.mashaoting.mashaoting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class BFViewpagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> fragments;
    private String[] titles = new String[]{"989898", "dfkrbmtbtr"};

    public BFViewpagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragments = fragmentList ;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}