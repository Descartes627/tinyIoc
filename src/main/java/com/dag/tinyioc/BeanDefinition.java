package com.dag.tinyioc;

import lombok.Data;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:27 下午
 * @Description:
 */
@Data
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues;

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
