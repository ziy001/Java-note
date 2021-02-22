package ziy.own;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:17 2020/10/23
 * @description TODO:
 * @className ConcurrentMapDemo
 */
public class ConcurrentMapDemo {
    private static int i;
    public ConcurrentMapDemo() {
        System.out.println("创建成功");
    }
    @Cacheable(cacheNames = "default")
    public int test(int a) {
        a += i;
        i++;
        return a;

    }
}
