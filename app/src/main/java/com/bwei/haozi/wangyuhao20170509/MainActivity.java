package com.bwei.haozi.wangyuhao20170509;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 2017 05 09 08:58王禹皓
 * 主界面
 */


// 显示布局文件
@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    // 实例化
    @ViewInject(R.id.vp)
    ViewPager vp;

    @ViewInject(R.id.tab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);




        x.view().inject(this);

        //tab = (TabLayout) findViewById(R.id.tab);
        //vp = (ViewPager) findViewById(R.id.vp);


        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        vp.setAdapter(adapter);

        //关联
        tab.setupWithViewPager(vp);

        //设置选择和选中字体的颜色
        tab.setTabTextColors(getResources().getColor(R.color.read),getResources().getColor(R.color.black));

        //设置显示器颜色
        tab.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));

        //设置模式有常规和滚动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);


    }




}
