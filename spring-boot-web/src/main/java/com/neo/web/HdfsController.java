package com.neo.web;

import com.neo.service.HdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hk
 * @version 1.0
 * @date 2022/6/3 0003 16:45
 */
@RestController
@RequestMapping("/hdfs")
public class HdfsController {

    @Autowired
    private HdfsService hdfsService;

    @PostMapping("/fileSystemCat")
    public void fileSystemCat() {
        hdfsService.fileSystemCat("demo.sh");
    }

    @PostMapping("/createFile")
    public void createFile() {
        hdfsService.createFile("demo.sh");
    }

    @PostMapping("/upLoad")
    public void upLoad() {
        hdfsService.upLoad("demo.sh");
    }

    @PostMapping("/deleteFile")
    public void deleteFile() {
        hdfsService.deleteFile("demo.sh");
    }

    @PostMapping("/downLoad")
    public void downLoad() {
        hdfsService.downLoad("demo.sh");
    }

}
