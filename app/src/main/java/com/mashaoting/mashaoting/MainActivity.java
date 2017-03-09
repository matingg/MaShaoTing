package com.mashaoting.mashaoting;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.mashaoting.mashaoting.base.BaseFragment;
import com.mashaoting.mashaoting.fragment.AFragment;
import com.mashaoting.mashaoting.fragment.BFragment;
import com.mashaoting.mashaoting.fragment.CFragment;
import com.mashaoting.mashaoting.fragment.DFragment;
import com.mashaoting.mashaoting.fragment.EFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    List<BaseFragment> fragmentList;
    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    private int mycheckedId;

    private BaseFragment tempFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();//初始化Fragment

        initListenrt();

        switchFragment(fragmentList.get(0));

    }

    private void initListenrt() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mycheckedId = 0;
                        break;
                    case R.id.rb_type:
                        mycheckedId = 1;
                        break;
                    case R.id.rb_community:
                        mycheckedId = 2;
                        break;
                    case R.id.rb_chrt:
                        mycheckedId = 3;
                        break;
                    case R.id.rb_user:
                        mycheckedId = 4;
                        break;

                }

                switchFragment(fragmentList.get(mycheckedId));//切换Fragment

            }


        });
            rgMain.check(R.id.rb_home);//默认选择0
    }

    private void switchFragment(BaseFragment currentFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (tempFragment != currentFragment) {

            if (!currentFragment.isAdded()) {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                ft.add(R.id.fl_main, currentFragment);
            } else {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                ft.show(currentFragment);
            }


        }
        ft.show(currentFragment);
        tempFragment = currentFragment;
        ft.commit();


    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());
        fragmentList.add(new CFragment());
        fragmentList.add(new DFragment());
        fragmentList.add(new EFragment());

    }


}
