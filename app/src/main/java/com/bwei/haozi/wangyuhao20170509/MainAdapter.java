package com.bwei.haozi.wangyuhao20170509;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.BaseAdapter;

import com.bwei.haozi.wangyuhao20170509.fragment.Fragment01;
import com.bwei.haozi.wangyuhao20170509.fragment.Fragment02;
import com.bwei.haozi.wangyuhao20170509.fragment.Fragment03;
import com.bwei.haozi.wangyuhao20170509.fragment.Fragment04;
import com.bwei.haozi.wangyuhao20170509.fragment.Fragment05;
import com.bwei.haozi.wangyuhao20170509.fragment.Fragment06;

/**
 * Created by haozi on 2017/5/9.
 */

public class MainAdapter extends FragmentPagerAdapter {


    String[] TITLE = {"热点","娱乐","体育","科技","财经","军事"};
    private Fragment fragment;

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        fragment = new Fragment();


        switch (position){


            case 0:

                fragment = new Fragment01();

                break;

            case 1:

                fragment = new Fragment02();

                break;

            case 2:

                fragment = new Fragment03();

                break;

            case 3:

                fragment = new Fragment04();

                break;

            case 4:

                fragment = new Fragment05();

                break;

            case 5:

                fragment = new Fragment06();

                break;



        }


        return fragment;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
