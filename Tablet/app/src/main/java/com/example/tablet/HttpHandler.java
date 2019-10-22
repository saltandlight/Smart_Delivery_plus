package com.example.tablet;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    public static String getString(String urlstr){
        //url에 접속함.
        String result=null;
        URL url=null;
        HttpURLConnection hcon=null;
        BufferedReader is=null;


        try {
            url = new URL(urlstr);
            hcon=(HttpURLConnection) url.openConnection();
            hcon.setConnectTimeout(10000);
            hcon.setRequestMethod("GET");
            Log.d("[is]","pre is "+url);
            InputStream inputStream = hcon.getInputStream();
            is=new BufferedReader(new InputStreamReader(hcon.getInputStream()));

            result=convertStr(is);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hcon.disconnect();
        }
        return result;
    }

    private static String convertStr(BufferedReader is) {
        BufferedReader br = null;
        br=is;
        StringBuilder sb= new StringBuilder();
        String temp;
        try{
            //한 라인씩 읽고 temp에 집어넣음.
            while((temp = br.readLine()) != null){
                sb.append(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.d("[str]", sb+"");
        return sb.toString();
    }

}