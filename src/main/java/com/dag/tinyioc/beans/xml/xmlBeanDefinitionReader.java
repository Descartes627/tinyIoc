package com.dag.tinyioc.beans.xml;

import com.dag.tinyioc.beans.AbstractBeanDefinitionReader;
import com.dag.tinyioc.beans.BeanDefinition;
import com.dag.tinyioc.BeanReference;
import com.dag.tinyioc.beans.PropertyValue;
import com.dag.tinyioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author: donganguo
 * @date: 2021/6/16 3:38 下午
 * @Description:
 */
public class xmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public xmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    //从xml加载bean到registry
    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(inputStream);
    }

    //从inputStream加载bean到registry
    protected void doLoadBeanDefinition(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    //从Document加载bean到registry
    protected void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);
    }

    //从Document里的root节点到加载所有bean到registry
    protected void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinitions(element);
            }
        }
    }

    //处理一个bean(element),注册到registry
    protected void processBeanDefinitions(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        //element属性注入beanDefinition
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    //将一个element的所有属性注入beanDefinition
    protected void processProperty(Element element, BeanDefinition beanDefinition) {

        NodeList propertyList = element.getElementsByTagName("property");
        for (int i = 0; i < propertyList.getLength(); i++) {
            Node node = propertyList.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                }
                else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0)
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    BeanReference beanReference = new BeanReference(name);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

}
