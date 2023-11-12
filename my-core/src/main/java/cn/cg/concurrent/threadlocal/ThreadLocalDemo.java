package cn.cg.concurrent.threadlocal;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cg
 * @date: 2023-03-23 13:14
 **/
public class ThreadLocalDemo {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>();

    public static void main(String[] args) throws Exception {
        THREAD_LOCAL.set("acb");
        // test0();
        // test1();
        test2();
    }

    private static void test2() {
        Object object = new Object();
        WeakReference<Object> weakReference1 = new WeakReference<>(object);
        //java.lang.Object@6f496d9f
        System.out.println(weakReference1.get());
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        //java.lang.Object@6f496d9f
        System.out.println(weakReference1.get());
        //unlink 强引用
        object = null;
        System.gc();
        //null
        System.out.println(weakReference1.get());
    }


    public static void test0() throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
            stringThreadLocal.set("123");
        });
        Thread.sleep(1000 * 1000);
    }

    public static void test1() throws Exception {
        Map<WeakReference<Integer>, WeakReference<Integer>> map = new HashMap<>(8);
        // 注意这里~
        WeakReference<Integer> key = new WeakReference<>(1);
        WeakReference<Integer> value = new WeakReference<>(2);
        map.put(key, value);
        System.out.println("put success");
        Thread.sleep(1000);
        System.gc();
        System.out.println("get " + map.get(key).get());

    }



}
