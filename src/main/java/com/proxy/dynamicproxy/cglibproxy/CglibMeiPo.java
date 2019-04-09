package com.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:57
 */
public class CglibMeiPo implements MethodInterceptor {

    public Object getIntance(Object target){
        Class<?> aClass = target.getClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(aClass);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    private void before() {
        System.out.println("我是媒婆，我已经清楚你的要求，开始物色对象！！！");
    }

    private void after() {
        System.out.println("ok 准备办事吧！！！");
    }
}
