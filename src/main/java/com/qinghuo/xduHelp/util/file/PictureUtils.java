package com.qinghuo.xduHelp.util.file;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class PictureUtils {

    public static String PictureProcess(List<String> img) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<img.size();i++){
            if (i == img.size()-1) {
                stringBuilder.append(img.get(i));
            }
            else{
                stringBuilder.append(img.get(i) + ",");
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> Picturestr2List(String img){
        String[] strings = img.split(",");
        List<String> res = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            res.add(strings[i]);
        }
        return res;
    }

    public static void pictureSaveFile(String destUrl, String path) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream(path);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpUrl.disconnect();
        }
    }
}
