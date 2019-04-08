package com.proxy.staticproxy;

/**
 * author:曲终、人散
 * Date:2019/4/8 21:06
 */
public class Father {

    //目标对象
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    //拿到目标对象的应用
    public void findLove(){
        System.out.println("父母开始物色对象");
        this.son.findLove();
        System.out.println("双方父母同意交往、确定关系");
    }
}
