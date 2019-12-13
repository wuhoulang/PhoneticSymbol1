package zuo.biao.library.network_request;

import android.os.AsyncTask;

/**
 * Created by HAOJI on 2019/9/21.
 */

public class Task extends AsyncTask<String,Integer,String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


}
