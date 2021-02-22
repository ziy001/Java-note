package ziy.third;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:58 2020/10/24
 * @description TODO:
 * @className myGenerator
 */
public class myGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return null;
    }
}
