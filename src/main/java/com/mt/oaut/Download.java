package com.mt.oaut;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: xgr01
 * Date: 13-12-31
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */
public class Download {
    public static void main(String args[]) throws Exception{
        try {
            //根据String形式创建一个URL对象，
            URL url = new URL("http://file.bzjw.com/200907/20090722101609.jpg");
            //实列一个URLconnection对象，用来读取和写入此 URL 引用的资源
            URLConnection con = url.openConnection();
            //获取一个输入流
            InputStream is = con.getInputStream();
            //实列一个输出对象
            FileOutputStream fos = new FileOutputStream("../image/a.jpg");
            //一个byte[]数组，一次读取多个字节
            byte[] bt = new byte[200];
            //用来接收每次读取的字节个数
            int b = 0;
            //循环判断，如果读取的个数b为空了，则is.read()方法返回-1，具体请参考InputStream的read();
            while ((b = is.read(bt)) != -1) {
                //将对象写入到对应的文件中
                fos.write(bt, 0, b);
            }
            //刷新流
            fos.flush();
            //关闭流
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
