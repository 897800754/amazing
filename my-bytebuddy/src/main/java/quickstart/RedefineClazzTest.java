package quickstart;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 重定义一个已经存在的类
 *
 * @author: cg1
 * @date: 2022-09-24 21:09
 **/
public class RedefineClazzTest {

    public static void main(String[] args) {
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(Foo.class)
                .method(ElementMatchers.named("sayHelloFoo"))
                .intercept(FixedValue.value("Hello Foo Redefined"))
                .make()
                .load(
                        Foo.class.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());

        Foo f = new Foo();

        System.out.println("Hello Foo Redefined".equals(f.sayHelloFoo()));
    }


    public static class Foo {

        public String sayHelloFoo() {
            return "hello foo";
        }

    }
}
