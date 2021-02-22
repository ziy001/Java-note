package ziy.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ziy
 * @version 1.0
 * @date 上午9:12 2020/11/7
 * @description TODO:
 * @className BeanHandler
 */
public class BeanHandler implements BeanPostProcessor {

    /**
     * Bean后处理器的前部分
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====Bean后处理器的before部分执行====");
        return null;
    }

    /**
     * Bean后处理器的后部分
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====Bean后处理器的after部分执行====");
        return null;
    }
}
