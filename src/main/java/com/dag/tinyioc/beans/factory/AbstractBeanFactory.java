package com.dag.tinyioc.beans.factory;

import com.dag.tinyioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:33 下午
 * @Description:
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    
    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String beanDefinitionName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanDefinitionName);
        if (beanDefinition == null)
            throw new IllegalArgumentException("No bean named " + beanDefinitionName + " is defined");
        Object bean = beanDefinition.getBean();
        if (bean == null)
            bean = doCreateBean(beanDefinition);
        return bean;
    }

    //只注册BeanDefinition，实例化bean交给getBean()
    public void registerBeanDefinition(String beanDefinitionName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanDefinitionName, beanDefinition);
        beanDefinitionNames.add(beanDefinitionName);
    }
    
    public void preInstantiateSingletons() throws Exception{
        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
