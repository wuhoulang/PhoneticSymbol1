//package zuo.biao.library.util.bitmapUtils;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//import android.widget.ImageView;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * Created by HAOJI on 2019/10/9.
// */
//
//public class NetCacheUtils {
//
//    private LocalCacheUtils mLocalCacheUtils;
//    private MemoryCacheUtils mMemoryCacheUtils;
//
//    public NetCacheUtils(LocalCacheUtils localCacheUtils,MemoryCacheUtils memoryCacheUtils){
//        mLocalCacheUtils=localCacheUtils;
//        mMemoryCacheUtils=memoryCacheUtils;
//    }
//
//    public void getBitmapFromNet(ImageView ivPic,String url){
//        new BitmapTask().execute(ivPic,url);
//    }
//
//    class BitmapTask extends AsyncTask<Object,Void,Bitmap>{
//        private ImageView ivPic;
//        private String url;
//        @Override
//        protected Bitmap doInBackground(Object[] params) {
//            ivPic = (ImageView) params[0];
//            url = (String) params[1];
//            return downLoadBitmap(url);
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            if(bitmap!=null){
//                ivPic.setImageBitmap(bitmap);
//            }
//            mLocalCacheUtils.setBitmapToLocal(url, bitmap);
//            mMemoryCacheUtils.setBitmapToMemory(url, bitmap);
//            super.onPostExecute(bitmap);
//        }
//    }
//
//    private Bitmap downLoadBitmap(String url) {
//        try {
//            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
//            con.setRequestMethod("GET");
//            con.setConnectTimeout(5000);
//            con.setReadTimeout(5000);
//            int responseCode = con.getResponseCode();
//            if (responseCode==200){
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inSampleSize=2;//宽高压缩为原来的1/2
//                options.inPreferredConfig=Bitmap.Config.ARGB_4444;
//                Bitmap bitmap = BitmapFactory.decodeStream(con.getInputStream(),null,options);
//                return bitmap;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
