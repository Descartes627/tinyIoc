package com.dag.tinyioc.factory;

import com.dag.tinyioc.BeanDefinition;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:31 下午
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;
}
