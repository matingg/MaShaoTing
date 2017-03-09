package com.mashaoting.mashaoting.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.WelcomeActivity;
import com.mashaoting.mashaoting.adapter.ListViewAdapter;
import com.mashaoting.mashaoting.base.BaseFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class BFragment2 extends BaseFragment {


    @InjectView(R.id.svedbt)
    ListView svedbt;

    ArrayList arrayList = new ArrayList<>();
    ListViewAdapter adapter;
    @InjectView(R.id.swi)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.kj_item, null);
        ButterKnife.inject(this, view);
        return view;
    }

    public void add() {
        arrayList.add(R.drawable.ab);

        arrayList.add(R.drawable.ac);
        arrayList.add(R.drawable.ad);
//    arrayList.add(R.drawable.ae);
//    arrayList.add(R.drawable.ab);
//    arrayList.add(R.drawable.ac);
    }

    @Override
    public void initData() {
//        arrayList.add(R.drawable.ae);
//        arrayList.add(R.drawable.ab);
        arrayList.add(R.drawable.ac);
        add();

        adapter = new ListViewAdapter(context, arrayList);
        svedbt.setAdapter(adapter);

        swipeRefreshLayout.setDistanceToTriggerSync(100);
//设置颜色
        swipeRefreshLayout.setColorSchemeColors(Color.BLACK, Color.RED);
//设置背景颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_orange_dark);
//下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context , WelcomeActivity.class);
                startActivity(intent);
                swipeRefreshLayout.setRefreshing(false);//取消 下拉刷新時的圆圈


            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }
}
