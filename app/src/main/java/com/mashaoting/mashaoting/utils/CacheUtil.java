package com.mashaoting.mashaoting.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by fq on 2017/2/4.
 */

public class CacheUtil {
    /**
     * 保存Boolean数据类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("fq", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key) {
        return context.getSharedPreferences("fq", Context.MODE_PRIVATE).getBoolean(key, false);
    }

    public static void putString(Context context, String key, String value) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //sd卡可用
            FileOutputStream fos = null;
            try {
                String fileName = MD5Encoder.encode(key);
                String dir = Environment.getExternalStorageDirectory() + "/BeiJingNews";
                File file = new File(dir, fileName);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fos = new FileOutputStream(file);
                fos.write(value.getBytes());
                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            SharedPreferences sp = context.getSharedPreferences("fq", Context.MODE_PRIVATE);
            sp.edit().putString(key, value).commit();
        }
    }

    public static String getString(Context context, String key) {
        String result = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //sd卡可用
            FileInputStream fis = null;
            ByteArrayOutputStream bos = null;
            try {
                String fileName = MD5Encoder.encode(key);
                String dir = Environment.getExternalStorageDirectory() + "/BeiJingNews";
                File file = new File(dir, fileName);
                if (file.exists()) {
                    fis = new FileInputStream(file);
                    int len = -1;
                    byte[] buffer = new byte[1024];
                    bos = new ByteArrayOutputStream();
                    while ((len = fis.read(buffer))!=-1){
                        bos.write(buffer,0,len);
                    }
                    result =  bos.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        fis = null;
                        e.printStackTrace();
                    }
                }
                if(bos!=null){
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            result = context.getSharedPreferences("fq", Context.MODE_PRIVATE).getString(key, "");
        }
        return result;
    }
}
