package com.mashaoting.mashaoting.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.mashaoting.mashaoting.utils.CacheUtil;
import com.mashaoting.mashaoting.utils.Constants;
import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.adapter.AFRecyclerViewAdapter;
import com.mashaoting.mashaoting.base.BaseFragment;
import com.mashaoting.mashaoting.bean.AFragmentBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class AFragment extends BaseFragment {


    @InjectView(R.id.a_f_recycleview)
    RecyclerView aFRecycleview;
    @InjectView(R.id.tcv)
    TextView tcv;
    private AFragmentBean.ResultBean result;

    AFRecyclerViewAdapter afRecyclerViewAdapter;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.a_fragment_a, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        Log.e("TAG", "AFragment initData()");

        getDataFromNet();

    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "AFragment 网络数据链接失败 onError()"+e.getMessage());

                        String json = CacheUtil.getString(context, "json");
                        if(json != null) {
                            processData(json);// 处理数据
                        }

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "AFragment网络数据链接成功 onResponse()");

                        //保存本地缓存
                        CacheUtil.putString(context,"json",response);


                        processData(response);// 处理数据


                    }
                });

    }

    private void processData(String json) {

        if(TextUtils.isEmpty(json)) {
            return;
        }


        AFragmentBean aFragmentBean = JSON.parseObject(json , AFragmentBean.class);
        result = aFragmentBean.getResult();
        Log.e("TAG", "--------- processData()"+result.getAct_info().get(0).getName());
        //得到数据 把数据通过 构造器传给 适配器
        afRecyclerViewAdapter = new AFRecyclerViewAdapter(context ,result);
        aFRecycleview.setAdapter(afRecyclerViewAdapter);

        aFRecycleview.setLayoutManager(new LinearLayoutManager(context ));




    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
