package ziy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ziy
 * @version 1.0
 * @date 下午6:58 2020/11/9
 * @description TODO:演示搜索Bean类
 * @className Demo1
 */
public class Demo1 {
    @Autowired(required = true)
    A a;
}
