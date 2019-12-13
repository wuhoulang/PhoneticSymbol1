package zuo.biao.library.network_request;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mirkowu.baselibrarysample.R;


/**
 * Created by HAOJI on 2019/8/14.
 */

public class TaskActivity extends Activity {

    private Button cancel,button;
    private TextView text;
    private ProgressBar progress_bar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        cancel=findViewById(R.id.cancel);
        button=findViewById(R.id.button);
        text=findViewById(R.id.text);
        progress_bar=findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyTask().execute();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyTask().cancel(true);
            }
        });
    }

    public class MyTask extends AsyncTask<String,Integer,String> {


        @Override
        protected void onPreExecute() {
            text.setText("正在加载中");
        }

        @Override
        protected String doInBackground(String... strings) {

                try {
                    int count = 0;
                    int length = 1;
                    while (count<99) {
                        count = count + length;
                        publishProgress(count);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progress_bar.setProgress(values[0]);
            text.setText("loading..." + values[0] + "%");
        }

        @Override
        protected void onPostExecute(String s) {
            text.setText("加载完毕");
        }

        @Override
        protected void onCancelled() {
            text.setText("已取消");
            progress_bar.setProgress(0);
        }
    }
}
