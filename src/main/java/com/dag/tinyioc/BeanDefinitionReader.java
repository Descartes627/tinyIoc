package com.dag.tinyioc;

/**
 * @author: donganguo
 * @date: 2021/6/16 3:30 下午
 * @Description:
 */
public interface BeanDefinitionReader {

    void loadBeanDefinition(String location) throws Exception;

}
