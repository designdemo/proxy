package com.proxy.dbroute;

import com.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:42
 */
public class DbRouteDynamicProxyTest {
    public static void main(String[] args) {

        Order order = new Order();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
        try{
            Date parse = sdf.parse("2017/01/01");
            order.setCreateTime(parse.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        IOrderService instances = (IOrderService)new OrderServiceDynamicProxy().getInstances(new OrderServiceImpl());
        instances.createOrder(order);
    }

}
