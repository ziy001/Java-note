package ziy.four;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author ZIY
 * @version 1.0
 * @date 上午9:24 2020/11/23
 * @description TODO:
 * @className BTest
 */
@Cacheable(cacheNames = "default")
public class BTest {
    public static int i = 0;
    public void publicTest() {
        System.out.println("public");
    }
    protected void protectedTest() {
        System.out.println("protected");
    }
    void defaultTest() {
        System.out.println("default");
        privateTest();
    }
    private void privateTest() {
        System.out.println("private");
    }
}
