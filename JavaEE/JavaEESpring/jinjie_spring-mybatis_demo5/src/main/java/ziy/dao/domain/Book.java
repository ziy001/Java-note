package ziy.dao.domain;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:27 2020/11/6
 * @description TODO:
 * @className Book
 */
public class Book {
    private int id;
    private String bookName;
    private String bookAuthor;
    private String bookMessage;

    public Book(Integer id, String bookName, String bookAuthor, String bookMessage) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookMessage = bookMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookMessage() {
        return bookMessage;
    }

    public void setBookMessage(String bookMessage) {
        this.bookMessage = bookMessage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookMessage='" + bookMessage + '\'' +
                '}';
    }
}
