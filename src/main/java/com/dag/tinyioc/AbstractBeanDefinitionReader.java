package com.dag.tinyioc;

import com.dag.tinyioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: donganguo
 * @date: 2021/6/16 3:31 下午
 * @Description:
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
