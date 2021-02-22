package ziy.viewresolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午6:48 2020/11/18
 * @description TODO:
 * @className JsonViewResolver
 */
public class JsonViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        var view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
}
