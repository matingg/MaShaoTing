package com.mashaoting.mashaoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeActivity extends AppCompatActivity {

    @InjectView(R.id.main_lllll)
    ImageView mainLllll;
    @InjectView(R.id.activity_welcome)
    RelativeLayout activityWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);


        mainLllll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                mainLllll.setAnimation(getAlphaAnimation());
                startActivity(intent);

            }
        });
    }


    /**
     * 透明效果
     *
     * @return
     */
    public Animation getAlphaAnimation() {
        //实例化 AlphaAnimation 主要是改变透明度
        //透明度 从 1-不透明 0-完全透明
        Animation animation = new AlphaAnimation(1.0f, 0.5f);
        //设置动画插值器 被用来修饰动画效果,定义动画的变化率
        animation.setInterpolator(new DecelerateInterpolator());
        //设置动画执行时间
        animation.setDuration(1000);
        return animation;
    }


}
