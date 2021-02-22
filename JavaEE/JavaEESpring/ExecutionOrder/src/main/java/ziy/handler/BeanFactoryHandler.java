package ziy.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:17 2020/11/7
 * @description TODO:
 * @className BeanFactoryHandler
 */
public class BeanFactoryHandler implements BeanFactoryPostProcessor {
    /**
     * 容器后处理器
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("====容器后处理器执行====");
    }
}
