package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:45 2020/12/5
 * @description TODO:
 * @className FileController
 */
@Controller
public class FileController {
    @PostMapping("/upload")
    public String method1(MultipartFile file) throws IOException {
        System.out.println("文件上传...");
        System.out.println("文件大小: " + file.getSize());
        System.out.println("文佳名: " + file.getOriginalFilename());
        byte[] bytes = file.getBytes();
        //将数据存储到指定位置
        File f = new File("/home/ziy/Desktop/test/"+ file.getOriginalFilename());
        if (!f.exists()) {
            f.createNewFile();
        }
        try (FileOutputStream out = new FileOutputStream(f)) {
            out.write(bytes);
        }
        return "success";
    }
}
