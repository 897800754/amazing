package quickstart;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 方法和字段定义
 * 我们可以在我们动态创建的类中覆写父类中的方法了。让我们更进一步，在我们的类中添加一个新的方法和一个新的字段。
 * @author: cg1
 * @date: 2022-09-24 21:04
 **/
public class MethodAndFieldTest1 {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * 我们创建了一个叫做MyClassName的类，它是Object.class的子类。然后我们定义了一个方法，叫做custom，它是public的，同时返回String。
         *
         * 就像之前的例子，我们通过代理方法请求给Bar.class实现我们的方法。
         */
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("MyClassName")
                .defineMethod("custom", String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                .defineField("x", String.class, Modifier.PUBLIC)
                .make()
                .load(MethodAndFieldTest1.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();


        Object o = type.newInstance();

        //bar
        Method m = type.getDeclaredMethod("custom", null);

        System.out.println(m.invoke(o));

        Field x = type.getField("x");
        Object o1 = x.get(o);
        //null
        System.out.println(o1);
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
