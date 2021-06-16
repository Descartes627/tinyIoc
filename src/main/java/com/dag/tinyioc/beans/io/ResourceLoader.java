package com.dag.tinyioc.beans.io;

import java.net.URL;

/**
 * @author: donganguo
 * @date: 2021/6/16 3:27 下午
 * @Description:
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }

}
