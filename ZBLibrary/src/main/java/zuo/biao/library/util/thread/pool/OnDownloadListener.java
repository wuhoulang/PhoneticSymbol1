package zuo.biao.library.util.thread.pool;

import java.io.File;

/**
 * Created by HAOJI on 2019/9/3.
 */

public interface OnDownloadListener {

    void onDownloadSuccess(File file);

    void onDownloadFailed(Exception e);

    void onDownloadLoading(int progress);
}
