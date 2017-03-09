package com.mashaoting.mashaoting.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.bean.AFragmentBean;
import com.mashaoting.mashaoting.utils.Constants;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class ListViewAgapter extends BaseAdapter {

    private final Context context;
    private final List<AFragmentBean.ResultBean.RecommendInfoBean> datas;
    private AFragmentBean.ResultBean.RecommendInfoBean infoBean;

    public ListViewAgapter(Context context, List<AFragmentBean.ResultBean.RecommendInfoBean> recommend_info) {
        this.context = context;

        datas = recommend_info;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = View.inflate(context, R.layout.listview_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        infoBean = datas.get(position);
        viewHolder.tvList1.setText(infoBean.getName());
        viewHolder.tvList2.setText(infoBean.getCover_price());
//        Glide.with(context).load(Constants.BASE_URL_IMAGE + infoBean.getFigure()).into(viewHolder.ivList);
        Glide.with(context)
                .load(Constants.BASE_URL_IMAGE+infoBean.getFigure())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.ivList);


        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_list)
        ImageView ivList;
        @InjectView(R.id.tv_list_1)
        TextView tvList1;
        @InjectView(R.id.tv_list_2)
        TextView tvList2;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
