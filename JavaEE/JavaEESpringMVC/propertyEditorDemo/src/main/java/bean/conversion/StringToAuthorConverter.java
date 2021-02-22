package bean.conversion;

import bean.Author;
import org.springframework.core.convert.converter.Converter;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午6:46 2020/12/2
 * @description TODO:
 * @className StringToAuthorConverter
 */
public class StringToAuthorConverter implements Converter<String, Author> {
    @Override
    public Author convert(String s) {
        String[] args = s.split("-");
        return new Author(args[0], Integer.parseInt(args[1]));
    }
}
