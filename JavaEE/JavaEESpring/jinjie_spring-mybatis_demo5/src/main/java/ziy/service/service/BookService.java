package ziy.service.service;

import ziy.dao.domain.Book;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:29 2020/11/6
 * @description TODO:Service层接口
 * @className BookService
 */
public interface BookService {
    /**
     * 保存
     * @param book Book对象
     * @return
     */
    int saveBook(Book book);

    /**
     * 获取Book对象
     * @param id
     * @return
     */
    Book getBook(int id);
}
