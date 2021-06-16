package com.dag.tinyioc;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:45 下午
 * @Description:
 */
public class HelloWorldService {

    private String text;

    public void hello() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
