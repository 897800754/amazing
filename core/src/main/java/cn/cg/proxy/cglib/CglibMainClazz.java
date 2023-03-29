package cn.cg.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: cg
 * @date: 2023-03-17 17:58
 **/
public class CglibMainClazz {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(Service.class.getClassLoader());
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback(new CglibProxy());

        Object o = enhancer.create();

        Service o1 = (Service) o;
        o1.action();
    }
}
