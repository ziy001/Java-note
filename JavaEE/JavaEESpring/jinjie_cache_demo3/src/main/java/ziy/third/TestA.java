package ziy.third;

import org.springframework.cache.annotation.*;

/**
 * @author ziy
 * @version 1.0
 * @date 下午3:45 2020/10/23
 * @description TODO:
 * @className TestA
 */
@CacheConfig(cacheNames = "default")
public class TestA {
    private static int step = 1;

    @Cacheable()
    public int aRun1(int i) {
        i += step;
        i++;
        return i;
    }
    @CacheEvict(allEntries = true)
    public void clear() {}
    @CachePut()
    public int update(int i) {
        i += step;
        i++;
        return i;
    }
}
