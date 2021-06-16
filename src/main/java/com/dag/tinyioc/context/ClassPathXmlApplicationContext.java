package com.dag.tinyioc.context;

import com.dag.tinyioc.beans.BeanDefinition;
import com.dag.tinyioc.beans.factory.AbstractBeanFactory;
import com.dag.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.dag.tinyioc.beans.io.ResourceLoader;
import com.dag.tinyioc.beans.xml.xmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author: donganguo
 * @date: 2021/6/16 9:26 下午
 * @Description:
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }


    @Override
    public void refresh() throws Exception {
        xmlBeanDefinitionReader xmlBeanDefinitionReader = new xmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        //可选Lazy or preInstantiate
        beanFactory.preInstantiateSingletons();
    }
}
