package com.dag.tinyioc;

/**
 * @author: donganguo
 * @date: 2021/6/16 5:44 下午
 * @Description:
 */
public class BeanReference {

    private String name;

    private Object bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public BeanReference(String name) {
        this.name = name;
    }
}
