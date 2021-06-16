package com.dag.tinyioc;

/**
 * @author: donganguo
 * @date: 2021/6/16 11:54 上午
 * @Description: 用于bean的属性注入
 */
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
