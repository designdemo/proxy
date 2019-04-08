package com.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * author:曲终、人散
 * Date:2019/4/8 22:27
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
