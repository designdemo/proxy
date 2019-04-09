package com.proxy.dynamicproxy.cglibproxy;

/**
 * author:曲终、人散
 * Date:2019/4/8 22:02
 */
public class CglibProxyTest {
    public static void main(String[] args) {

        Customer intance = (Customer)new CglibMeiPo().getIntance(new Customer());
        intance.findLove();

    }

}
