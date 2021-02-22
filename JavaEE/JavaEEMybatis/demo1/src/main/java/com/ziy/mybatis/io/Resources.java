package com.ziy.mybatis.io;

import java.io.InputStream;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 * TODO:通过类加载器获取资源文件
 */
public class Resources {
    /**
     * 根据传入参数返回资源文件的字节输入流
     * @param filePath 资源文件名
     * @return 字节输入流
     */
    public static InputStream getResourceAsStream(String filePath) {
        System.out.println(filePath);
        InputStream in = Resources.class.getClassLoader().getResourceAsStream(filePath);
        System.out.println(in);
        return in;
    }
}
