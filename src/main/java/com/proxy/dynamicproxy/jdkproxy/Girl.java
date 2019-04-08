package com.proxy.dynamicproxy.jdkproxy;

import com.proxy.Person;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:56
 */
public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("女孩的要求：高富帅、有才华");
    }
}
