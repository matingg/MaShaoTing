package com.mashaoting.mashaoting.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mashaoting.mashaoting.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class ListViewAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList datas;

    public ListViewAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        datas = arrayList;
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
        ViewHolder viewHolder ;
        if (convertView == null) {

            convertView = View.inflate(context, R.layout.lisf, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.jnkfvgb.setBackgroundResource((Integer) datas.get(position));

        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.jnkfvgb)
        ImageView jnkfvgb;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
