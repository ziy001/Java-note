package com.cool.index.lunbotu;

import com.alibaba.fastjson.JSON;
import com.cool.index.lunbotu.lunbotu_json.Data;
import com.cool.index.lunbotu.lunbotu_json.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/15
 */
public class LunBoTu extends HttpServlet {
    private static Data data = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setStatus(200);
        System.out.println(new Date() + "接受到请求");

        if(data == null) {
            data = new Data();
            //获取服务器ip/port
            String path = "E:\\ZIY\\AllProject\\Java_Idea_project\\JavaEE Project\\coolcar\\web\\img\\lunbo";
            String address = "http://" + req.getLocalAddr()+":"+ req.getLocalPort()+"/coolcar/img/lunbo/";
            //循环得到轮播图文件名，要求图片是jpg格式
            String[] names = new File(path)
                    .list((dir, name) -> name.endsWith(".jpg") ? true : false);
            //转换成JavaBean对象
            convert(address, names);
        }
        //将指定文件输出
        try(PrintWriter out = resp.getWriter()) {
            //使用FastJson将java转为json
            String s = JSON.toJSONString(data);
            out.print(s);
        }
    }
    private void convert(String address, String[] names) {
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            //存放数据
            Message message = new Message();
            message.setId(i+1);
            message.setImgUrl(address+names[i]);
            list.add(message);
        }
        data.setMessageList(list);
    }
}
