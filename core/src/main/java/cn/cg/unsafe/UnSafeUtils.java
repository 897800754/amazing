package cn.cg.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: cg
 * @date: 2023-03-21 15:38
 **/
public class UnSafeUtils {

    //检查classloader 是否是bootstrap classloader
    //  private static final Unsafe unsafe = Unsafe.getUnsafe();


    private static Unsafe unsafe;

    public static Unsafe getUnsafe() {
        return unsafe;
    }

    static {
        try {
            unsafe = reflectGetUnsafe();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private static Unsafe reflectGetUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

}
