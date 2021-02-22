package ziy.loader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author ziy
 * @version 1.0
 * @date 下午5:55 2020/10/21
 * @description TODO:
 * @className Loader
 */
public class Loader implements ResourceLoaderAware, ResourceLoader{
    ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Resource getResource(String s) {
        return new ClassPathResource(s);
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }
}
