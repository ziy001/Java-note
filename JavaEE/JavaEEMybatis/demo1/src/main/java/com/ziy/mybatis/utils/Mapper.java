package com.ziy.mybatis.utils;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/29
 * TODO:封装映射配置文件的每一个mapper标签的内容
 */
public class Mapper {
    //sql语句
    private String queryString;

    //dao层接口
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "queryString='" + queryString + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}
