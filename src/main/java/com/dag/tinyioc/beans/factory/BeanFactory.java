package com.dag.tinyioc.beans.factory;

import com.dag.tinyioc.beans.BeanDefinition;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:31 下午
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

}
