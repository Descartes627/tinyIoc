package com.dag.tinyioc.context;

import com.dag.tinyioc.HelloWorldService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: donganguo
 * @date: 2021/6/16 9:54 下午
 * @Description:
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");

        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.hello();
    }
}