package com.neo.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;


/**
 * @author hk
 * @version 1.0
 * @date 2022/6/1 0001 22:03
 */
@org.springframework.context.annotation.Configuration
public class HdfsUtils {

    @Autowired
    private NeoProperties neoProperties;

    private Configuration configuration = new Configuration();

    public Configuration getConfiguration() {
        configuration.set(neoProperties.getHdfsName(), neoProperties.getHdfsUrl());
        return configuration;
    }

    public FileSystem getFileSystem() {
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.get(getConfiguration());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSystem;
    }
}
