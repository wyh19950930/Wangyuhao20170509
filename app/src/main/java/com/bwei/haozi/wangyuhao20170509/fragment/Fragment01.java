package com.bwei.haozi.wangyuhao20170509.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.haozi.wangyuhao20170509.R;
import com.bwei.haozi.wangyuhao20170509.bean.Fra01_bean;
import com.bwei.haozi.wangyuhao20170509.fragment_adapter.Fragment01_adapter;
import com.bwei.haozi.wangyuhao20170509.xlistview.XListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haozi on 2017/5/9.
 */

/**
 * 2017 05 09 09:34 王禹皓
 */

public class Fragment01 extends Fragment implements XListView.IXListViewListener{


    private XListView fra01_xlv;
    private int type = 1;
    private Fragment01_adapter adapter;
    private List<Fra01_bean.DataBean> list = new ArrayList<>();
    private ListView fra_lv;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            switch(msg.what){

                case 1:

                    List<Fra01_bean.DataBean> listBeen = (List<Fra01_bean.DataBean>) msg.obj ;
                    update(listBeen,1);

                    adapter.notifyDataSetChanged();
                    break;
                case 2:

                    update( (List<Fra01_bean.DataBean>) msg.obj,2);

                    adapter.notifyDataSetChanged();
                    break;
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment01, container, false);

        fra01_xlv = (XListView) inflate.findViewById(R.id.fra01_xlv);

        fra01_xlv.setPullRefreshEnable(true);
        fra01_xlv.setPullLoadEnable(true);
        fra01_xlv.setXListViewListener(this);
        //fra_lv = (ListView) inflate.findViewById(R.id.fra_lv);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);







                postvalue(type);



        //update();

       adapter = new Fragment01_adapter(list,getActivity());

        fra01_xlv.setAdapter(adapter);


    }


   private void update(List datas, int types){

        if (types == 1){

            list.clear();
            list.addAll(datas);
            adapter.notifyDataSetChanged();

            fra01_xlv.stopRefresh();
            fra01_xlv.setRefreshTime("刚刚");

        }else{

            list.addAll(datas);
            adapter.notifyDataSetChanged();

            fra01_xlv.stopLoadMore();

        }

    }


    //下拉
    @Override
    public void onRefresh() {

        type = 1;

        postvalue(type);

        fra01_xlv.setRefreshTime("刚刚");
        fra01_xlv.stopRefresh();

    }

    //上拉
    @Override
    public void onLoadMore() {

        type += 1;

        postvalue(type);

    }

    //post请求

    private void postvalue(final int type){

        RequestParams requestParams = new RequestParams("http://api.expoon.com/AppNews/getNewsList");

        requestParams.addBodyParameter("type",type+"");

        requestParams.addBodyParameter("p","1");


        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {

                System.out.println("result = " + result);

                Gson gson = new Gson();

                Fra01_bean fra01_bean = gson.fromJson(result, Fra01_bean.class);

                List<Fra01_bean.DataBean> data = fra01_bean.getData();

                Message msg = Message.obtain();

                msg.what = type == 1?1:2;

                msg.obj = data;

                handler.sendMessage(msg);
                list.addAll(data);

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });


    }

}
