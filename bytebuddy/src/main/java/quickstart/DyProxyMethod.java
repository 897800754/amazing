package quickstart;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 方法代理和自定义方法逻辑
 * 在前面的例子中，我们覆写了父类的toString()方法并返回了一个固定的值。
 *
 * 事实上，应用中需要的逻辑要比这个复杂很多。为动态类型提供自定义逻辑的一种有效方法是方法调用的委托。
 *
 * 方法委托
 *
 * @author: cg1
 * @date: 2022-09-24 20:49
 **/
public class DyProxyMethod {
    @SneakyThrows
    public static void main(String[] args) {
        String r = new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.named("sayHelloFoo")
                        .and(ElementMatchers.isDeclaredBy(Foo.class)
                                .and(ElementMatchers.returns(String.class))))
                //方法委托
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(DyProxyMethod.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .sayHelloFoo();
        /**
         * 调用sayHelloFoo()方法实际上会调用sayHelloBar()方法
         *
         * ByteBuddy怎么知道该调用Bar.class中的哪个方法？ByteBuddy根据方法签名、返回值类型、方法名、注解的顺序来匹配方法（越后面的优先级越高）。
         *
         * sayHelloFoo()方法和sayHelloBar()方法的方法名不一样，但是它们有相同的方法签名和返回值类型。
         */
        //false
        System.out.println(r.equals("hello bar"));
        //true
        System.out.println(r.equals("bar"));


    }


    public static class Foo {

        public String sayHelloFoo() {
            return "hello foo";
        }

    }


    public static class Bar {
        @BindingPriority(2)
        public static String sayHelloBar() {
            return "hello bar";
        }
        @BindingPriority(3)
        public static String sayBar() {
            return "bar";
        }

    }
}
