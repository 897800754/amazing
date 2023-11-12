package cn.cg.unsafe;


/**
 * @author: cg
 * @date: 2023-03-21 16:30
 **/
public class InstanceDemo {
    public static void main(String[] args) throws InstantiationException {
        Object o = UnSafeUtils.getUnsafe().allocateInstance(Target.class);
        System.out.println(o);
//        A a = new A();
//        System.out.println(a);
    }


}
