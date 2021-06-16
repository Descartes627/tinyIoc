package com.dag.tinyioc.io;

import com.dag.tinyioc.beans.io.ResourceLoader;
import com.dag.tinyioc.beans.io.UrlResource;
import org.junit.Test;

/**
 * @author: donganguo
 * @date: 2021/6/16 4:20 下午
 * @Description:
 */
public class ResourceLoaderTest {

    @Test
    public void test() {
        UrlResource resource = (UrlResource) new ResourceLoader().getResource("tinyioc.xml");
        System.out.println(resource.getUrl());
    }

}