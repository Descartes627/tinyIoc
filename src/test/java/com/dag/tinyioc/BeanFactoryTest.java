package com.dag.tinyioc;

import com.dag.tinyioc.factory.AutowireCapableBeanFactory;
import com.dag.tinyioc.factory.BeanFactory;
import org.junit.Test;


/**
 * @author: donganguo
 * @date: 2021/6/15 8:44 下午
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClass(HelloWorldService.class);
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}