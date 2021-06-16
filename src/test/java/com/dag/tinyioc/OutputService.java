package com.dag.tinyioc;

import org.junit.Assert;

/**
 * @author: donganguo
 * @date: 2021/6/16 8:05 下午
 * @Description:
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println("outputService print " + text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
