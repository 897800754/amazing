package cn.cg.unsafe;

import lombok.Getter;

/**
 * @author: cg
 * @date: 2023-03-21 15:35
 **/
public class MemoryBarriers {
    /**
     * //内存屏障，禁止load操作重排序。屏障前的load操作不能被重排序到屏障后，屏障后的load操作不能被重排序到屏障前
     * public native void loadFence();
     * //内存屏障，禁止store操作重排序。屏障前的store操作不能被重排序到屏障后，屏障后的store操作不能被重排序到屏障前
     * public native void storeFence();
     * //内存屏障，禁止load、store操作重排序
     * public native void fullFence();
     * ------
     * 著作权归所有
     * 原文链接：https://javaguide.cn/java/basis/unsafe.html
     *
     * @param args
     */

    public static void main(String[] args) {
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            //  UnSafeUtils.getUnsafe().loadFence(); //加入读内存屏障
            if (flag) {
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");

    }

    @Getter
    public static class ChangeThread implements Runnable {
        /**
         * volatile
         **/
        //volatile
        boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("subThread change flag to:" + flag);
//            UnSafeUtils.getUnsafe().storeFence();
            flag = true;
        }
    }


}
