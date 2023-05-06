package com.neo.service.impl;

import com.neo.service.HdfsService;
import com.neo.util.HdfsUtils;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author hk
 * @version 1.0
 * @date 2022/6/1 0001 23:58
 */
@Service
public class HdfsServiceImpl implements HdfsService {

    @Autowired
    private HdfsUtils hdfsUtils;

    @Override
    public void fileSystemCat(String fileName) {
        FileSystem fileSystem = hdfsUtils.getFileSystem();
        try {
            InputStream inputStream = fileSystem.open(new Path("hdfs:/" + fileName));
            IOUtils.copyBytes(inputStream, System.out, 4096, false);
            IOUtils.closeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createFile(String fileName) {
        FileSystem fileSystem = hdfsUtils.getFileSystem();
        try {
            FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("hdfs:/" + fileName));
            fsDataOutputStream.write("aa".getBytes());
            fsDataOutputStream.close();
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upLoad(String fileName) {
        FileSystem fileSystem = hdfsUtils.getFileSystem();
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\demo.sh"));
            FSDataOutputStream fsDataOutputStream = fileSystem.create(
                    new Path("hdfs:/" + fileName), new Progressable() {
                        @Override
                        public void progress() {
                            System.out.println("-");
                        }
                    });
            IOUtils.copyBytes(inputStream, fsDataOutputStream, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteFile(String fileName) {
        FileSystem fileSystem = hdfsUtils.getFileSystem();
        boolean isOk = false;
        try {
            isOk = fileSystem.deleteOnExit(new Path("hdfs:/" + fileName));
            if (isOk) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downLoad(String fileName) {
        FileSystem fileSystem = hdfsUtils.getFileSystem();
        Path src = new Path("hdfs:/" + fileName);
        Path dst = new Path("D:/" + fileName);
        try {
            fileSystem.copyToLocalFile(false, src, dst, true);
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
