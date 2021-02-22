package ziy.viewresolver;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ZIY
 * @version 1.0
 * @date 下午8:42 2020/11/18
 * @description TODO:
 * @className JspViewResolver
 */
public class JspViewResolver extends InternalResourceViewResolver {
    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        AbstractUrlBasedView res = super.buildView(viewName);
        return res;
    }
}
