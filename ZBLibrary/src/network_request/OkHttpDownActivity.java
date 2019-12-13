package zuo.biao.library.network_request;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mirkowu.baselibrarysample.Interface.OnDownloadListener;
import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.utils.DownloadUtil;

import java.io.File;

/**
 * Created by HAOJI on 2019/9/3.
 */

public class OkHttpDownActivity extends Activity {
  private  ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_file);
        Button id_load = findViewById(R.id.id_load);
        String url = "http://acj4.pc6.com/pc6_soure/2019-8/com.sankuai.meituan_1000020203.apk";
        id_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(OkHttpDownActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("正在下载");
                progressDialog.setMessage("请稍后...");
                progressDialog.setProgress(0);
                progressDialog.setMax(100);
                progressDialog.show();
                progressDialog.setCancelable(false);
                DownloadUtil.get().download(url, Environment.getExternalStorageDirectory().getAbsolutePath(), "meituan.apk", new OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess(File file) {
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        Log.e("download", "onDownloadSuccess");
                    }

                    @Override
                    public void onDownloadFailed(Exception e) {
                        Log.e("download", "onDownloadFailed");
                    }

                    @Override
                    public void onDownloadLoading(int progress) {
                        progressDialog.setProgress(progress);
                        Log.e("download", "onDownloadLoading");
                    }
                });

            }
        });

    }
}
