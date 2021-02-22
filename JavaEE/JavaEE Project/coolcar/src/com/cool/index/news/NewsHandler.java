package com.cool.index.news;

import com.alibaba.fastjson.JSON;
import com.cool.index.news.news_json.NewsArticle;
import com.cool.util.SqlConnections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/20
 * TODO:用于处理消息资讯
 */
public class NewsHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先进行初始化
        resp.setCharacterEncoding("utf-8");
        //获取数据库链接
        String json = null;
        try(
                Connection conn = SqlConnections.getConnection();
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PrintWriter out = resp.getWriter()) {
            //结果集
            ResultSet rs = state.executeQuery("select * from news order by ctime desc limit 5");
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            rs.close();
            //填充离线Set
            crs.populate(rs);
            //通过获取的数据构造JSON数据
            json = json(crs);
            out.print(json);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private String json(CachedRowSet crs) throws SQLException {
        crs.beforeFirst();
        List<NewsArticle> list = new ArrayList<>();
        while(crs.next()) {
            //设置数据
            NewsArticle na = new NewsArticle();
            na.setId(crs.getInt(1));
            na.setImgUrl(crs.getString(2));
            na.setTitle(crs.getString(3));
            na.setSmallTitle(crs.getString(4));
            na.setTime(crs.getString(5));
            list.add(na);
        }
        return JSON.toJSONString(list);
    }
}
