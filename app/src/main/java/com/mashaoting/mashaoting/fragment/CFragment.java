package com.mashaoting.mashaoting.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mashaoting.mashaoting.base.BaseFragment;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class CFragment extends BaseFragment {
    TextView textView ;

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(45);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("C页面");
        Log.e("TAG", "CFragment initData()");
        Toast.makeText(context, " C页面", Toast.LENGTH_SHORT).show();
    }
}
