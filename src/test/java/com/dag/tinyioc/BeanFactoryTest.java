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
    public void test() throws Exception {
        //1.初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.dag.tinyioc.HelloWorldService");


        //3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "hello world"));
        beanDefinition.setPropertyValues(propertyValues);

        //4.将beanDefinition注册到beanFactory
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        //5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}