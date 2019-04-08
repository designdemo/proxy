package com.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:57
 */
public class JdkMeiPo implements InvocationHandler {

    //拿到目标对象
    private Object target;

    public Object getIntance(Object target){
        this.target = target;
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("我是媒婆，我已经清楚你的要求，开始物色对象！！！");

    }

    private void after() {
        System.out.println("准备办事吧！！！");
    }
}
