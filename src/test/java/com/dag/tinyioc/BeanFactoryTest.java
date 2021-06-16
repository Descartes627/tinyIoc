package com.dag.tinyioc;

import com.dag.tinyioc.factory.AbstractBeanFactory;
import com.dag.tinyioc.factory.AutowireCapableBeanFactory;
import com.dag.tinyioc.factory.BeanFactory;
import com.dag.tinyioc.io.ResourceLoader;
import com.dag.tinyioc.xml.xmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;


/**
 * @author: donganguo
 * @date: 2021/6/15 8:44 下午
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        //1.初始化beanFactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        xmlBeanDefinitionReader xmlBeanDefinitionReader = new xmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        beanFactory.preInstantiateSingletons();


        //5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}