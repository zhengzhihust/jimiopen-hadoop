package com.hadoop.hdfs.url;

import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuanlang on 2/27/16.
 */
public class FileSystem {

    public void readFile(String inputFilePath){
        InputStream inputStream = null;
        try{
            inputStream = new URL("hdfs://localhost/path").openStream();
            // progress in
            IOUtils.copyBytes(inputStream, System.out, 4096, false);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(inputStream);
        }
    }
}
