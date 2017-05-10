package com.bwei.haozi.wangyuhao20170509.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by haozi on 2017/5/9.
 */

public class StringUtils {

    public static String ReadFile(InputStream inputStream){

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len = 0;

            byte[] buffer = new byte[1024];

            while((len = inputStream.read(buffer))!=-1){

                baos.write(buffer,0,len);

            }

            inputStream.close();
            baos.close();

            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;

    }
}
