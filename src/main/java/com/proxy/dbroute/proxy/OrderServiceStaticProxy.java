package com.proxy.dbroute.proxy;

import com.proxy.dbroute.IOrderService;
import com.proxy.dbroute.Order;
import com.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:32
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private  IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public int createOrder(Order order) {
        before();

        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(new Date(createTime)));
        System.out.println("静态代理类自动分配到【DB_"+ dbRouter +"】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        iOrderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("数据代理结束");

    }

    private void before() {
        System.out.println("数据代理准备开始");
    }
}
