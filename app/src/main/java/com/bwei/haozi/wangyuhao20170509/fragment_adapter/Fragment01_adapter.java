package com.bwei.haozi.wangyuhao20170509.fragment_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.haozi.wangyuhao20170509.R;
import com.bwei.haozi.wangyuhao20170509.bean.Fra01_bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.x;

import java.util.List;

/**
 * Created by haozi on 2017/5/9.
 */

/**
 * 2017 05 09 09:36 王禹皓
 */

public class Fragment01_adapter extends BaseAdapter {

    List<Fra01_bean.DataBean> list;

    Context context;


    public Fragment01_adapter(List<Fra01_bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolderOne vone = null;

        if (view == null){

            vone = new ViewHolderOne();
            view = View.inflate(context, R.layout.fra01_item, null);

            vone.imageView = (ImageView) view.findViewById(R.id.fra01_image);
            vone.title = (TextView) view.findViewById(R.id.fra01_title);
            vone.summary = (TextView) view.findViewById(R.id.fra01_tsummary);

            view.setTag(vone);
        }else{

            vone = (ViewHolderOne) view.getTag();

        }


      // ImageLoader.getInstance().displayImage(list.get(i).getPic_url(),vone.imageView);
        x.image().bind(vone.imageView,list.get(i).getPic_url());
        vone.title.setText(list.get(i).getNews_title());
        vone.summary.setText(list.get(i).getNews_summary());

        return view;
    }


    class ViewHolderOne{

        ImageView imageView;

        TextView title;

        TextView summary;

    }
}
