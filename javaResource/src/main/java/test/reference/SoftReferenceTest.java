package test.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 软引用
 * 当内存不足时,会回收
 *
 * @author: cg1
 * @date: 2021-07-14 23:11
 **/
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        test01();
    }

    /**
     * 引用对象被gc
     *
     * @throws InterruptedException
     */
    private static void test01() throws InterruptedException {
        int i = 200;
        ArrayList<SoftReference<byte[]>> softReferences = new ArrayList<>();
        while (i-- > 0) {
            byte[] bytes = new byte[1024 * 1024 * 10];
            SoftReference<byte[]> softReference = new SoftReference<>(bytes);
            System.out.println("当前引用对象为" + softReference.get());
            softReferences.add(softReference);
            i--;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        for (SoftReference softReference : softReferences) {
            System.out.println("当前引用对象为" + softReference.get());
        }
    }

}
