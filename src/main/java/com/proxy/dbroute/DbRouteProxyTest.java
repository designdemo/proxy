package com.proxy.dbroute;

import com.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:42
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {

        Order order = new Order();
//        order.setCreateTime(new Date().getTime());

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
        try{
            Date parse = sdf.parse("2017/01/01");
            order.setCreateTime(parse.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }


        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy(new OrderServiceImpl());
        orderServiceStaticProxy.createOrder(order);


    }

}
