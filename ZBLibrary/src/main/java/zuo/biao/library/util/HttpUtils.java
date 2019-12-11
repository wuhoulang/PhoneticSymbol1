package zuo.biao.library.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HAOJI on 2019/7/26.
 */

public class HttpUtils {

    /**
     *
     * 方法一
     */

    public static String requestGet(String name, String passwored){
        String path ="";
        try {
            URL urL =new URL(path);
            HttpURLConnection con = (HttpURLConnection)urL.openConnection();
            //get 请求
            con.setConnectTimeout(5000);
            con.setRequestMethod("GET");
            con.setDoInput(true);

            //post 请求
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Charset","UTF-8");
//            con.setRequestProperty("Content-type","application/x-www-form-urlencoded");

            con.setRequestProperty("Charset","UTF-8");

            if (con.getResponseCode()==200) {
                InputStream is =con.getInputStream();
                String result =StreamUtils.readInputStream(is);
                return result;
            } else  {
                 return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void gethttp(){
        try {
            URL url =new URL("");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(5000);
            con.setConnectTimeout(5000);
            con.setDoInput(true);
            con.setRequestMethod("GET");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
