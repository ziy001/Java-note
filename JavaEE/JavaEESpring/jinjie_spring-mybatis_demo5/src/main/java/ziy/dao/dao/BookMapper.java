package ziy.dao.dao;

import org.apache.ibatis.annotations.Param;
import ziy.dao.domain.Book;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:26 2020/11/6
 * @description TODO:DAO层接口
 * @className BookMapper
 */
public interface BookMapper {
    /**
     * 保存
     * @param book Book对象
     * @return
     */
    int saveBook(@Param("book") Book book);

    /**
     * 获取Book对象
     * @param id
     * @return
     */
    Book getBook(@Param("id") int id);
}
