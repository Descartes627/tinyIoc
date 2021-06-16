package com.dag.tinyioc.context;

import com.dag.tinyioc.beans.BeanDefinition;
import com.dag.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author: donganguo
 * @date: 2021/6/16 9:02 下午
 * @Description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

}
