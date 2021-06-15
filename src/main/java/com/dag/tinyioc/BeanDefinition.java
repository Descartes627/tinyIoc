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

}
