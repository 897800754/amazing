package quickstart;

import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.annotation.Annotation;

/**
 * add 注解
 * <p>
 * 原来注解也可以实现
 *
 * @author: cg1
 * @date: 2022-09-24 22:09
 **/
public class AddAnnotationTest implements AnnotationTest {
    @Override
    public Class<? extends Annotation> annotationType() {
        return AnnotationTest.class;
    }

    @SneakyThrows
    public static void main(String[] args) {

        DynamicType.Unloaded<Foo> make = new ByteBuddy()
                .subclass(Foo.class)
                //annotateType
                .annotateType(new AddAnnotationTest())
                .method(ElementMatchers.named("sayHelloFoo"))
                .intercept(FixedValue.value("123"))
                //给方法加上注解 --->>>annotateMethod
                .annotateMethod(new AddAnnotationTest())
                .make();

        Class<?> loaded = make.load(AddAnnotationTest.class.getClassLoader()).getLoaded();

        Object o = loaded.newInstance();


        AnnotationDescription build = AnnotationDescription.Builder.ofType(AnnotationTest.class).build();

        System.out.println("instance:" + o);

        System.out.println("exec method:" + loaded.getMethod("sayHelloFoo").invoke(o));


        Annotation[] annotations = loaded.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


    }

    public static class Foo {

        public String sayHelloFoo() {
            return "hello foo";
        }

    }
}
