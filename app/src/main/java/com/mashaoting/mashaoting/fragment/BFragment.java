package com.mashaoting.mashaoting.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.adapter.BFViewpagerAdapter;
import com.mashaoting.mashaoting.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class BFragment extends BaseFragment {


    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_community, null);
        return view;
    }

    BFViewpagerAdapter adapter;
    private List<Fragment> fragmentList;

    @Override
    public void initData() {
        initFragment();
        adapter = new BFViewpagerAdapter(getFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new BFragment1());
        fragmentList.add(new BFragment2());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
