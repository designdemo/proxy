package com.proxy.dbroute.proxy;

import com.proxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:32
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    Object proxyObj;

    public Object getInstances(Object proxyObj){
        this.proxyObj = proxyObj;
        Class<?> aClass = proxyObj.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object invoke = method.invoke(this.proxyObj, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("数据代理结束");
    }

    private void before(Object target) {
        try{
            Long createTime = (Long)target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(sdf.format(new Date(createTime)));
            System.out.println("静态代理类自动分配到【DB_"+ dbRouter +"】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
            System.out.println("数据代理准备开始");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
