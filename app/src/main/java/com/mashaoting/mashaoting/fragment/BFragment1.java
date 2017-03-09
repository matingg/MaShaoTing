package com.mashaoting.mashaoting.fragment;

import android.view.View;
import android.widget.ImageView;

import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class BFragment1 extends BaseFragment {


    @InjectView(R.id.action_bar_subt)
    ImageView actionBarSubt;


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.kjt_item, null);
        ButterKnife.inject(this, view);
        return view;
    }


    @Override
    public void initData() {


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
