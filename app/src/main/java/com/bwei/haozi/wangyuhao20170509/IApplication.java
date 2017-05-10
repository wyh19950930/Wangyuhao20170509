package com.bwei.haozi.wangyuhao20170509;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by haozi on 2017/5/9.
 */

/**
 * 2017 05 09 09:51 王禹皓
 */
public class IApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);

    }


}
