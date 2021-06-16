package com.dag.tinyioc.xml;


import com.dag.tinyioc.BeanDefinitionReader;
import com.dag.tinyioc.io.ResourceLoader;
import org.junit.Test;

/**
 * @author: donganguo
 * @date: 2021/6/16 4:24 下午
 * @Description:
 */
public class xmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        xmlBeanDefinitionReader beanDefinitionReader = new xmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinition("tinyioc.xml");
        System.out.println(beanDefinitionReader.getRegistry().size());
    }
}