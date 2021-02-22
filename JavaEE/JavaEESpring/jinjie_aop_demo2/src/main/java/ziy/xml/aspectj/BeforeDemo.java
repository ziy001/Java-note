package ziy.xml.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:53 2020/10/22
 * @description TODO:
 * @className Before
 */
public class BeforeDemo {
    private void perCheck() {
        System.out.println("====执行前的权限检查====");
    }
}
