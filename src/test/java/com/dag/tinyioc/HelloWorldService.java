package com.dag.tinyioc;

/**
 * @author: donganguo
 * @date: 2021/6/15 8:45 下午
 * @Description:
 */
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void hello() {
        System.out.println("helloWorldService call outputService");
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
