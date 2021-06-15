package com.dag.tinyioc.factory;

import com.dag.tinyioc.BeanDefinition;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:40 下午
 * @Description:
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            //反射创建对象，注入属性
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
