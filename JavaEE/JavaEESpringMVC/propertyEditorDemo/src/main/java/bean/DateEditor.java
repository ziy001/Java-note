package bean;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午6:36 2020/11/30
 * @description TODO:
 * @className DateEditor
 */
public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //将传入的字符串进行处理
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = parser.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
