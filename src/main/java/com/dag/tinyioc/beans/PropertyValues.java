package com.dag.tinyioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: donganguo
 * @date: 2021/6/16 11:57 上午
 * @Description:
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
