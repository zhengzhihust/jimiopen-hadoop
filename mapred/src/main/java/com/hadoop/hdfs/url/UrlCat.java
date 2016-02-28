package com.hadoop.hdfs.url;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.net.URL;

/**
 * Created by yuanlang on 2/27/16.
 */
public class UrlCat {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
}
