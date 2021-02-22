package com.cool.index.news.news_json;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/20
 * TODO:新闻文章的JavaBean
 */
public class NewsArticle {
    private int id;
    private String title;
    private String imgUrl;
    private String time;
    private String smallTit;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSmallTitle() {
        return smallTit;
    }

    public void setSmallTitle(String smallTit) {
        this.smallTit = smallTit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
