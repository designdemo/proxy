package com.proxy.dynamicproxy.jdkproxy;

import com.proxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * author:曲终、人散
 * Date:2019/4/8 22:02
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Person person = (Person)new JdkMeiPo().getIntance(girl);
        person.findLove();


        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("F://$Proxy0.class");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
