package zuo.biao.library.util;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by HAOJI on 2019/7/26.
 */

public class StreamUtils {

    /**
     * 方法一
     */

    public static String readInputStream(InputStream is){
        try {
//            字节数组输出流 创建一个字节数组缓冲区,所有发送到输出流的数据保存在该字节数组缓冲区中
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
//            定义一个字节数组,相当于缓存
            byte[] bytes =new byte[1024];
            int length =0;
//            把is里的东西读到bytes数组里去
            while ((length=is.read(bytes))!=-1){
                    bos.write(bytes,0,length);
            }
            is.close();
            bos.close();
            byte[] temp =bos.toByteArray();
//            字节转出String
            String result =new String(temp);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方法二
     */

    public static String readInputStream2(InputStream is){
//        BufferedReader 流能够读取文本行 , 通过向 BufferedReader 传递一个 Reader 对象, 来创建一个 BufferedReader 对象 , 之所以这样做是因为 FileReader 没有提供读取文本行的功能 .
        BufferedReader reader =new BufferedReader(new InputStreamReader(is));
        StringBuilder sb =new StringBuilder();
        String line =null;
        try {
            while ((line=reader.readLine())!=null){
                    sb.append(line+"/n");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
