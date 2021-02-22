package bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午4:03 2020/11/23
 * @description TODO:
 * @className Book
 */
@XmlRootElement
public class Book {
    private String bookName;
    private String author;
    private String document;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    public List<String> getList() {
        return List.of(bookName, author, document);
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
