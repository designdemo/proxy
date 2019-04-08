package com.proxy.staticproxy;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:08
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father(son);

        father.findLove();
        System.out.println("完美");
    }

}
