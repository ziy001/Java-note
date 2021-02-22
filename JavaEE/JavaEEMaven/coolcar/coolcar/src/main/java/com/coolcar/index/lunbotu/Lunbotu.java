package com.coolcar.index.lunbotu;

import com.coolcar.bean.AllBean;
import com.coolcar.util.Sqls;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/24
 * TODO:轮播图数据接口类
 */
public class Lunbotu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //JavaBean
        List<Data> list = new ArrayList<>();
        AllBean all = new AllBean();
        all.setList(list);
        final String host = getServletContext().getInitParameter("host");
        try {
            //查询
            ResultSet rs = Sqls.sql("select * from lunbotu");

            rs.beforeFirst();
            while(rs.next()) {
                Data data = new Data();
                data.setId(rs.getInt(1));
                data.setImgUrl(host + rs.getString(2));
                list.add(data);
            }
            all.setStatu(0);
        } catch (SQLException e) {
            System.err.println("操作数据失败!");
            e.printStackTrace();
            all.setStatu(1);
        }

        //解析为JSON字符串返回
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(all);
        try(PrintWriter out = resp.getWriter();) {
            out.println(s);
        }
        System.out.println(req.getRemoteAddr()+"成功返回数据");
    }
}
