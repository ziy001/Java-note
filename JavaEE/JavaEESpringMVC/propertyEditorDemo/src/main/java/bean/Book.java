package bean;

import java.util.Date;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午3:44 2020/11/30
 * @description TODO:
 * @className Book
 */
public class Book {
    private Integer id;
    private String bookName;
    private Date publishDate;
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                '}';
    }
}
