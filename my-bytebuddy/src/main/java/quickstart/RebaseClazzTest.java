package quickstart;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 * 类变基(rebase)
 *
 * @author: cg1
 * @date: 2022-09-24 21:41
 **/
public class RebaseClazzTest {
    public static void main(String[] args) {
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println("hello bar".equals(foo.say()));


//        Foo foo1 = new Foo();
//        new ByteBuddy()
//                .redefine(Bar.class)
//                .name(Foo.class.getName())
//                .make()
//                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
//        System.out.println("hello bar".equals(foo.say()));


    }


    public static class Foo {

        public String say() {
            return "hello foo";
        }

    }

    public static class Bar {
        public String say() {
            return "hello bar";
        }
//使用 Java 的 HotSwap 功能有一个巨大的缺陷，HotSwap的当前实现要求重定义的类在重定义前后应用相同的类模式。 这意味着当重新加载类时，不允许添加方法或字段。
//        public  String say1() {
//            return "hello bar";
//        }
    }
}
