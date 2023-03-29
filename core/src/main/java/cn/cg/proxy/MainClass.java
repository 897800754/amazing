package cn.cg.proxy;

import java.lang.reflect.Proxy;


public class MainClass {
    public static void main(String[] args) {
        //希望被代理的目标业务类
        UserService target = new UserServiceImpl();
        // //将目标类和横切类编织在一起
//        DynamicProxy handler = new DynamicProxy(target);
        DynamicProxy handler = new DynamicProxy(target);
        //创建代理实例，它可以看作是要代理的目标业务类的加多了横切代码(方法)的一个子类
        //创建代理实例(使用Proxy类和自定义的调用处理逻辑(handler)来生成一个代理对象)
        //代理对象 继承proxy,实现UserServiceImpl所实现的接口,与UserServiceImpl无关
        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.add("1111");
        //System.out.println(proxy);
    }
}
