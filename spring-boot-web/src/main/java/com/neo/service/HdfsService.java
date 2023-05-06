package com.neo.service;

/**
 * @author hk
 * @version 1.0
 * @date 2022/6/1 0001 23:57
 */
public interface HdfsService {
    void fileSystemCat(String fileName);
    void createFile(String fileName);
    void upLoad(String fileName);
    void deleteFile(String fileName);
    void downLoad(String fileName);
}
