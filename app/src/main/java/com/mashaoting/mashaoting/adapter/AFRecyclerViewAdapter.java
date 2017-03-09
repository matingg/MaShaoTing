package com.mashaoting.mashaoting.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.mashaoting.mashaoting.utils.Constants;
import com.mashaoting.mashaoting.R;
import com.mashaoting.mashaoting.bean.AFragmentBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 麻少亭 on 2017/3/9.
 */

public class AFRecyclerViewAdapter extends RecyclerView.Adapter {


    private Context context;
    private final AFragmentBean.ResultBean datas;

    public static final int BANNER = 0;

    public static final int CHANNEL = 1;//频道


    public static final int RECOMMEND = 5;//推荐


    private LayoutInflater inflater;

    private int temp;


    public AFRecyclerViewAdapter(Context context, AFragmentBean.ResultBean result) {
        this.context = context;
        datas = result;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getItemViewType(int position) {

        if (position == BANNER) {
            temp = BANNER;
        } else if (position == CHANNEL) {
            temp = CHANNEL;
        } else if (position == RECOMMEND) {
            temp = RECOMMEND;
        }


        return temp;//当前的类型
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (BANNER == viewType) {
            View view = View.inflate(context, R.layout.a_f_item, null);
            return new AViewHolder(context, view);
        } else if (viewType == RECOMMEND) {
            View view = View.inflate(context, R.layout.a_f2_item_, null);
            return new REViewHolder(context, view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == BANNER) {

            AViewHolder aViewHolder = (AViewHolder) holder;

            aViewHolder.setData(datas.getBanner_info());

        }else  if(getItemViewType(position) == RECOMMEND) {


            REViewHolder reviewholder = (REViewHolder) holder;

            reviewholder.setData(datas.getRecommend_info());


        }




    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class AViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        @InjectView(R.id.banner)
        Banner banner;

        AViewHolder(Context context, View view) {
            super(view);
            ButterKnife.inject(this, view);
            this.context = context;
        }


        public void setData(List<AFragmentBean.ResultBean.BannerInfoBean> banner_info) {

            List<String> urls = new ArrayList<>();
            for (int i = 0; i < banner_info.size(); i++) {
                urls.add(Constants.BASE_URL_IMAGE + banner_info.get(i).getImage());
            }
            banner.setImages(urls)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context)
                                    .load(path)
                                    .centerCrop()
                                    .crossFade()
                                    .into(imageView);
                        }
                    }).start();
        }
    }

    static class REViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        @InjectView(R.id.lv_f1_re_item)
        ListView lvF1ReItem;
        ListViewAgapter adapter ;
        REViewHolder(Context context, View view) {
            super(view);
            ButterKnife.inject(this, view);
            this.context = context ;
        }

        public void setData(List<AFragmentBean.ResultBean.RecommendInfoBean> recommend_info) {


            adapter = new ListViewAgapter(context ,recommend_info );
            lvF1ReItem.setAdapter(adapter);

        }
    }
}
