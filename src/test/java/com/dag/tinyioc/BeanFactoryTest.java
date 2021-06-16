package com.dag.tinyioc;

import com.dag.tinyioc.beans.BeanDefinition;
import com.dag.tinyioc.beans.factory.AbstractBeanFactory;
import com.dag.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.dag.tinyioc.beans.io.ResourceLoader;
import com.dag.tinyioc.beans.xml.xmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;


/**
 * @author: donganguo
 * @date: 2021/6/15 8:44 下午
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void testPreInstantiate() throws Exception {
        //1.解析xml
        xmlBeanDefinitionReader xmlBeanDefinitionReader = new xmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        //2.beanFactory初始化
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        beanFactory.preInstantiateSingletons();


        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

    @Test
    public void testLazy() throws Exception {
        //1.解析xml
        xmlBeanDefinitionReader xmlBeanDefinitionReader = new xmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        //2.beanFactory初始化
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }


        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

}