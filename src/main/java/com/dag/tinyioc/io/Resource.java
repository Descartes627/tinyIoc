package com.dag.tinyioc.io;

import java.io.InputStream;

/**
 * @author: donganguo
 * @date: 2021/6/16 3:24 下午
 * @Description:
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
