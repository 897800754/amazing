package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 委托对象
 */
public class DynamicProxy implements InvocationHandler {
    //目标对象
    private Object target;

    //传入目标对象的入口,也可以是set方法
    public DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 覆盖java.lang.reflect.InvocationHandler的方法invoke()进行织入(增强)的操作。
     * 这个方法是给代理对象调用的，留心的是内部的method调用的对象是目标对象，可别写错。
     * 参数说明：
     * proxy是生成的代理对象，
     * method是代理的方法，
     * args是方法接收的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----before----");
        Object res = method.invoke(target, args);
        System.out.println("----after----");
        return res;

    }

}
