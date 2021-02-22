package ziy.service.serviceImpl;

import ziy.dao.domain.Book;
import ziy.dao.dao.BookMapper;
import ziy.service.service.BookService;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:30 2020/11/6
 * @description TODO:
 * @className BookServiceImpl
 */
public class BookServiceImpl implements BookService {
    /**
     * DAO层接口对象
     */
    private BookMapper bookMapper;

    /**
     * 设值注入
     * @param bookMapper
     */
    public void setBookMapper(BookMapper bookMapper) {
        System.out.println("===="+bookMapper.getClass()+"====");
        this.bookMapper = bookMapper;
    }

    @Override
    public int saveBook(Book book) {
        return this.bookMapper.saveBook(book);
    }

    @Override
    public Book getBook(int id) {
        return bookMapper.getBook(id);
    }
}
